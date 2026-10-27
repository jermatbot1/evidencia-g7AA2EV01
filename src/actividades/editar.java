/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividades;

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
        
        String id_actividad = "2"; 
        String nombre_actividad = "Charla de reciclaje";
        String descripcion = "Capacitacion sobre separacion de residuos";
        String fecha_programada = "2026-11-05";
        String estado = "En proceso";
        String id_proyecto = "4";
        
        String sql = "UPDATE actividades SET nombre_actividad='"+nombre_actividad+"', descripcion='"+descripcion+"', fecha_programada='"+fecha_programada+"', estado='"+estado+"', id_proyecto='"+id_proyecto+"' WHERE id_actividad='"+id_actividad+"'"; 
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex){
            Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cn = con.getConnection();
            st = cn.createStatement();
            st.executeUpdate (sql);
            
            System.out.println("Registro modificado correctamente. Nueva lista:");
            rs = st.executeQuery("SELECT * FROM actividades");
            if(rs.next()){
                do {
                    System.out.println(rs.getInt ("id_actividad") + ":" +rs.getString ("nombre_actividad") + "-" +rs.getString ("descripcion")+ "-" +rs.getString ("fecha_programada") + "-" +rs.getString ("estado") + "-" +rs.getString ("id_proyecto") + "-");
                } while (rs.next());
            }
        }catch (SQLException ex){
            Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}