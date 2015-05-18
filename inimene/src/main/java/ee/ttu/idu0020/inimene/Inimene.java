package ee.ttu.idu0020.inimene;

import java.sql.Date;

public class Inimene {

	private long id;
	private Integer inimene_number;
	private String inimene_name1;
	private String inimene_name2;
	private Date inimene_bday;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return inimene_number;
	}

	public void setNumber(Integer inimene_number) {
		this.inimene_number = inimene_number;
	}

	public String getName1() {
		return inimene_name1;
	}

	public void setName1(String inimene_name1) {
		this.inimene_name1 = inimene_name1;
	}

	public String getName2() {
		return inimene_name2;
	}

	public void setName2(String inimene_name2) {
		this.inimene_name2 = inimene_name2;
	}


	public Date getBday() {
		return inimene_bday;
	}

	public void setBday(Date inimene_bday) {
		this.inimene_bday = inimene_bday;
	}

}
