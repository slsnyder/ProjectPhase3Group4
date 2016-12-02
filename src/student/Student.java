package student;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Sarah Snyder
 *
 */
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
	private List<CollegeTransfer> mCollegeTransfer;
	// private List<Employment> mJobs;
	// private List<Employment> mInternships;

	// TODO internship/ employment
	
	public Student(String lastName, String firstName, 
			String academicProgram, String degreeLevel, String gradTerm, 
			String gradYear, double gpa, String uwEmail, String externalEmail) {
		
		this.setLastName(lastName);
		this.setFirstName(firstName);
		this.setAcademicProgram(academicProgram);
		this.setDegreeLevel(degreeLevel);
		this.setGradTerm(gradTerm);
		this.setGradYear(gradYear);
		this.setGpa(gpa);
		this.setUwEmail(uwEmail);
		this.setExternalEmail(externalEmail);
		mCollegeTransfer = null;
	}

	/** @return student id */
	public String getId() {
		return mId;
	}

	public void setId(String id) {
		if (id == null || Integer.parseInt(id) < 0 || Integer.parseInt(id) > 9999999) {
			throw new IllegalArgumentException("Invalid student ID number.");
		}
		mId = id;
	}

	/** @return last name */
	public String getLastName() {
		return mLastName;
	}

	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() < 2 || lastName.length() > 25) {
			throw new IllegalArgumentException("Invalid last name.");
		}
		mLastName = lastName;
	}

	/** @return first name */
	public String getFirstName() {
		return mFirstName;
	}

	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() < 2 || firstName.length() > 25) {
			throw new IllegalArgumentException("Invalid first name.");
		}
		mFirstName = firstName;
	}

	/** @return academic program */
	public String getAcademicProgram() {
		return mAcademicProgram;
	}

	public void setAcademicProgram(String academicProgram) {
		if (academicProgram == null || academicProgram.length() == 0 || academicProgram.length() > 3) {
			throw new IllegalArgumentException("Invalid academic program.");
		}
		mAcademicProgram = academicProgram;
	}

	/** @return degree level */
	public String getDegreeLevel() {
		return mDegreeLevel;
	}

	public void setDegreeLevel(String degreeLevel) {
		if (degreeLevel == null || degreeLevel.length() < 2 || degreeLevel.length() > 3) {
			throw new IllegalArgumentException("Invalid degree level.");
		}
		mDegreeLevel = degreeLevel;
	}

	/** @return graduation term */
	public String getGradTerm() {
		return mGradTerm;
	}

	public void setGradTerm(String gradTerm) {
		if (gradTerm == null || gradTerm.length() != 6) {
			throw new IllegalArgumentException("Invalid graduation term.");
		}
		mGradTerm = gradTerm;
	}

	/** @return graduation year */
	public String getGradYear() {
		return mGradYear;
	}

	public void setGradYear(String gradYear) {
		if (gradYear == null || gradYear.length() != 4) {
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
		if(uwEmail == null ||
				uwEmail.length() < 8 || uwEmail.length() > 15 ||
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
		if(externalEmail == null ||
				externalEmail.length() < 3 || externalEmail.length() > 254 ||
				!externalEmail.contains("@")) {
			throw new IllegalArgumentException("Invalid external email address.");
		}
		mExternalEmail = externalEmail;
	}

	public void setCollegeTransfer(CollegeTransfer ct) {
		if(mCollegeTransfer == null) {
			mCollegeTransfer = new ArrayList<CollegeTransfer>();
		}
		
		mCollegeTransfer.add(ct);
	}

}
