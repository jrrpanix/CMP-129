import java.sql.*;

public class DbRead {

    static public final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static public final String DB_URL = "jdbc:mysql://localhost/cmp129";

    public static void dump( String [] cols , String table, String DBURL, String user , String pass ) {

	try {
	    Class.forName(JDBC_DRIVER);
	    Connection conn = DriverManager.getConnection(DBURL,user,pass);
	    Statement sm = conn.createStatement();
	    String query= "select ";
	    for( int i = 0; i < cols.length ; i++ ) {
		query += cols[i];
		if ( i != cols.length -1 ) query += ",";
	    }
	    query += " from " + table;
	    ResultSet result = sm.executeQuery(query);
	    while(result.next()) {
		for( String col : cols ) {
		    System.out.format( "%s " , result.getString( col ));
		}
		System.out.format ("\n");
	    }
	    conn.close();
	} catch( Exception e ) {
	    System.out.println(e);
	}
    }

    public static void main(String [] args ) {
	String url = args[0];
	String user = args[1];
	String pass = args[2];
	String [] cols = { "LastName" , "FirstName" , "City" };
	String table = "Persons";
	dump(cols , table , url, user , pass );


    }
}
