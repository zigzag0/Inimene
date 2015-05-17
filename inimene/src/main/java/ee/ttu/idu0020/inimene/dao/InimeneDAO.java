package ee.ttu.idu0020.inimene.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import ee.ttu.idu0020.inimene.Inimene;

public class InimeneDAO {

	private Connection con;

	public InimeneDAO(Connection con) {
		this.con = con;
	}

	public List<Inimene> getInimesed() throws SQLException {
		List<Inimene> inimesed = new ArrayList<Inimene>();
		PreparedStatement pst = con
				.prepareStatement("SELECT * FROM inimesed_v2 ORDER BY inimesed_v2.inimene_number"); // SELECT TABELI NIMI
//				.prepareStatement("SELECT * FROM inimesed_v2 where id = ? ORDER BY inimene_number"); //MySQL
		try {
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Inimene i = new Inimene();
				i.setId(rs.getLong("id"));
				i.setNumber(rs.getObject("inimene_number") == null ? null : rs
						.getInt("inimene_number"));
				i.setName1(rs.getString("inimene_name1"));
				i.setName2(rs.getString("inimene_name2"));

//				i.setBday(rs.getObject("inimene_bday") == null ? null : rs
//						.getDate("inimene_bday"));

				inimesed.add(i);
			}
		} finally {
			pst.close();
		}

		return inimesed;
	}

	public Inimene getInimene(long id) throws SQLException {
		PreparedStatement pst = con
				.prepareStatement("SELECT * FROM inimesed_v2 ORDER BY inimesed_v2.inimene_number");
//				.prepareStatement("SELECT * FROM inimesed_v2 where id = ? ORDER BY inimene_number"); //MySQL
		pst.setLong(1, id);

		try {
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Inimene i = new Inimene();
				i.setId(rs.getLong("id"));
				i.setNumber(rs.getObject("inimene_number") == null ? null : rs
						.getInt("inimene_number"));
				i.setName1(rs.getString("inimene_name1"));
				i.setName2(rs.getString("inimene_name2"));

//				i.setBday(rs.getObject("inimene_bday") == null ? null : rs
//						.getDate("inimene_bday"));
				return i;
			}
		} finally {
			pst.close();
		}

		return null;
	}

	// Andmete lisamine tabelisse.
	public void addInimene(Inimene i) throws SQLException {
		PreparedStatement pst = con
				.prepareStatement("INSERT INTO inimesed_v2( inimene_number, inimene_name1,inimene_name2) VALUES (?, ?, ?) returning id");
//				.prepareStatement("INSERT INTO inimesed_v2 (inimene_number, inimene_name1, inimene_name2, inimene_bday) values (?, ?, ?, ?) returning id"); //MySQL
		try {
			pst.setString(1, i.getName1());
			pst.setString(2, i.getName2());
			if (i.getNumber() == null) {
				pst.setNull(3, Types.INTEGER);
			} else {
				pst.setInt(3, i.getNumber());
			}
/*
			if (i.getBday() == null) {
				pst.setNull(4, Types.DATE);
			} else {
				pst.setDate(4, i.getBday());
			}
*/
			ResultSet rs = pst.executeQuery();
			rs.next();
			i.setId(rs.getLong(1));
		} finally {
			pst.close();
		}
	}



	public void updateInimene(Inimene i) throws SQLException {
		PreparedStatement pst = con
				.prepareStatement("UPDATE inimesed_v2 SET inimene_number = ?, inimene_name1 = ?, inimene_name2 = ?, inimene_bday = ?, where id = ?");
//				.prepareStatement("UPDATE inimesed_v2 SET inimene_number = ?, inimene_name1 = ?, inimene_name2 = ?, inimene_bday = ?, where id = ?"); //MySQL
		try {
			pst.setString(1, i.getName1());
			pst.setString(2, i.getName2());
			if (i.getNumber() == null) {
				pst.setNull(3, Types.INTEGER);
			} else {
				pst.setInt(3, i.getNumber());
			}
/*			if (i.getBday() == null) {
				pst.setNull(4, Types.DATE);
			} else {
				pst.setDate(4, i.getBday());
			}
*/
			pst.setLong(5, i.getId());

			pst.executeUpdate();
		} finally {
			pst.close();
		}
	}

	public void deleteInimene(Inimene i) throws SQLException {
		PreparedStatement pst = con
				.prepareStatement("DELETE FROM inimesed_v2 WHERE id = ?"); // Andmete
																			// tabelist
																			// kustutamine
		try {
			pst.setLong(1, i.getId());
			pst.executeUpdate();
		} finally {
			pst.close();
		}
	}
}
