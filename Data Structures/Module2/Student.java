import java.util.Date;
class Student {
	private String name;
	private double maths;
	private double genScience;
	private double eng;
	private double social;
	private double firstLan;
	private int hallticNo;
	private Date dateOfBirth;
	public Student(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setMaths(double maths) {
		this.maths = maths;
	}
	public double getMaths() {
		return maths;
	}
	public void setGenSci(double genScience) {
		this.genScience = genScience;
	}
	public double getGenSci() {
		return genScience;
	}
	public void setEng(double eng) {
		this.eng = eng;
	}
	public double getEng() {
		return eng;
	}
	public void setSocial(double social) {
		this.social = social;
	}
	public double getSocial() {
		return social;
	}
	public void setFirstLan(double firstLan) {
		this.firstLan = firstLan;
	}
	public double getFirstLan() {
		return firstLan;
	}
	public void setHtno(int hallticNo) {
		this.hallticNo = hallticNo;
	}
	public int getHtno() {
		return hallticNo;
	}
	public void setDOB(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getDOB() {
		return dateOfBirth;
	}
}