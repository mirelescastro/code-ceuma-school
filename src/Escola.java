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

        JPasswordField jpf = new JPasswordField(24);
        JLabel jl = new JLabel("Crie sua senha: ");
        Box box = Box.createHorizontalBox();
        box.add(jl);
        box.add(jpf);
        int x = JOptionPane.showConfirmDialog(null, box, "Cadastro", JOptionPane.OK_CANCEL_OPTION);

        if (x == JOptionPane.OK_OPTION) {
            return jpf.getText();
        }
        return null;

    }






}
