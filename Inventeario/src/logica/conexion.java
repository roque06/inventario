/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/**
 *
 * @author CARLOS
 */
public class conexion {
    public String db="inventario1";
    public String url="jdbc:mysql://localhost/" +db;
    public String user="root";
    public String pass="cacaroto56";

    public conexion() {
    }
    
    public Connection conectar(){
        Connection link=null;
        
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link =DriverManager.getConnection(this.url, this.user, this.pass);
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            
        }
        
        return link;
    }
}
    
   
    
    