package DAO;

import Conexion.ConexionBD;
import Modelos.usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class usuarioDAOImplementacion  extends ConexionBD implements UsuarioDAO{

    @Override
    public void insert(usuario Usuario) throws Exception {
      String sql = "insert into usuarios (nombre,correo,clave) values (?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, Usuario.getNombre());
        ps.setString(2, Usuario.getCorreo());
        ps.setString(3, Usuario.getClave());
        ps.executeUpdate();
        this.desconectar();
      }

    @Override
    public void update(usuario Usuario) throws Exception {
      String sql = "update usuarios set nombre=?, correo=?,clave=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,Usuario.getNombre());
        ps.setString(2,Usuario.getCorreo());
        ps.setString(3,Usuario.getClave());
        ps.setInt(4, Usuario.getId());
        ps.executeUpdate();
        this.desconectar();
      }

    @Override
    public void delete(int id) throws Exception {
      String sql = "delete from usuarios where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
      }

    @Override
    public List<usuario> getAll() throws Exception {
      List<usuario> lista = null;
        String sql = "select * from usuarios";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        lista = new ArrayList<usuario>();
        while(rs.next()){
            usuario usu = new usuario();
            
            usu.setId(rs.getInt("id"));
            usu.setNombre(rs.getString("nombre"));
            usu.setCorreo(rs.getString("correo"));
            usu.setClave(rs.getString("clave"));
            
            lista.add(usu);
        }
        this.desconectar();
        return lista;
      }

    @Override
    public usuario getById(int id) throws Exception {
      usuario usu = new usuario();
        try {
            String sql = "select * from usuario where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                usu.setId(rs.getInt("id"));
                usu.setNombre(rs.getString("nombre"));
                usu.setCorreo(rs.getString("correo"));
                usu.setClave(rs.getString("clave"));
            
            }
        } catch (SQLException e) {
            throw e;
        } finally{
            this.desconectar();
        }
        return usu;
      }

}