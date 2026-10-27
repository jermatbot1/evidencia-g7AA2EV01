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
public class editar {
    
    public static void main (String [] args){
        conexion con = new conexion();
        Connection cn;
        ResultSet rs;
        Statement st;
        
        String id_usuario = "2"; // ID de usuario existente en db_prae.sql (pepito ramon)
        String nombres = "Pepito Ramon";
        String apellidos = "Duran Villa";
        String correo = "pepitovill@gmail.com";
        String telefono = "3121234324";
        String estado = "ACTIVO";
        
        String sql = "UPDATE usuarios SET nombres='" + nombres +    "', apellidos='" + apellidos + "', correo='" + correo + "', telefono='" + telefono + "', estado='" + estado + "' WHERE id_usuario=" + id_usuario; 
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex){
            Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cn = con.getConnection();
            st = cn.createStatement();
            int filasAfectadas = st.executeUpdate(sql);
            
            if (filasAfectadas > 0) {
                System.out.println("Usuario modificado correctamente, Nueva lista:");
            } else {
                System.out.println("No se encontró ningún usuario con el ID: " + id_usuario);
            }
            
            rs = st.executeQuery("SELECT * FROM usuarios");
            if(rs.next()){
                do {
                    System.out.println(rs.getInt ("id_usuario") + ":" + rs.getString ("nombres") + " " + rs.getString ("apellidos") + " - " + rs.getString ("correo") + " - " + rs.getString ("estado") + "-");
                } while (rs.next());
            }
        }catch (SQLException ex){
            Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
