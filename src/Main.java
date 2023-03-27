import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

//    private static ArrayList<String> alunos = new ArrayList<String>();
//    private static Pattern patternEmail = Pattern.compile("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b");
//
//    public static void main(String[] args) {
//
//        //Scanner scanner = new Scanner(System.in);
//        boolean continuar = true;
//
//        while (continuar) {
//
//            String nome = JOptionPane.showInputDialog("Digite o nome do aluno: ");
//            int id = 0;
//            boolean idValido = false;
//
//            while (!idValido) {
//                try {
//                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do aluno: "));
//                    idValido = true;
//                } catch (NumberFormatException e) {
//                    JOptionPane.showMessageDialog(null, "O ID deve ser numérico. Tente novamente.");
//                }
//            }
//
//            String email = JOptionPane.showInputDialog("Digite o email do estudante:");
//
//            if (nome.equals("sair")) {
//                continuar = false;
//            } else if (patternEmail.matcher(email).matches()) {
//                cadastrarAluno(nome, id, email);
//            } else {
//                JOptionPane.showMessageDialog(null, "O email digitado não é válido. Tente novamente.");
//            }
//        }
//
//        System.out.println("Alunos cadastrados:");
//        for (String aluno : alunos ) {
//            System.out.println(aluno);
//        }
//
//        //scanner.close();
//    }
//
//    public static void cadastrarAluno(String nome, int id, String email) {
//
//        if (nome.matches("^[A-Za-z]+$")) {
//            alunos.add("Nome: " + nome + ", ID: " + id + ", email: " + email);
//            System.out.println("Aluno " + nome + " cadastrado com sucesso!");
//        } else {
//            JOptionPane.showMessageDialog(null, "O nome deve conter apenas letras. Tente novamente.");
//        }

    public static void main(String[] args) {
        ArrayList<Escola> cadastro = new ArrayList<>();

        boolean continuar = true;

        while (continuar) {
            String opcao = JOptionPane.showInputDialog(null, "Escolha o que você deseja fazer:\n \n [1] Cadastrar usuário \n" +
                    " [2] Buscar usuários \n " + "[3] Alterar o cadastro " + "\n [4] Excluir o cadastro", "Cadastro", JOptionPane.YES_NO_CANCEL_OPTION);


            switch (opcao) {
                case "1":{
                    String usuario = JOptionPane.showInputDialog("Digite seu usuário:");
                    if (!usuario.matches("^[A-Za-z]+$")) {
                        JOptionPane.showMessageDialog(null, "O nome deve conter apenas letras. Tente novamente.");
                        JOptionPane.showInputDialog("Digite seu usuário:");
                    }

                    String email = JOptionPane.showInputDialog("Digite seu email:");

                    String id = JOptionPane.showInputDialog("Digite seu id:");

                    Escola u = new Escola();
                    u.usuario = usuario;
                    u.email = email;
                    u.id = id;

                    System.out.println("O usuário é:" + u.usuario);

                    cadastro.add(u);
                    break;
                }


            }


        }


    }
}