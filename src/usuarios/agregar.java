/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;

import conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jermat
 */
public class agregar {
    
    public static void main (String [] args){
        conexion con = new conexion();
        Connection cn;
        ResultSet rs;
        Statement st;
        String tipo_documento = "CC";
        String numero_documento = "1094234432";
        String nombres = "pepito ramon";
        String apellidos = "duran villa";
        String correo = "pepitovill@gmail.com";
        String contrasenia = "123456";
        String telefono = "3121234324";
        String id_rol = "8";
        String estado = "ACTIVO";
        String fecha_registro = "2026-09-12 17:55:00";
        String sql = "INSERT INTO usuarios (tipo_documento, numero_documento, nombres, apellidos, correo, contrasenia, telefono, id_rol, estado, fecha_registro) values ('"+tipo_documento+"','"+numero_documento+"','"+nombres+"','"+apellidos+"','"+correo+"','"+contrasenia+"','"+telefono+"','"+id_rol+"','"+estado+"','"+fecha_registro+"')";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex){
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cn = con.getConnection();
            st = cn.createStatement();
            st.executeUpdate (sql);
            rs = st.executeQuery("SELECT * FROM usuarios");
            rs.next();
            do {
                System.out.println(rs.getInt ("id_usuario") + ":" +rs.getString ("tipo_documento") + "-" +rs.getInt ("numero_documento")+ "-" +rs.getString ("nombres") + "-" +rs.getString ("apellidos") + "-" +rs.getString ("correo") + "-" +rs.getString ("contrasenia") + "-" +rs.getString ("telefono") + "-" +rs.getString ("id_rol") + "-" +rs.getString ("estado") + "-" +rs.getString ("fecha_registro") + "-");
            } while (rs.next());
            }catch (SQLException ex){
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
