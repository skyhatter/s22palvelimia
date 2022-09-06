package s22.Listaanlisays.domain;

public class Friend {
	private String fname, lname;

	public Friend(String fname, String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "Friend [fname=" + fname + ", lname=" + lname + "]";
	}
	
}
