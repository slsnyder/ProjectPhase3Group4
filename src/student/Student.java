package student;

// TODO input validation

public class Student {
	
	private String mId;
	private String mLastName;
	private String mFirstName;
	private String mAcademicProgram;
	private String mDegreeLevel;
	private String mGradTerm;
	private String mGradYear;
	private double mGpa;
	private String mUwEmail;
	private String mExternalEmail;
	
	
	/** @return student id */
	public String getId() {
		return mId;
	}

	/** @return last name */
	public String getLastName() {
		return mLastName;
	}

	public void setLastName(String lastName) {
		mLastName = lastName;
	}

	/** @return first name */
	public String getFirstName() {
		return mFirstName;
	}

	public void setFirstName(String firstName) {
		mFirstName = firstName;
	}

	/** @return academic program */
	public String getAcademicProgram() {
		return mAcademicProgram;
	}

	public void setAcademicProgram(String academicProgram) {
		mAcademicProgram = academicProgram;
	}

	/** @return degree level */
	public String getDegreeLevel() {
		return mDegreeLevel;
	}

	public void setDegreeLevel(String degreeLevel) {
		mDegreeLevel = degreeLevel;
	}

	/** @return graduation term */
	public String getGradTerm() {
		return mGradTerm;
	}

	public void setGradTerm(String gradTerm) {
		mGradTerm = gradTerm;
	}

	/** @return graduation year */
	public String getGradYear() {
		return mGradYear;
	}

	public void setGradYear(String gradYear) {
		mGradYear = gradYear;
	}

	/** @return grade point average */
	public double getGpa() {
		return mGpa;
	}

	public void setGpa(double gpa) {
		mGpa = gpa;
	}

	/** @return UW email address */
	public String getUwEmail() {
		return mUwEmail;
	}

	public void setUwEmail(String uwEmail) {
		mUwEmail = uwEmail;
	}

	/** @return external (non-UW) email address */
	public String getExternalEmail() {
		return mExternalEmail;
	}

	public void setExternalEmail(String externalEmail) {
		mExternalEmail = externalEmail;
	}
	
	
	
}
