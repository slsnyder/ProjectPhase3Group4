package student;

/**
 * Represents a skill associated with an employment record.
 * @author Sarah Snyder
 *
 */
public class EmploymentSkill {
	String mSkill;
	
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
