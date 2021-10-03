package TestJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        AlunoDAO alunoDAO = new AlunoDAO();

        List<Aluno> alunos = alunoDAO.list();

        alunos.stream().forEach(System.out::println);


    }


}
