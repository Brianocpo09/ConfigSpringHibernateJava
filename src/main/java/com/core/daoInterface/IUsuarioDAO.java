/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.daoInterface;
import com.core.entity.Usuario;
import java.util.List;

/**
 *
 * @author sistemas
 */
public interface  IUsuarioDAO {
    List<Usuario> getAllUsuario();
    Usuario getUsuarioById(int pid);
    void addPUsuario(Usuario usuario);
    void updateUsuario(Usuario usuario);
    void deleteUsuario(int pid);
    boolean usuarioExists(String username);
}
