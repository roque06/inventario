
package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class tonerrecibo {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistro;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos
                = { "ID TONER","FECHA", "CANTIDAD", "MODELO"};

        String[] registro = new String[5];
        totalregistro = 0;

        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select *From tonerrecibo where CONCAT (idrecibo,'',fecha,'',modelo)like '%" + buscar + "%' order by idrecibo";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idrecibo");
                registro[1] = rs.getString("fecha");
                registro[2] = rs.getString("cantidad");
                registro[3] = rs.getString("modelo");
                
                

                totalregistro = totalregistro + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;

        }

    }
    
    
    public boolean insertar(feliminar dts) {
        sSQL = "insert into tonerrecibo (idrecibo,fecha,cantidad,modelo)"
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getId());
            pst.setDate(2, dts.getFecha());
            pst.setString(3, dts.getCantidad());
            pst.setString(4, dts.getModelo());
           
            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }

    public boolean editar(feliminar dts) {
        sSQL = "UPDATE tonerrecibo set fecha=?,cantidad=?,modelo=?"
                + "where idrecibo=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

             
            pst.setDate(1, dts.getFecha());
            pst.setString(2, dts.getCantidad());
            pst.setString(3, dts.getModelo());

            pst.setInt(4, dts.getId());
            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return false;

    }
  
    public boolean eliminar(feliminar dts) {
        sSQL = "DELETE FROM tonerrecibo WHERE idrecibo=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getId());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return false;

    }

     
}
