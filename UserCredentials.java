package sahana.g.comviva.phase1.project;

public class UserCredentials {
	private static String siteName = null;
	private static  String  loggedInUser = null;
	private static String userID=null;
	private static String password=null;
	
	//public UserCredentials() {}

	public UserCredentials(String siteName, String loggedInUser, String userID, String password) {
		this.siteName = siteName;
		this.loggedInUser = loggedInUser;
		this.userID = userID;
		this.password = password;
	}

	public static String getSiteName() {
		return siteName;
	}

	public static String setSiteName(String siteName) {
		return UserCredentials.siteName = siteName;
	}

	public static String getLoggedInUser() {
		return loggedInUser;
	}

	public static String setLoggedInUser(String loggedInUser) {
		return UserCredentials.loggedInUser = loggedInUser;
	}

	public static String getUserID() {
		return userID;
	}

	public static String setUserID(String userID) {
		return UserCredentials.userID = userID;
	}

	public static String getPassword() {
		return password;
	}

	public static String setPassword(String password) {
		return UserCredentials.password = password;
	}

	@Override
	public String toString() {
		return "UserCredentials [siteName=" + siteName + ", loggedInUser=" + loggedInUser + ", username=" + userID + ", password=" + password + "]";
	}
}
