package dominio;

import java.util.HashMap;
import java.util.LinkedHashMap;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.LoginUsuario;
import pojo.Usuario;

/**
 *
 * @author Manzano
 */
public class ImpUsuario {
    public static LoginUsuario validarSesionUsuario(String usuario, String contrasenia) {
        LoginUsuario respuesta = new LoginUsuario();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if (conexionBD != null) {
            try {
                HashMap<String, String> parametros = new LinkedHashMap<>();
                parametros.put("usuario", usuario);
                parametros.put("contrasenia", contrasenia);
                Usuario usuarios = conexionBD.selectOne("UsuarioMapper.obtenerUsuario", parametros);
                if (usuario != null) {
                    respuesta.setError(false);
                    respuesta.setMensaje("Credenciales correctas del usuario: " + usuarios.getUsuario());
                    respuesta.setColaborador(usuarios);
                } else {
                    respuesta.setError(true);
                    respuesta.setMensaje("Usuario y/o Contraseña incorrectos");
                }
            } catch (Exception e) {
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());
            } finally {
                conexionBD.close();
            }
        } else {
            respuesta.setError(true);
            respuesta.setMensaje("Por el momento no se encuentra la información.");
        }
        return respuesta;
    }
}
