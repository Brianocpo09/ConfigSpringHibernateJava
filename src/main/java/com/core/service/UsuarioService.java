/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.service;

import com.core.serviceInterface.IUsuarioService;
import com.core.daoInterface.IUsuarioDAO;
import com.core.entity.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sistemas
 */
@Service
public class UsuarioService implements IUsuarioService{
    @Autowired
    private IUsuarioDAO usuarioDAO;

    @Override
    public List<Usuario> getAllUsuario() {
        return usuarioDAO.getAllUsuario();
    }

    @Override
    public Usuario getUsuarioById(int id) {
        Usuario obj = usuarioDAO.getUsuarioById(id);
	return obj;
    }

    @Override
    public synchronized boolean  addUsuario(Usuario usuario) {
        if  (usuarioDAO.usuarioExists(usuario.getNombreUsu())) {
    	         return false;
            } 
        else{
    	         usuarioDAO.addPUsuario(usuario);
    	         return true;
            }   
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        usuarioDAO.updateUsuario(usuario);
    }

    @Override
    public void deleteUsuario(int id) {
       usuarioDAO.deleteUsuario(id);
    }
}
