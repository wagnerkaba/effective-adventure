package TestJDBC;

import java.io.IOException;
import java.io.InputStream;
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

    public static Connection getConnection(){

        Connection connection = null;

        try (InputStream input = ConnectionJDBC.class.getClassLoader().getResourceAsStream("connection.properties")){


        } catch (IOException e){
            System.out.println("Falha ao tentar carregar arquivo de propriedades");
            e.printStackTrace();
        }


        return connection;

    }


}
