package APIAutomation.EcommerceE2EAPITesting.POJOSerelizationJSON;

public class LoginRequest {

	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	private String UserEmail;
	private String UserPassword;
}
