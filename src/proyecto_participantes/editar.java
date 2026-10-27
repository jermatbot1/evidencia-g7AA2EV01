/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_participantes;

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
        
        String id_proyecto = "4";
        String id_usuario = "2";
        String nueva_fecha = "2026-10-15 12:00:00";
        
        String sql = "UPDATE proyecto_participantes SET fecha_asignacion='" + nueva_fecha + 
                     "' WHERE id_proyecto=" + id_proyecto + " AND id_usuario=" + id_usuario; 
        
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
                System.out.println("Asignacion modificada correctamente, Nueva lista:");
            } else {
                System.out.println("No se encontro el registro con ID Proyecto: " + id_proyecto + " e ID Usuario: " + id_usuario);
            }
            
            rs = st.executeQuery("SELECT * FROM proyecto_participantes");
            if(rs.next()){
                do {
                    System.out.println(rs.getInt ("id_proyecto") + ":" + rs.getInt ("id_usuario") + " - " + rs.getString ("fecha_asignacion") + "-");
                } while (rs.next());
            }
        }catch (SQLException ex){
            Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}