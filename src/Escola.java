import javax.swing.*;

public class Escola {

    public String usuario;
    public String email;
    public String senha;

    public String getUsuario() {

        return usuario;
    }

    public void setUsuario(String usuario) {

        this.usuario = usuario;
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

    public String getMaskPass(){

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
    public String getMaskPassAlt(){

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
}
