package TestJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    public static void main(String[] args) throws SQLException {
        //Atenção:no build.gradle tem que colocar a dependência do mysql
        String urlConnection = "jdbc:mysql://localhost/teste";


        try (Connection conn = DriverManager.getConnection(urlConnection, "root", "admin")) {
            System.out.println("sucesso!");
        } catch (Exception e){
            System.out.println("Falha!");
        }


    }
}
