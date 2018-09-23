/**

 Created by IntelliJ IDEA.
 User: Fahad
 Date: 9/7/2018

 */
package utilities;

import java.sql.*;


public class DatabaseConnection {

    public Connection connect = null;
    private Statement statement = null;
    public PreparedStatement preparedStatement = null;
    public ResultSet resultSet = null;

    public DatabaseConnection() {
    }

    public void openConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/lms?"
                        + "user=root&password=");
    }

    public void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception exp) {

        }
    }
}
