/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectos;

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
        
        String id_proyecto = "3"; 
        String titulo_proyecto = "Proyecto Ambiental Actualizado";
        String descripcion = "Iniciativa mejorada de reciclaje escolar";
        String fecha_inicio = "2026-01-15";
        String fecha_fin = "2026-12-30";
        String estado = "en curso";
        String id_docente_lider = "2";
        
        String sql = "UPDATE proyectos SET titulo_proyecto='" + titulo_proyecto +"', descripcion='" + descripcion + "', fecha_inicio='" + fecha_inicio + "', fecha_fin='" + fecha_fin + "', estado='" + estado + "', id_docente_lider=" + id_docente_lider + " WHERE id_proyecto=" + id_proyecto; 
        
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
                System.out.println("Proyecto modificado correctamente! Nueva lista:");
            } else {
                System.out.println("No se encontró ningún proyecto con el ID: " + id_proyecto);
            }
            
            rs = st.executeQuery("SELECT * FROM proyectos");
            if(rs.next()){
                do {
                    System.out.println(rs.getInt ("id_proyecto") + ":" + rs.getString ("titulo_proyecto") + "-" + rs.getString ("descripcion")+ "-" + rs.getString ("fecha_inicio") + "-" + rs.getString ("fecha_fin") + "-" + rs.getString ("estado") + "-" + rs.getString ("id_docente_lider") + "-");
                } while (rs.next());
            }
        }catch (SQLException ex){
            Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}