package function.model;

public class members_list_DB {
	private int MEMBERS_ID;
	private String MEMBERS_NAME;
	private String MEMBERS_PHONENUMBER;
	private int MEMBERS_POINT;

	public members_list_DB(int MEMBERS_ID, String MEMBERS_NAME, String MEMBERS_PHONENUMBER, int MEMBERS_POINT) {
		this.MEMBERS_ID = MEMBERS_ID;
		this.MEMBERS_NAME = MEMBERS_NAME;
		this.MEMBERS_PHONENUMBER = MEMBERS_PHONENUMBER;
		this.MEMBERS_POINT = MEMBERS_POINT;
	}

	public int getMEMBERS_ID() {
		return MEMBERS_ID;
	}

	public String getMEMBERS_NAME() {
		return MEMBERS_NAME;
	}


	public String getMEMBERS_PHONENUMBER() {
		return MEMBERS_PHONENUMBER;
	}

	public int getMEMBERS_POINT() {
		return MEMBERS_POINT;
	}

	
	
}
