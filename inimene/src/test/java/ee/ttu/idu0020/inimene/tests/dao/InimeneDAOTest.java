package ee.ttu.idu0020.inimene.tests.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ee.ttu.idu0020.inimene.Inimene;
import ee.ttu.idu0020.inimene.dao.InimeneDAO;
import ee.ttu.idu0020.inimene.web.DBConnection;

public class InimeneDAOTest {

	@Before
	public void setUp() {
		DBConnection.initConnection();
	}

	@After
	public void tearDown() {
		DBConnection.close();
	}

	@Test
	public void testSelect() throws Exception {

		InimeneDAO dao = new InimeneDAO(DBConnection.getConnection());

		List<Inimene> inimesed = dao.getInimesed();

		Inimene i = new Inimene();
		i.setNumber(25);
		i.setName1("xxx");
		i.setName2("yyy");
		i.setBday(toDate("2013-10-10"));
		dao.addInimene(i);

		List<Inimene> inimesed2 = dao.getInimesed();

		dao.deleteInimene(i);

		Assert.assertEquals(inimesed.size() + 1, inimesed2.size());
	}

	@Test
	public void testAdd() throws Exception {

		InimeneDAO dao = new InimeneDAO(DBConnection.getConnection());

		Inimene i = new Inimene();
		i.setNumber(25);
		i.setName1("xxx");
		i.setName2("yyy");
		i.setBday(toDate("2013-10-10"));

		dao.addInimene(i);

		Assert.assertNotEquals(-1, i.getId());

		Inimene i2 = dao.getInimene(i.getId());

		dao.deleteInimene(i);

		Assert.assertNotNull(i2);
		Assert.assertEquals(i.getNumber(), i2.getNumber());
		Assert.assertEquals(i.getName1(), i2.getName1());
		Assert.assertEquals(i.getName2(), i2.getName2());
		Assert.assertEquals(i.getBday(), i2.getBday());
	}

	@Test
	public void testUpdate() throws Exception {

		InimeneDAO dao = new InimeneDAO(DBConnection.getConnection());

		Inimene i = new Inimene();
		i.setNumber(25);
		i.setName1("xxx");
		i.setName2("yyy");
		i.setBday(toDate("2013-10-10"));
		dao.addInimene(i);

		i.setNumber(55);
		i.setName1("www");
		i.setName2("zzz");
		i.setBday(null);
		dao.updateInimene(i);

		Inimene i2 = dao.getInimene(i.getId());

		dao.deleteInimene(i);

		Assert.assertNotNull(i2);
		Assert.assertEquals(i.getNumber(), i2.getNumber());
		Assert.assertEquals(i.getName1(), i2.getName1());
		Assert.assertEquals(i.getName2(), i2.getName2());
		Assert.assertEquals(i.getBday(), i2.getBday());
	}

	private Date toDate(String inimene_bday) {

		if (inimene_bday == null) {
			return null;
		}

		try {
			new Date(inimene_bday);
			return new SimpleDateFormat("yyyy-MM-dd").parse(inimene_bday);

		} catch (ParseException e) {

			return null;
		}
	}

}
