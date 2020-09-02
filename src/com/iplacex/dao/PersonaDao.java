package com.iplacex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.iplacex.dto.PersonaDTO;

public class PersonaDao {
	public static PersonaDTO validate(String rut) {        
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        PersonaDTO persona = new PersonaDTO();
        String url = "jdbc:mysql://localhost:8080/";
        String dbName = "banco";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager
                    .getConnection(url + dbName, userName, password);
            pst = conn
                    .prepareStatement("select * from persona where rut=?");
            pst.setString(1, rut);
            rs = pst.executeQuery();
            while(rs.next()){
                int rutpers =rs.getInt("rut");
                String name = rs.getString("nombre");
                String lastname = rs.getString("apellido");
                int phone = rs.getInt("telefono");
                Date fecha = rs.getDate("fechaIngreso");
                persona.setApellido(lastname);
                persona.setFechaIngreso(fecha);
                persona.setNombre(name);
                persona.setRut(rutpers);
                persona.setTelefono(phone);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return persona;
    }
}
