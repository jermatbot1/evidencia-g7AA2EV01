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
public class agregar {
    
    public static void main (String [] args){
        conexion con = new conexion();
        Connection cn;
        ResultSet rs;
        Statement st;
        
        String nombre_actividad = "Siembra de arboles";
        String descripcion = "Reforestacion del area norte de la Normal Superior";
        String fecha_programada = "2026-10-25";
        String estado = "Pendiente";
        String id_proyecto = "4"; // Debe existir en la tabla proyectos
        
        String sql = "INSERT INTO actividades (nombre_actividad, descripcion, fecha_programada, estado, id_proyecto) values ('"+nombre_actividad+"','"+descripcion+"','"+fecha_programada+"','"+estado+"','"+id_proyecto+"')"; 
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex){
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cn = con.getConnection();
            st = cn.createStatement();
            st.executeUpdate (sql);
            rs = st.executeQuery("SELECT * FROM actividades");
            if (rs.next()) {
                do {
                    System.out.println(rs.getInt ("id_actividad") + ":" +rs.getString ("nombre_actividad") + "-" +rs.getString ("descripcion")+ "-" +rs.getString ("fecha_programada") + "-" +rs.getString ("estado") + "-" +rs.getString ("id_proyecto") + "-");
                } while (rs.next());
            }
        }catch (SQLException ex){
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}