package TestJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    public List<Aluno> list(){

        List<Aluno> alunos = new ArrayList<>();

        try (Connection conn = ConnectionJDBC.getConnection()){

            String sql = "SELECT * FROM aluno";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs =stmt.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String estado = rs.getString("estado");

                alunos.add(new Aluno(id,nome,idade,estado));
            }

        } catch (SQLException e) {
            System.out.println("Listagem de alunos FALHOU!");
            e.printStackTrace();
        }
        return alunos;

    }

    public Aluno getById(int id){

        Aluno aluno = new Aluno();

        try (Connection conn = ConnectionJDBC.getConnection()){

            String sql = "SELECT * FROM aluno WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setEstado(rs.getString("estado"));

            }

        } catch (SQLException e){
            System.out.println("Listagem de alunos falhou!");
            e.printStackTrace();
        }
        return aluno;



    }


}
