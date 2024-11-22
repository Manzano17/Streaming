package pojo;

public class LoginUsuario {

    private Boolean error;
    private String mensaje;
    private Usuario usuario;

    public LoginUsuario() {
    }

    public LoginUsuario(Boolean error, String mensaje, Usuario usuario) {
        this.error = error;
        this.mensaje = mensaje;
        this.usuario = usuario;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Usuario getColaborador() {
        return usuario;
    }

    public void setColaborador(Usuario colaborador) {
        this.usuario = usuario;
    }

}
