package DAO;

import Modelos.usuario;
import java.util.List;

public interface UsuarioDAO {
    public void insert(usuario Usuario)throws Exception;
    public void update (usuario Usuario)throws Exception;
    public void delete (int id)throws Exception;
    public List<usuario> getAll() throws Exception;
    public usuario getById(int id) throws Exception;
}


