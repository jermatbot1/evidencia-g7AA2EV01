/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evidencias;

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
public class eliminar {
    
    public static void main (String [] args){
        conexion con = new conexion();
        Connection cn;
        ResultSet rs;
        Statement st;
        
        String id_evidencia = "4";
        
        String sql = "DELETE FROM evidencias WHERE id_evidencia='"+id_evidencia+"'"; 
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex){
            Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cn = con.getConnection();
            st = cn.createStatement();
            st.executeUpdate (sql);
            
            System.out.println("Registro eliminado. Lista actualizada:");
            rs = st.executeQuery("SELECT * FROM evidencias");
            if(rs.next()){
                do {
                    System.out.println(rs.getInt ("id_evidencia") + ":" +rs.getString ("nombre_archivo") + "-" +rs.getString ("ruta_archivo")+ "-" +rs.getString ("tipo_archivo") + "-" +rs.getString ("fecha_subida") + "-" +rs.getString ("id_actividad") + "-" +rs.getString ("id_usuario_sube") + "-");
                } while (rs.next());
            } else {
                System.out.println("No hay registros en la tabla.");
            }
        }catch (SQLException ex){
            Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}