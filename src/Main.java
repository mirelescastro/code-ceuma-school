
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {



    public static void main(String[] args) {
        ArrayList<Escola> cadastro = new ArrayList<>();


        boolean continuar = true;

        while (continuar) {
            String opcao = JOptionPane.showInputDialog(null, "Escolha o que você deseja fazer:\n \n [1] Cadastrar usuário \n" +
                    " [2] Buscar usuários \n " + "[3] Alterar o cadastro " + "\n [4] Excluir o cadastro", "Cadastro", JOptionPane.YES_NO_CANCEL_OPTION);

            switch (opcao) {
                case "1": {

                    String usuario = JOptionPane.showInputDialog(null, "Digite seu usuário:", "Cadastro", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (!usuario.matches("^[A-Za-z]+$")) {
                        JOptionPane.showMessageDialog(null, "O nome deve conter apenas letras. Tente novamente.");
                        JOptionPane.showInputDialog("Digite seu usuário:");
                    }
                    String email = JOptionPane.showInputDialog(null, "Digite seu email:", "Cadastro", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                        JOptionPane.showMessageDialog(null, "Email inválido");
                        String validemail = JOptionPane.showInputDialog("Digite seu email:");
                    }

                    String id = JOptionPane.showInputDialog(null, "Digite seu id:", "Cadastro", JOptionPane.YES_NO_CANCEL_OPTION);

                    Escola dados = new Escola();
                    dados.usuario = usuario;
                    dados.email = email;
                    dados.id = Integer.parseInt(String.valueOf(id));

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
                            System.out.println("\tId: " + conta.getId());
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

                    String novoId = JOptionPane.showInputDialog(null, "Digite um novo id:", "Alterações", JOptionPane.YES_NO_CANCEL_OPTION + referencia);

                    Escola u = cadastro.get(referencia);

                    u.setUsuario(novoUsuario);
                    u.setEmail(novoEmail);
                    u.setId(novoId);
                    break;

                } case "4": { //Excluir
                     System.out.println("\nUsuários restantes:");

                     for (int i = 0; i < cadastro.size(); i++) {
                     Escola conta = cadastro.get(i);
                     System.out.println("[" + i + "]" + conta.getUsuario());
                     }int referencia = Integer.parseInt(JOptionPane.showInputDialog("Você deseja remover qual usuário: "));
                     cadastro.remove(referencia);
                     JOptionPane.showMessageDialog(null, "Você removeu esse usuário.");
                     break;

                }
            }
        }
    }
}
