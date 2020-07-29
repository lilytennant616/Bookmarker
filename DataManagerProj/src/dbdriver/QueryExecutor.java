package dbdriver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryExecutor {
	
	String dbPath;
	Connection conn;
	Statement stmt;
	
	public QueryExecutor(String _dbPath) {
		dbPath=_dbPath;
	}
	
	public List<String> queryUser(String command) throws SQLException {
		List<String> usersList=new ArrayList<String>();
		try {
			conn=connectDB(stmt);
			ResultSet rs=stmt.executeQuery(command);
			while (rs.next()) {
				String user=rs.getString("Username");
				usersList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnectDB();
		}
		return usersList;
	}
	
	private Connection connectDB(Statement stmt) throws SQLException {
		conn=DriverManager.getConnection("jdbc:sqlite:"+dbPath);
		stmt=conn.createStatement();
		return conn;
	}
	
	private void disconnectDB() throws SQLException {
		if (conn!=null)
			conn.close();
		conn=null;
		stmt=null;
	}
	
}
