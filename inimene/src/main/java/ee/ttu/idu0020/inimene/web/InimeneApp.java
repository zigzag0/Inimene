package ee.ttu.idu0020.inimene.web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ee.ttu.idu0020.inimene.Inimene;
import ee.ttu.idu0020.inimene.InimeneValidator;
import ee.ttu.idu0020.inimene.dao.InimeneDAO;

@WebServlet(value = { "/" }, loadOnStartup = 1)
public class InimeneApp extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String path = req.getServletPath();

		if (path.startsWith("/")) {
			path = path.substring(1);
		}

		try {

			if ("log.txt".equals(path)) {

				// do nothing
				req.getRequestDispatcher("/" + path).forward(req, res);
				return;

			} else if ("add".equals(path)) {

				req.setAttribute("inimene", new Inimene());
				req.setAttribute("errors", Collections.emptyMap());

			} else if ("update".equals(path)) {

				long id = getID(req);

				if (id == -1) {
					res.sendRedirect(req.getContextPath());
					return;
				}

				Inimene inimene = new InimeneDAO(DBConnection.getConnection())
						.getInimene(id);
				if (inimene == null) {
					res.sendRedirect(req.getContextPath());
					return;
				}

				req.setAttribute("inimene", inimene);
				req.setAttribute("errors", Collections.emptyMap());

			} else if ("delete".equals(path)) {

				long id = getID(req);

				if (id == -1) {
					res.sendRedirect(req.getContextPath());
					return;
				}

				InimeneDAO dao = new InimeneDAO(DBConnection.getConnection());
				Inimene i = dao.getInimene(id);
				if (i == null) {
					res.sendRedirect(req.getContextPath());
					return;
				}
				i.setId(id);

				dao.deleteInimene(i);
				res.sendRedirect(req.getContextPath());
				return;

			} else {

				path = "show";

				List<Inimene> inimesed;
				try {
					inimesed = new InimeneDAO(DBConnection.getConnection())
							.getInimesed();
				} catch (SQLException e) {
					throw new ServletException(e);
				}

				req.setAttribute("inimesed", inimesed);
			}

		} catch (SQLException e) {

			throw new ServletException(e);

		}

		req.getRequestDispatcher(path + ".jsp").forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String path = req.getServletPath();

		if (path.startsWith("/")) {
			path = path.substring(1);
		}

		try {

			if ("add".equals(path)) {

				Inimene i = new Inimene();
				i.setName1(getName1(req));
				i.setName2(getName2(req));
				i.setNumber(getNumber(req));
				i.setBday(getBday(req));
				InimeneDAO dao = new InimeneDAO(DBConnection.getConnection());

				InimeneValidator v = new InimeneValidator();
				Map<String, String> errors = v.validate(i);
				if (!errors.isEmpty()) {
					req.setAttribute("errors", errors);
					req.setAttribute("inimene", i);
					req.getRequestDispatcher("add.jsp").forward(req, res);
					return;
				}
				dao.addInimene(i);

			} else if ("update".equals(path)) {

				long id = getID(req);

				if (id == -1) {
					res.sendRedirect(req.getContextPath());
					return;
				}

				InimeneDAO dao = new InimeneDAO(DBConnection.getConnection());
				Inimene i = dao.getInimene(id);
				if (i == null) {
					res.sendRedirect(req.getContextPath());
					return;
				}
				i.setId(id);
				i.setName1(getName1(req));
				i.setName2(getName2(req));
				i.setNumber(getNumber(req));
				i.setBday(getBday(req));

				InimeneValidator v = new InimeneValidator();
				Map<String, String> errors = v.validate(i);
				if (!errors.isEmpty()) {
					req.setAttribute("errors", errors);
					req.setAttribute("inimene", i);
					req.getRequestDispatcher("update.jsp").forward(req, res);
					return;
				}

				dao.updateInimene(i);

			}

		} catch (SQLException e) {

			throw new ServletException(e);

		}

		res.sendRedirect(req.getContextPath());
	}

	private String getName1(HttpServletRequest req) {
		return req.getParameter("inimene_name1");
	}

	private String getName2(HttpServletRequest req) {
		return req.getParameter("inimene_name2");
	}

	private long getID(HttpServletRequest req) {
		String id = req.getParameter("id");

		if (id == null) {
			return -1;
		}

		try {
			return Long.parseLong(id);
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	private Integer getNumber(HttpServletRequest req) {
		String inimene_number = req.getParameter("inimene_number");

		if (inimene_number == null) {
			return null;
		}

		try {
			return Integer.valueOf(inimene_number);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	private Date getBday(HttpServletRequest req) {
		String inimene_bday = req.getParameter("inimene_bday");

		if (inimene_bday == null) {
			return null;
		}

		try { // return new Date(inimene_bday);
			return new SimpleDateFormat("yyyy-MM-dd").parse(inimene_bday);

		} catch (ParseException e) {

			return null;
		}
	}

}
