package sahana.g.comviva.phase1.project;

public class LockedMe {
	private  String firstName;
	private  String lastName;
	public  String emailID;
	public  String password;
	public String userName;
	public  String newPassword = new String();
	public  String confirmPassword = new String();
	
	
	
	
	public LockedMe() {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.password = password;
		this.newPassword = newPassword;
		this.confirmPassword = confirmPassword;
		this.userName = userName;
	}
	
	public String getUserName() {
		return userName;
	}

	public String setUserName(String userName) {
		return this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}
	public String setFirstName(String firstName) {
		 return this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String setLastName(String lastName) {
		return this.lastName = lastName;
	}
	public String getEmailID(String emailID) {
		return emailID;
	}
	public String setEmailID(String emailID) {
		return this.emailID = emailID;
	}
	public String getPassword() {
		return password;
	}
	public String setPassword(String password) {
		return this.password = password;
	}
	public String getNewpassword() {
		return newPassword;
	}
	public String setNewpassword(String newPassword) {
		return this.newPassword = newPassword;
	}
	public String getConpassword() {
		return confirmPassword;
	}
	public String setConpassword(String confirmPassword) {
		return this.confirmPassword = confirmPassword;
	}
	@Override
	public String toString() {
		return "lockmeApp [firstName=" + firstName + ", lastName=" + lastName + ", emailID=" + emailID + ", password="
				+ password + ", userName=" + userName + ", newpassword=" + newPassword + ", conpassword=" + confirmPassword+ "]";
	}
}
