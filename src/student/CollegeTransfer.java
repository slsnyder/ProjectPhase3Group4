package student;

/**
 * 
 * @author Sarah Snyder
 *
 */
public class CollegeTransfer {
	private String mSchoolName;
	private double mGpa;
	private String mTransferYear;
	
	public CollegeTransfer(String schoolName, double gpa, String transferYear) {
		this.setSchoolName(schoolName);
		this.setGpa(gpa);
		this.setTransferYear(transferYear);
	}

	/** @return name of the transfer college */
	public String getSchoolName() {
		return mSchoolName;
	}

	public void setSchoolName(String schoolName) {
		int len = schoolName.length();
		if(len < 3 || len > 50) {
			throw new IllegalArgumentException("Invalid school name.");
		}
		mSchoolName = schoolName;
	}

	/** @return the student's transfer GPA */
	public double getGpa() {
		return mGpa;
	}

	public void setGpa(double gpa) {
		if(gpa < 0 || gpa > 4) {
			throw new IllegalArgumentException("Invalid GPA.");
		}
		mGpa = gpa;
	}

	/** @return the year in which the student last attended this school */
	public String getTransferYear() {
		return mTransferYear;
	}

	public void setTransferYear(String transferYear) {
		if (transferYear.length() != 4) {
			throw new IllegalArgumentException("Invalid transfer year.");
		}
		mTransferYear = transferYear;
	}
	
}
