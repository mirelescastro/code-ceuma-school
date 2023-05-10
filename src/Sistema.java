import javax.swing.*;

public class Sistema {
    public static void main(String[] args) {

        Usuario usuario = new Usuario();

        boolean continuar = true;

        while (continuar) {
            String opcao = JOptionPane.showInputDialog(null, "Escolha o que você deseja fazer:\n \n" +
                            " [1] Cadastrar usuário \n" +
                            " [2] Buscar usuários \n " +
                            "[3] Alterar o cadastro " + "\n " +
                            "[4] Excluir o cadastro" + "\n " +
                            "[5] Sair do programa",
                    "Cadastro", JOptionPane.YES_NO_CANCEL_OPTION);

            switch (opcao) {
                case "1" -> {
                    usuario.cadastro();
                }

                case "2" -> {
                    usuario.procurar();

                }
                case "3" -> {
                    usuario.alterar();
                }

            }
        }
    }
}

//                }case "4": { //Excluir
//                    System.out.println("\nUsuários restantes:");
//
//                    for (int i = 0; i < cadastro.size(); i++) {
//                        Escola conta = cadastro.get(i);
//                        System.out.println("[" + i + "]" + conta.getUsuario());
//                    }
//                        int referencia = -1;
//                        boolean referenciaValida = false;
//
//                        while (!referenciaValida) {
//                            String inputReferencia = JOptionPane.showInputDialog(null,
//                                    "Você deseja remover qual usuário: \n", "Excluir usuário.", JOptionPane.YES_NO_CANCEL_OPTION);
//                            try {
//                                referencia = Integer.parseInt(inputReferencia);
//                                if (referencia < 0 || referencia >= cadastro.size()) {
//                                    showMessageDialog(null, "Usuário inválido. Tente novamente.", "ERROR", JOptionPane.ERROR_MESSAGE);
//                                } else {
//                                    referenciaValida = true;
//                                }
//                            } catch (NumberFormatException e) {
//                                showMessageDialog(null, "Usuário inválido. Tente novamente.", "ERROR", JOptionPane.ERROR_MESSAGE);
//                            }
//                        }
//                    cadastro.remove(referencia);
//                    showMessageDialog(null, "Você removeu esse usuário.");
//
//                    break;
//
//                }case "5":{
//                    showMessageDialog(null,"Você está encerrando o programa.", "Sair",JOptionPane.NO_OPTION);
//                        continuar = false;
//                    }
//                    break;
//                }
            //}

