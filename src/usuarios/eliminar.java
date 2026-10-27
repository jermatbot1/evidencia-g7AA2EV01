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
public class eliminar {
    
    public static void main (String [] args){
        conexion con = new conexion();
        Connection cn;
        ResultSet rs;
        Statement st;
        
        String id_usuario = "2"; // ID del usuario a eliminar
        
        String sql = "DELETE FROM usuarios WHERE id_usuario=" + id_usuario; 
        
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
                System.out.println("Usuario eliminado con éxito, Lista actualizada:");
            } else {
                System.out.println("No se encontro ningun usuario con el ID: " + id_usuario + " para eliminar.");
            }
            
            rs = st.executeQuery("SELECT * FROM usuarios");
            if(rs.next()){
                do {
                    System.out.println(rs.getInt ("id_usuario") + ":" + rs.getString ("nombres") + " " + rs.getString ("apellidos") + " - " + rs.getString ("correo") + "-");
                } while (rs.next());
            } else {
                System.out.println("La tabla usuarios ahora está vacía.");
            }
        }catch (SQLException ex){
            Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Si el usuario tiene proyectos, evidencias o participaciones asignadas, fallara por restriccion de llave foranea y no podra ser eliminada");
        }
    }
}