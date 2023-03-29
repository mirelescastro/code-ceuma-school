
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javax.swing.JOptionPane.showMessageDialog;

public class Main {



    public static void main(String[] args) {
        ArrayList<Escola> cadastro = new ArrayList<>();



        Pattern patternEmail = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");


        boolean continuar = true;

        while (continuar) {
            String opcao = JOptionPane.showInputDialog(null, "Escolha o que você deseja fazer:\n \n [1] Cadastrar usuário \n" +
                    " [2] Buscar usuários \n " + "[3] Alterar o cadastro " + "\n [4] Excluir o cadastro", "Cadastro", JOptionPane.YES_NO_CANCEL_OPTION);

            switch (opcao) {
                case "1": {
                    boolean usuarioValido = true;
                    String usuario = null;

                    while (usuarioValido) {
                        usuario = JOptionPane.showInputDialog(null, "Digite seu usuário:", "Cadastro", JOptionPane.YES_NO_CANCEL_OPTION);
                        if (!usuario.matches("^[a-zA-ZÀ-ÿ\\s]+$")) {
                            showMessageDialog(null, "O nome deve conter apenas letras. Tente novamente.", "", JOptionPane.ERROR_MESSAGE);
                            continue;
                        }else {
                            break;
                        }
                    }

                    boolean emailValido = true;
                    String email = null;
                    while (emailValido) {
                        email = JOptionPane.showInputDialog(null, "Digite seu email:", "Cadastro", JOptionPane.YES_NO_CANCEL_OPTION);

                        if (!patternEmail.matcher(email).matches()) {
                            showMessageDialog(null, "Email inválido.","", JOptionPane.ERROR_MESSAGE);
                            continue;
                        }else {
                            break;
                        }

                    }

                    boolean senhaValida = true;
                    String senha = null;

                    while (senhaValida) {
                        senha = JOptionPane.showInputDialog(null, "Crie uma senha:", "Cadastro", JOptionPane.YES_NO_CANCEL_OPTION);
                        if (!senha.matches("^.{8,15}$")) {
                            showMessageDialog(null, "A senha deve conter no mínimo 8 caracteres.", "", JOptionPane.ERROR_MESSAGE);
                            continue;
                        }else {
                            break;
                        }
                    }

                    Escola dados = new Escola();
                    dados.usuario = usuario;
                    dados.email = email;
                    dados.senha = senha;

                    System.out.println("Usuário " + dados.usuario + " cadastrado!");

                    cadastro.add(dados);
                    break;
                } case "2": { // Procurar usuário
                    String nome = JOptionPane.showInputDialog(null, "Digite o nome do aluno: ", "Procurar Usuário", JOptionPane.YES_NO_CANCEL_OPTION);

                    boolean encontrado = false;

                    for (int i = 0; i < cadastro.size(); i++) {

                        Escola conta = cadastro.get(i);

                        if (nome.equals(conta.getUsuario())) {
                            System.out.println("\nUsuario encontrado!");
                            System.out.println("\tNome : " + conta.getUsuario());
                            System.out.println("\tEmail: " + conta.getEmail());
                            System.out.println("\tSenha: " + conta.getSenha());
                            encontrado = true;
                            break;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("Usuário não encontrado!");
                            System.out.println("Tente novamente.");
                        }
                    break;
                } case "3": { // Alterar o usuário

                    for (int i = 0; i < cadastro.size(); i++) {

                        Escola conta = cadastro.get(i);
                        System.out.print( "[" + i + "]" + conta.getUsuario());
                    }

                    int referencia = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual usuário você deseja alterar? ", "Alterar Usuário", JOptionPane.YES_NO_CANCEL_OPTION));

                    String novoUsuario = JOptionPane.showInputDialog(null, "Digite um novo usuário:", "Alterações", JOptionPane.YES_NO_CANCEL_OPTION + referencia);

                    String novoEmail = JOptionPane.showInputDialog(null, "Digite um novo email:", "Alterações", JOptionPane.YES_NO_CANCEL_OPTION + referencia);

                    String novaSenha = JOptionPane.showInputDialog(null, "Digite uma nova senha:", "Alterações", JOptionPane.YES_NO_CANCEL_OPTION + referencia);

                    Escola u = cadastro.get(referencia);

                    u.setUsuario(novoUsuario);
                    u.setEmail(novoEmail);
                    u.setSenha(novaSenha);
                    break;

                } case "4": { //Excluir
                     System.out.println("\nUsuários restantes:");

                     for (int i = 0; i < cadastro.size(); i++) {
                     Escola conta = cadastro.get(i);
                     System.out.println("[" + i + "]" + conta.getUsuario());
                     }int referencia = Integer.parseInt(JOptionPane.showInputDialog("Você deseja remover qual usuário: "));
                     cadastro.remove(referencia);
                     showMessageDialog(null, "Você removeu esse usuário.");
                     break;

                }
            }
        }
    }
}
