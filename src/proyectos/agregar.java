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
public class agregar {
    
    public static void main (String [] args){
        conexion con = new conexion();
        Connection cn;
        ResultSet rs;
        Statement st;
        
        String titulo_proyecto = "Proyecto Ambiental PRAE";
        String descripcion = "Iniciativa de reciclaje y reforestacion escolar";
        String fecha_inicio = "2026-01-15 08:00:00"; 
        String fecha_fin = "2026-11-30 18:00:00";    
        String estado = "en curso";
        String id_docente_lider = "2"; 
       
        
        
String sql = "INSERT INTO proyectos (titulo_proyecto, descripcion, fecha_inicio, fecha_fin, estado, id_docente_lider) values ('"+titulo_proyecto+"','"+descripcion+"','"+fecha_inicio+"','"+fecha_fin+"','"+estado+"','"+id_docente_lider+"')";        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex){
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cn = con.getConnection();
            st = cn.createStatement();
            st.executeUpdate (sql);
            rs = st.executeQuery("SELECT * FROM proyectos");
            rs.next();
            do {
                    System.out.println(rs.getInt("id_proyecto") + ":" + rs.getString("titulo_proyecto") + "-" + rs.getString("descripcion") + "-" + rs.getString("fecha_inicio") + "-" + rs.getString("fecha_fin") + "-" + rs.getString("estado") + "-" + rs.getString("id_docente_lider") + " este es el numero del docente");            } while (rs.next());
            }catch (SQLException ex){
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
