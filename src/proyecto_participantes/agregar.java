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
public class agregar {
    
    public static void main (String [] args){
        conexion con = new conexion();
        Connection cn;
        ResultSet rs;
        Statement st;
        
        String id_proyecto = "4"; 
        String id_usuario = "2";  
        
        String sql = "INSERT INTO proyecto_participantes (id_proyecto, id_usuario) values ('"+id_proyecto+"','"+id_usuario+"')"; 
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex){
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cn = con.getConnection();
            st = cn.createStatement();
            st.executeUpdate (sql);
            rs = st.executeQuery("SELECT * FROM proyecto_participantes");
            if (rs.next()) {
                do {
                    System.out.println(rs.getInt ("id_proyecto") + ":" + rs.getInt ("id_usuario") + " - " + rs.getString ("fecha_asignacion") + "-");
                } while (rs.next());
            }
        }catch (SQLException ex){
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}