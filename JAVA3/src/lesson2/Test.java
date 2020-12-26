package lesson2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        final String STUDENTS_TABLE = "CREATE TABLE IF NOT EXISTS STUDENTS\n" +
                "(\n" +
                "    ID         INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    NAME       TEXT NOT NULL,\n" +
                "    SURNAME    TEXT NOT NULL,\n" +
//                "    BIRTH_DATE DATE,\n" +
                "    GROUP_ID   INTEGER\n" +
                ");";
        String insert = "INSERT INTO STUDENTS (NAME, SURNAME, GROUP_ID) VALUES (\"Ivan\", \"Fe\", 1);";
        String update = "UPDATE STUDENTS SET SURNAME = \"Griririri\" WHERE ID = 4";
        String delete = "DELETE FROM STUDENTS WHERE ID=4";
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:myDB");
        Statement statement = connection.createStatement();
        statement.execute(STUDENTS_TABLE);
        statement.execute(insert);
        statement.execute(update);
        statement.execute(delete);

    }
}
