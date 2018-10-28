package preparedstate;

import java.sql.*;

public class Main {

    public static void main(String[] args) {


        String url = "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false  ";
        String user = "root";
        String password = "secret";
        try {
            Connection myConn = DriverManager.getConnection(url, user, password);
            String sql = "select * from Contacts " + "where salary > ?";
            PreparedStatement myStmt = myConn.prepareStatement(sql);
            myStmt.setDouble(1, 10000);
            ResultSet myRs = myStmt.executeQuery();

            while (myRs.next()) {
                System.out.println(myRs.getString("name") + " " + myRs.getString("salary"));
            }
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

