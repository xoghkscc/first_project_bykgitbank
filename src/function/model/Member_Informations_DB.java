package function.model;

public class Member_Informations_DB {
	
	
		private int MEMBERS_ID;
		private String MEMBERS_NAME;
		private String MEMBERS_ADDRESS;
		private String MEMBERS_PHONENUMBER;
		private int MEMBERS_POINT;

		public Member_Informations_DB(int MEMBERS_ID, String MEMBERS_NAME, 
				String MEMBERS_ADDRESS, String MEMBERS_PHONENUMBER, int MEMBERS_POINT) {
			this.MEMBERS_ID = MEMBERS_ID;
			this.MEMBERS_NAME = MEMBERS_NAME;
			this.MEMBERS_ADDRESS = MEMBERS_ADDRESS;
			this.MEMBERS_PHONENUMBER = MEMBERS_PHONENUMBER;
			this.MEMBERS_POINT = MEMBERS_POINT;
		}

		public int getMEMBERS_ID() {
			return MEMBERS_ID;
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

		public int getMEMBERS_POINT() {
			return MEMBERS_POINT;
		}

		
	
}
