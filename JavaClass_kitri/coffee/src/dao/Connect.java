package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Connect {
	private static int count = 0;
	public static String getConnection() 
			throws NamingException, SQLException, InterruptedException {
		 Context initContext = new InitialContext();
		 Context envContext  = (Context)initContext.lookup("java:/comp/env");
		 DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		 Connection conn = ds.getConnection();
		 System.out.println(++count);
		 System.out.println(conn);
		 
		 Thread.sleep(5000);
		 conn.close();
		 System.out.println("closed");
		 return "hello";
	}//
	
	
}
