package com.iplacex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.iplacex.dto.UsuarioDTO;

public class UsuarioDao {
	public static UsuarioDTO validate(String user, String pass) {        
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        UsuarioDTO usr = new UsuarioDTO();


        String url = "jdbc:mysql://localhost:8080/";
        String dbName = "banco";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager
                    .getConnection(url + dbName, userName, password);
            pst = conn.prepareStatement("select * from usuario where username=? and password=?");
            pst.setString(1, user);
            pst.setString(2, pass);
            rs = pst.executeQuery();
            while(rs.next()){
                int rut =rs.getInt("rut");
                String name = rs.getString("username");
                String pwrd = rs.getString("password");
                usr.setRutUsuario(rut);
                usr.setNombreUsuario(name);
                usr.setPassUsuario(pwrd);
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
        return usr;
    }
}
