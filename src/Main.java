
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javax.swing.JOptionPane.showMessageDialog;

public class Main {



    public static void main(String[] args) {
        ArrayList<Escola> cadastro = new ArrayList<>();



        Pattern patternEmail = Pattern.compile("^[^\\s][a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{1,}$");


        boolean continuar = true;

        while (continuar) {
            String opcao = JOptionPane.showInputDialog(null, "Escolha o que você deseja fazer:\n \n [1] Cadastrar usuário \n" +
                    " [2] Buscar usuários \n " + "[3] Alterar o cadastro " + "\n [4] Excluir o cadastro" + "\n [5] Sair do programa", "Cadastro", JOptionPane.YES_NO_CANCEL_OPTION);

            switch (opcao) {
                case "1": {
                    boolean usuarioValido = true;
                    String usuario = null;

                    while (usuarioValido) {
                        usuario = JOptionPane.showInputDialog(null, "Digite seu nome:", "Cadastro", JOptionPane.YES_NO_CANCEL_OPTION);
                        if (!usuario.matches("^[^\\s][a-zA-ZÀ-ÿ\\s]{2,}+$")) {
                            showMessageDialog(null, "O nome deve conter apenas letras. Tente novamente.", "ERROR", JOptionPane.ERROR_MESSAGE);
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
                            showMessageDialog(null, "Email inválido.","ERROR", JOptionPane.ERROR_MESSAGE);
                            continue;
                        }else {
                            break;
                        }

                    }

                    boolean senhaValida = true;
                    String senha = null;

                    while (senhaValida) {
                        Escola validpass = new Escola();
                        senha = validpass.getMaskPass();
                        //JOptionPane.showInputDialog(null, "Crie uma senha:", "Cadastro", JOptionPane.YES_NO_CANCEL_OPTION);
                        if (!senha.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,}$")) {
                            showMessageDialog(null, "• REQUISITOS DE SENHA:\n"+"\t\t8 caracteres no mínimo.\n" + "\t\t1 Letra Maiúscula no mínimo\n" + "\t\t1 Número no mínimo\n" + "\t\t1 Símbolo no mínimo: $*&@#", "ERROR", JOptionPane.ERROR_MESSAGE);
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
                            System.out.println("\nUsuário não encontrado!");
                            System.out.println("Tente novamente.");
                        }
                    break;
                }  case "3": { // Alterar o usuário

                    for (int i = 0; i < cadastro.size(); i++) {

                        Escola conta = cadastro.get(i);
                        System.out.print( "[" + i + "]" + conta.getUsuario());
                    }

                    int referencia = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual usuário você deseja alterar? ", "Alterar Usuário", JOptionPane.YES_NO_CANCEL_OPTION));


                    String alteracao = JOptionPane.showInputDialog(null,
                            "Você deseja alterar:\n " +
                                    "[1] Usuário \n" +
                                    " [2] Email \n " +
                                    "[3] Senha ", "Alterar", JOptionPane.YES_NO_CANCEL_OPTION);

                    String novoUsuario = null;
                    String novoEmail = null;
                    String novaSenha = null;


                    if (alteracao.equals("1")) {
                        boolean usuarioValido = true;
                        String usuario = null;

                        while (usuarioValido) {
                            novoUsuario = JOptionPane.showInputDialog(null, "Digite um novo usuário:", "Alterações", JOptionPane.YES_NO_CANCEL_OPTION+ referencia);
                            if (!novoUsuario.matches("^[^\\s][a-zA-ZÀ-ÿ\\s]{2,}+$")) {
                                showMessageDialog(null, "O nome deve conter apenas letras. Tente novamente.", "ERROR", JOptionPane.ERROR_MESSAGE);
                                continue;
                            }else {
                                break;
                            }

                        }
                        Escola conta = cadastro.get(referencia);
                        conta.setUsuario(novoUsuario);
                        break;

                    } else if (alteracao.equals("2")) {

                        boolean validacaoEmail = true;

                        while (validacaoEmail) {
                            novoEmail = JOptionPane.showInputDialog(null, "Digite um novo email:",
                                    "ALTERAR", JOptionPane.YES_NO_CANCEL_OPTION + referencia);

                            if (!patternEmail.matcher(novoEmail).matches()) {
                                showMessageDialog(null, "Email inválido.","ERROR", JOptionPane.ERROR_MESSAGE);
                                continue;
                            } else {
                                break;
                            }
                        }
                        Escola conta = cadastro.get(referencia);
                        conta.setEmail(novoEmail);
                        break;

                    } else if (alteracao.equals("3")) {

                        boolean validacaoSenha = true;

                        while (validacaoSenha) {

                            Escola validpass = new Escola();
                            novaSenha = validpass.getMaskPass();
                            //novaSenha = JOptionPane.showInputDialog(null, "" +
                                    //"Digite uma nova senha:", "ALTERAR", JOptionPane.YES_NO_CANCEL_OPTION+ referencia);

                            if (!novaSenha.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,}$")) {
                                showMessageDialog(null,
                                        "\"• REQUISITOS DE SENHA:\\n\"+\"\\t\\t8 caracteres no mínimo.\\n\" + \"\\t\\t1 Letra Maiúscula no mínimo\\n\" + \"\\t\\t1 Número no mínimo\\n\" + \"\\t\\t1 Símbolo no mínimo: $*&@#\".", "ERROR", JOptionPane.ERROR_MESSAGE);
                                continue;
                            }else {
                                break;
                            }

                        }
                        Escola conta = cadastro.get(referencia);
                        conta.setSenha(novaSenha);
                        break;
                    }

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

                } case "5":{
                    continuar = false;
                    break;
                }
            }
        }
    }
}
