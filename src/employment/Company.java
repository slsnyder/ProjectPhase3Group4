package employment;

/**
 * Represents a company where a student may be employed.
 * @author Sarah Snyder
 *
 */
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
