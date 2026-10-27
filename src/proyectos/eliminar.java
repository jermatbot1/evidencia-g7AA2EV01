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
public class eliminar {
    
    public static void main (String [] args){
        conexion con = new conexion();
        Connection cn;
        ResultSet rs;
        Statement st;
        
        String id_proyecto = "4"; // ID del proyecto a eliminar
        
        String sql = "DELETE FROM proyectos WHERE id_proyecto=" + id_proyecto; 
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex){
            Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cn = con.getConnection();
            st = cn.createStatement();
            int filasAfectadas = st.executeUpdate(sql);
            
            if (filasAfectadas > 0) {
                System.out.println("¡Proyecto eliminado con éxito! Lista actualizada:");
            } else {
                System.out.println("No se encontró ningún proyecto con el ID: " + id_proyecto + " para eliminar.");
            }
            
            rs = st.executeQuery("SELECT * FROM proyectos");
            if(rs.next()){
                do {
                    System.out.println(rs.getInt ("id_proyecto") + ":" + rs.getString ("titulo_proyecto") + "-" + rs.getString ("descripcion")+ "-" + rs.getString ("fecha_inicio") + "-" + rs.getString ("fecha_fin") + "-" + rs.getString ("estado") + "-" + rs.getString ("id_docente_lider") + "-");
                } while (rs.next());
            } else {
                System.out.println("La tabla proyectos ahora está vacía.");
            }
        }catch (SQLException ex){
            Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Nota: Si el proyecto tiene actividades o participantes vinculados, fallará por restricción de llave foránea.");
        }
    }
}