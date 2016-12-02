package employment;

import java.util.List;

/**
 * Represents an employment record associated with some Student.
 * @author Sarah Snyder
 *
 */
public class Employment {
	private String mEmploymentId;
	private Company mCompany;
	/** mCurrent is true if the Student is currently working at this position, false otherwise */
	private boolean mCurrent;
	private String mDescription;
	private int mSalary;
	private List<EmploymentSkill> mSkills;

	public Employment(Company company, boolean current) {
		this.setCompany(company);
		this.setCurrent(current);
	}
	
	// TODO input validation
	
	/** @return the id number for this employment record */
	public String getEmploymentId() {
		return mEmploymentId;
	}

	public void setEmploymentId(String mEmploymentId) {
		this.mEmploymentId = mEmploymentId;
	}

	/** @return the company */
	public Company getCompany() {
		return mCompany;
	}

	public void setCompany(Company mCompany) {
		this.mCompany = mCompany;
	}
	
	/** @return true if the Student is currently working at this position, false otherwise */
	public boolean isCurrent() {
		return mCurrent;
	}

	public void setCurrent(boolean mCurrent) {
		this.mCurrent = mCurrent;
	}

	/** @return description of the position */
	public String getDescription() {
		return mDescription;
	}

	public void setDescription(String mDescription) {
		this.mDescription = mDescription;
	}

	/** @return salary */
	public int getSalary() {
		return mSalary;
	}

	public void setSalary(int mSalary) {
		this.mSalary = mSalary;
	}

	/**
	 * Represents a skill associated with an employment record.
	 */
	public class EmploymentSkill {
		private String mSkill;
		
		public EmploymentSkill(String skill) {
			this.setSkill(skill);
		}
		
		/**@return the skill */
		public String getSkill() {
			return mSkill;
		}
		
		public void setSkill(String skill) {
			int len = skill.length();
			if(len < 1 || len > 25) {
				throw new IllegalArgumentException("Invalid skill.");
			}
			mSkill = skill;
		}
	}
}
