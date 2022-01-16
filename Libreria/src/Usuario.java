public class Usuario {
    private String usuario;
    private String contraseña;

    public Usuario(String usuario, String contraseña){
        this.contraseña = contraseña;
        this.usuario = usuario;
    }

    public String getUsuario(){
        return usuario;
    }

    public String getContraseña(){
        return contraseña;
    }
}
