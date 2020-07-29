package dbdriver;

import java.sql.SQLException;

public class BaseDriver {
	
	String dbPath="/Users/lily/Documents/workspaccce/ex1";
	SQLGenerator sqlGenerator=new SQLGenerator();
	QueryExecutor queryExecutor=new QueryExecutor(dbPath);
	String user;
	
	public boolean loginUser(String username) {
		String command=sqlGenerator.queryUser(username);
		try {
			if (queryExecutor.queryUser(command).size()==0)
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		user=username;
		return true;		
	}
	
	
	
}
