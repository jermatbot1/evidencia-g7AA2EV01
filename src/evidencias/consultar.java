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
public class consultar {
    
    public static void main (String [] args){
        conexion con = new conexion();
        Connection cn;
        ResultSet rs;
        Statement st;
        
        String sql = "SELECT * FROM evidencias"; 
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex){
            Logger.getLogger(consultar.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cn = con.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            
            if(rs.next()){
                do {
                    System.out.println(rs.getInt ("id_evidencia") + ":" +rs.getString ("nombre_archivo") + "-" +rs.getString ("ruta_archivo")+ "-" +rs.getString ("tipo_archivo") + "-" +rs.getString ("fecha_subida") + "-" +rs.getString ("id_actividad") + "-" +rs.getString ("id_usuario_sube") + "-");
                } while (rs.next());
            } else {
                System.out.println("No hay evidencias registradas.");
            }
        }catch (SQLException ex){
            Logger.getLogger(consultar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
