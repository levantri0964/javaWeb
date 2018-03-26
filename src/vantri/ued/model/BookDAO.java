package vantri.ued.model;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	static Connection conn;
	public static Connection connect() {

	String db0="book";
	String name="servlets";
	String pass="123";
	String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url="jdbc:sqlserver://DESKTOP-04VJNBJ\\SQLEXPRESS:1433;databaseName="+db0+";";
	try {
		Class.forName(driver);
		conn=DriverManager.getConnection(url,name,pass);
	}catch(Exception e) {
		System.out.println(e);
	}
	return conn;
	}
	public List<Book>  listALL()throws SQLException{
		String sql="select id,title,author,price from book";
		conn=connect();
		PreparedStatement pr=conn.prepareStatement(sql);
		ResultSet rs=pr.executeQuery();
	
		List<Book> listDS=new ArrayList<Book>();
		while(rs.next()) {
			System.out.println(rs.getString(2));
			Book book=new Book();
			book.setId(rs.getInt(1));
			book.setTitle(rs.getString(2));
			book.setAuthor(rs.getString(3));
			book.setPrice(rs.getFloat(4));
			listDS.add(book);
		}
		pr.close();
		rs.close();
		return listDS;
	}
	
}
