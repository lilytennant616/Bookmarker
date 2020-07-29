package dbdriver;

public class SQLGenerator {
	
	public String queryUser(String username) {
		return "SELECT Username FROM Users WHERE Username = '"+username+"';";
	}

}
