package student;

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

	// TODO transfer/ internship/ employment
	
	public Student(String id, String lastName, String firstName, 
			String academicProgram, String degreeLevel, String gradTerm, 
			String gradYear, double gpa, String uwEmail, String externalEmail) {
		
		this.setId(id);
		this.setLastName(lastName);
		this.setFirstName(firstName);
		this.setAcademicProgram(academicProgram);
		this.setDegreeLevel(degreeLevel);
		this.setGradTerm(gradTerm);
		this.setGradYear(gradYear);
		this.setGpa(gpa);
		this.setUwEmail(uwEmail);
		this.setExternalEmail(externalEmail);
	}

	/** @return student id */
	public String getId() {
		return mId;
	}

	private void setId(String id) {
		Integer idNum = Integer.parseInt(id);
		if (idNum < 0 || idNum > 9999999) {
			throw new IllegalArgumentException("Invalid student ID number.");
		}
		mId = id;
	}

	/** @return last name */
	public String getLastName() {
		return mLastName;
	}

	public void setLastName(String lastName) {
		int len = lastName.length();
		if (len < 2 || len > 25) {
			throw new IllegalArgumentException("Invalid last name.");
		}
		mLastName = lastName;
	}

	/** @return first name */
	public String getFirstName() {
		return mFirstName;
	}

	public void setFirstName(String firstName) {
		int len = firstName.length();
		if (len < 2 || len > 25) {
			throw new IllegalArgumentException("Invalid first name.");
		}
		mFirstName = firstName;
	}

	/** @return academic program */
	public String getAcademicProgram() {
		return mAcademicProgram;
	}

	public void setAcademicProgram(String academicProgram) {
		int len = academicProgram.length();
		if (len == 0 || len > 3) {
			throw new IllegalArgumentException("Invalid academic program.");
		}
		mAcademicProgram = academicProgram;
	}

	/** @return degree level */
	public String getDegreeLevel() {
		return mDegreeLevel;
	}

	public void setDegreeLevel(String degreeLevel) {
		int len = degreeLevel.length();
		if (len < 2 || len > 3) {
			throw new IllegalArgumentException("Invalid degree level.");
		}
		mDegreeLevel = degreeLevel;
	}

	/** @return graduation term */
	public String getGradTerm() {
		return mGradTerm;
	}

	public void setGradTerm(String gradTerm) {
		if (gradTerm.length() != 6) {
			throw new IllegalArgumentException("Invalid graduation term.");
		}
		mGradTerm = gradTerm;
	}

	/** @return graduation year */
	public String getGradYear() {
		return mGradYear;
	}

	public void setGradYear(String gradYear) {
		if (gradYear.length() != 4) {
			throw new IllegalArgumentException("Invalid graduation year.");
		}
		mGradYear = gradYear;
	}

	/** @return grade point average */
	public double getGpa() {
		return mGpa;
	}

	public void setGpa(double gpa) {
		if(gpa < 0 || gpa > 4) {
			throw new IllegalArgumentException("Invalid GPA.");
		}
		mGpa = gpa;
	}

	/** @return UW email address */
	public String getUwEmail() {
		return mUwEmail;
	}

	public void setUwEmail(String uwEmail) {
		int len = uwEmail.length();
		if(len < 8 ||
				len > 15 ||
				!uwEmail.endsWith("@uw.edu")) {
					throw new IllegalArgumentException("Invalid UW email address.");
				}
		mUwEmail = uwEmail;
	}

	/** @return external (non-UW) email address */
	public String getExternalEmail() {
		return mExternalEmail;
	}

	public void setExternalEmail(String externalEmail) {
		int len = externalEmail.length();
		if(len < 3 || len > 254) {
			throw new IllegalArgumentException("Invalid external email address.");
		}
		mExternalEmail = externalEmail;
	}

}
