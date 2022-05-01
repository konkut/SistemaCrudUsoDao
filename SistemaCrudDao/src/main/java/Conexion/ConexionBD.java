package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionBD {
    static public String driver="com.mysql.jdbc.Driver";
    static public String url ="jdbc:mysql://localhost:3306/bd_anuncios";
    static public String usuario="root";
    static public String password="";

    protected Connection conn = null;

    public ConexionBD() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"error en el driver"+ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error al conectar"+ex.getMessage());   }
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al cerrar la conexión: "+ex.getMessage());
        }
    }
}


