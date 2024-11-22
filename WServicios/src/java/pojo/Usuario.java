package pojo;

/**
 *
 * @author Manzano
 */
public class Usuario {
    
    private Integer idUsuario;
    private String usuario;
    private String contrasenia;

    public Usuario() {
    }
    
    public Usuario(Integer idUsuario, String usuario, String contrasenia) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
}
