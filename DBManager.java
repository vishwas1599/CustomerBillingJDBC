package bookOp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static Connection con;

    public static Connection getConnection()
    {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/book_database","root","Vish@123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
