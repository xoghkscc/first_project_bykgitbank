package function.model;

public class DeliveryDB {

	private String MEMBERS_NAME;
	private String MEMBERS_ADDRESS;
	private String MEMBERS_PHONENUMBER;
	private int PAYMENT;

	public DeliveryDB(String MEMBERS_NAME, String MEMBERS_ADDRESS, String MEMBERS_PHONENUMBER, int PAYMENT) {
		this.MEMBERS_NAME = MEMBERS_NAME;
		this.MEMBERS_ADDRESS = MEMBERS_ADDRESS;
		this.MEMBERS_PHONENUMBER = MEMBERS_PHONENUMBER;
		this.PAYMENT = PAYMENT;
	}



	public String getMEMBERS_NAME() {
		return MEMBERS_NAME;
	}

	public String getMEMBERS_ADDRESS() {
		return MEMBERS_ADDRESS;
	}

	public String getMEMBERS_PHONENUMBER() {
		return MEMBERS_PHONENUMBER;
	}

	public int getPAYMENT() {
		return PAYMENT;
	}

}
