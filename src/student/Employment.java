package student;

/**
 * Represents an employment record associated with some Student.
 * @author Sarah Snyder
 *
 */
public class Employment {
	
	

	
	public class Company { // TODO input validation
		private String mCompanyId;
		private String mCompanyName;
		
		public Company(String companyName) {
			
		}

		/** @return the id number of the company */
		public String getCompanyId() {
			return mCompanyId;
		}

		public void setCompanyId(String mCompanyId) {
			this.mCompanyId = mCompanyId;
		}

		/** @return name of the company */
		public String getCompanyName() {
			return mCompanyName;
		}

		public void setCompanyName(String mCompanyName) {
			this.mCompanyName = mCompanyName;
		}
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
