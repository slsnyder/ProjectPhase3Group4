package employment;

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

	public Employment() {
		
	}
	
	public String getEmploymentId() {
		return mEmploymentId;
	}

	public void setEmploymentId(String mEmploymentId) {
		this.mEmploymentId = mEmploymentId;
	}

	public Company getCompany() {
		return mCompany;
	}

	public void setCompany(Company mCompany) {
		this.mCompany = mCompany;
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
