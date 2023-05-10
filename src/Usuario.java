import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

import static javax.swing.JOptionPane.showMessageDialog;

public class Usuario {

    ArrayList<Usuario> cadastro = new ArrayList<>();

    Usuario user;
    Usuario senhavalida;

    // atributos
    private String nome, email, senha;

    Pattern patternEmail = Pattern.compile("^[^\\s][a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{1,}$");


    // métodos do cadastro

    public void cadastro() {
        this.cadastrarNome();
        this.cadastrarEmail();
        this.cadastrarSenha();

        cadastro.add(this);
    }

    public void cadastrarNome() {
        boolean nomeValido = true;
        while (nomeValido) {
            nome = JOptionPane.showInputDialog(null,
                    "Digite seu nome:", "Cadastro", JOptionPane.YES_NO_CANCEL_OPTION);
            if (!nome.matches("^[^\\s][a-zA-ZÀ-ÿ\\s]{2,}+$")) {
                showMessageDialog(null, "O nome deve conter apenas letras. Tente novamente.",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
                continue;
            }else {
                break;
            }
        }

    }

    public void cadastrarEmail() {
        boolean emailValido = true;

        while (emailValido) {
            email = JOptionPane.showInputDialog(null,
                    "Digite seu email:", "Cadastro", JOptionPane.YES_NO_CANCEL_OPTION);
            if (!patternEmail.matcher(email).matches()) {
                showMessageDialog(null, "Email inválido.","ERROR", JOptionPane.ERROR_MESSAGE);
                continue;
            }else {
                break;
            }
        }

    }

    public void cadastrarSenha() {
        boolean senhaValida = true;

        showMessageDialog(null, "REQUISITOS DE SENHA:\n"+"\t\t8 caracteres no mínimo.\n" +
                "\t\t1 letra maiúscula no mínimo.\n" + "\t\t1 número no mínimo.\n" + "\t\t15 caracteres no máximo.\n" +
                "\t\t1 símbolo no mínimo: $*&@#.", "REQUISITOS", JOptionPane.INFORMATION_MESSAGE);
        while (senhaValida) {
            senha = mascararSenha();
            if (!senha.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,}$")) {
                showMessageDialog(null, "REQUISITOS DA SENHA:\n"+"\t\t8 caracteres no mínimo.\n" +
                        "\t\t1 letra maiúscula no mínimo.\n" + "\t\t1 número no mínimo.\n" + "\t\t15 caracteres no máximo.\n" +
                        "\t\t1 símbolo no mínimo: $*&@#.", "ERROR", JOptionPane.ERROR_MESSAGE);
                continue;
            }else {
                break;
            }
        }

    }

    public void procurar() {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do aluno: ",
                "Procurar Usuário", JOptionPane.YES_NO_CANCEL_OPTION);

        boolean encontrado = false;

        for (int i = 0; i < cadastro.size(); i++) {

            user = cadastro.get(i);
            if (nome.equalsIgnoreCase(user.getNome())) {
                senha = mascararSenha();
                System.out.println("\nUsuario encontrado!");
                System.out.println("\tNome : " + user.getNome());
                System.out.println("\tEmail: " + user.getEmail());
                System.out.println("\tSenha: " + user.getSenha());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("\nUsuário não encontrado!");
            System.out.println("Tente novamente.");
        }
    }

    public void alterar(){

        for (int i = 0; i < cadastro.size(); i++) {

            user = cadastro.get(i);
            System.out.print( "\n[" + i + "]" + user.getNome());
        }

        int referencia = -1;
        boolean referenciaValida = false;

        while (!referenciaValida) {
            String inputReferencia = JOptionPane.showInputDialog(null,
                    "Qual usuário você deseja alterar? ", "Alterar Usuário", JOptionPane.YES_NO_CANCEL_OPTION);
            try {
                referencia = Integer.parseInt(inputReferencia);
                if (referencia < 0 || referencia >= cadastro.size()) {
                    showMessageDialog(null, "Usuário inválido. Tente novamente.", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    referenciaValida = true;
                }
            } catch (NumberFormatException e) {
                showMessageDialog(null, "Usuário inválido. Tente novamente.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

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

            while (usuarioValido) {
                novoUsuario = JOptionPane.showInputDialog(null, "Digite um novo usuário:",
                        "Alterações", JOptionPane.YES_NO_CANCEL_OPTION+ referencia);
                if (!novoUsuario.matches("^[^\\s][a-zA-ZÀ-ÿ\\s]{2,}+$")) {
                    showMessageDialog(null, "O nome deve conter apenas letras. Tente novamente.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    continue;
                }else {
                    break;
                }
            }
            Usuario conta = cadastro.get(referencia);
            conta.setNome(novoUsuario);




        } else if (alteracao.equals("2")) {

            boolean validacaoEmail = true;

            while (validacaoEmail) {
                novoEmail = JOptionPane.showInputDialog(null, "Digite um novo email:",
                        "ALTERAR", JOptionPane.YES_NO_CANCEL_OPTION + referencia);

                if (!patternEmail.matcher(novoEmail).matches()) {
                    showMessageDialog(null, "Email inválido.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    continue;
                } else {
                    break;
                }
            }
            user = cadastro.get(referencia);
            user.setEmail(novoEmail);


        } else if (alteracao.equals("3")) {

            boolean validacaoSenha = true;

            while (validacaoSenha) {

                novaSenha = senhavalida.senhaMascaradaAlterada();

                if (!novaSenha.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,}$")) {
                    showMessageDialog(null,
                            "• REQUISITOS DE SENHA:\n"+"\t\t8 caracteres no mínimo.\n" +
                                    "\t\t1 Letra Maiúscula no mínimo.\n" + "\t\t15 caracteres no máximo.\n"  +
                                    "\t\t1 Número no mínimo.\n" + "\t\t1 Símbolo no mínimo: $*&@#.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    continue;
                }else {
                    break;
                }
            }
            user = cadastro.get(referencia);
            user.setSenha(novaSenha);
        }
    }

    public String mascararSenha(){

        JPasswordField senhamascarada = new JPasswordField(24);
        senhamascarada.setEchoChar('*');
        JLabel jl = new JLabel("Crie sua senha: ");
        Box box = Box.createHorizontalBox();
        box.add(jl);
        box.add(senhamascarada);
        int x = JOptionPane.showConfirmDialog(null, box, "Cadastro", JOptionPane.OK_CANCEL_OPTION);

        if (x == JOptionPane.OK_OPTION) {
            return senhamascarada.getText();
        }
        return null;

    }

    public String senhaMascaradaAlterada() {
        JPasswordField senhamascarada = new JPasswordField(24);
        senhamascarada.setEchoChar('*');
        JLabel jl = new JLabel("Digite a nova senha: ");
        Box box = Box.createHorizontalBox();
        box.add(jl);
        box.add(senhamascarada);
        int x = JOptionPane.showConfirmDialog(null, box, "Alteração", JOptionPane.OK_CANCEL_OPTION);

        if (x == JOptionPane.OK_OPTION) {
            return senhamascarada.getText();
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}


