import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<String> alunos = new ArrayList<String>();

    public static void main(String[] args) {

        //Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {

            String nome = JOptionPane.showInputDialog("Digite o nome do aluno ou 'sair' para encerrar:");


            if (nome.equals("sair")) {

                continuar = false;
            } else {
                cadastrarAluno(nome);
            }
        }

        System.out.println("Alunos cadastrados:");
        for (String aluno : alunos ) {
            System.out.println(aluno);
        }

        //scanner.close();
    }

    public static void cadastrarAluno(String nome) {
        if (nome.matches("^[A-Za-z]+$")) {
            alunos.add(nome);
            System.out.println("Aluno " + nome + " cadastrado com sucesso!");
        }

        else{
                JOptionPane.showMessageDialog(null, "invalido");
            }

    }
}
