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
public class agregar {
    
    public static void main (String [] args){
        conexion con = new conexion();
        Connection cn;
        ResultSet rs;
        Statement st;
        String nombre_archivo = "acta_reunion";
        String ruta_archivo = "/docs/acta_reunion.pdf";
        String tipo_archivo = "pdf";
        String id_actividad = "3";
        String id_usuario_sube = "2";
        
        String sql = "INSERT INTO evidencias (nombre_archivo, ruta_archivo, tipo_archivo, id_actividad, id_usuario_sube) values ('"+nombre_archivo+"','"+ruta_archivo+"','"+tipo_archivo+"','"+id_actividad+"','"+id_usuario_sube+"')"; 
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex){
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cn = con.getConnection();
            st = cn.createStatement();
            st.executeUpdate (sql);
            rs = st.executeQuery("SELECT * FROM evidencias");
            rs.next();
            do {
                System.out.println(rs.getInt ("id_evidencia") + ":" +rs.getString ("nombre_archivo") + "-" +rs.getString ("ruta_archivo")+ "-" +rs.getString ("tipo_archivo") + "-" +rs.getString ("fecha_subida") + "-" +rs.getString ("id_actividad") + "-" +rs.getString ("id_usuario_sube") + "-");
            } while (rs.next());
        }catch (SQLException ex){
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}