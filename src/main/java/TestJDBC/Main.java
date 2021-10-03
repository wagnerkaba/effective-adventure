package TestJDBC;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AlunoDAO alunoDAO = new AlunoDAO();

        List<Aluno> alunos = alunoDAO.list();
        alunos.forEach(System.out::println);

        Aluno alunoConsulta = alunoDAO.getById(3);
        System.out.println("\nO aluno de id 3 é:" + alunoConsulta);

        Aluno novoAluno = new Aluno(
                "Rafael",
                89,
                "PR"
        );


        alunoDAO.create(novoAluno);
        alunoDAO.delete(8);

        alunoDAO.list().forEach(System.out::println);

        Aluno alunoParaAtualizar = alunoDAO.getById(10);
        alunoParaAtualizar.setNome("Amanda");
        alunoParaAtualizar.setIdade(23);
        alunoParaAtualizar.setEstado("GO");

        alunoDAO.update(alunoParaAtualizar);


        alunoDAO.list().forEach(System.out::println);




    }


}
