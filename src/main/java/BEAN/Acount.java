package BEAN;

public class Acount {
	private int id;
	private String name;
	private String pass;
	private int Isadmin;
	private int isSell;
	
	public Acount(int id, String name, String pass, int isadmin, int isSell) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		Isadmin = isadmin;
		this.isSell = isSell;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getIsadmin() {
		return Isadmin;
	}
	public void setIsadmin(int isadmin) {
		Isadmin = isadmin;
	}
	public int getIsSell() {
		return isSell;
	}
	public void setIsSell(int isSell) {
		this.isSell = isSell;
	}
	
	
	
	
}
