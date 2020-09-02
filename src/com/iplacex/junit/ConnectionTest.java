package com.iplacex.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.iplacex.dao.UsuarioDao;
import com.iplacex.dto.UsuarioDTO;



public class ConnectionTest {

	@Test
	public void testConnection() {
		System.out.println("Conexion BD");
		try {
			UsuarioDao user = new UsuarioDao();
			UsuarioDTO validate = user.validate("ybaezac", "ybaezac");
			UsuarioDTO usr = validate;
			assertEquals(usr.getNombreUsuario(), "ybaezac", "ybaezac");
			System.out.println("Conexion BD exitosa");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			fail(e.getMessage());
			System.out.println("Conexion BD fallo");
		}
	}

}
