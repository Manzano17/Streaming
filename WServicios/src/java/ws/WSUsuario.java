/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import dominio.ImpUsuario;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import pojo.LoginUsuario;

/**
 *
 * @author Manzano
 */
@Path("login")
public class WSUsuario {

    @Context
    private UriInfo context;

    public WSUsuario() {
    }

    @Path("usuario")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public LoginUsuario iniciarSesionColaborador(@FormParam("usuario") String usuario, @FormParam("contrasenia") String contrasenia) {
        if ((usuario != null && !usuario.isEmpty())
                && contrasenia != null && !contrasenia.isEmpty()) {
            return ImpUsuario.validarSesionUsuario(usuario, contrasenia);
        }

        throw new BadRequestException();
    }
}
