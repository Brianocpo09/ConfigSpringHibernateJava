/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.service;

import com.core.serviceInterface.ISUsuarioService;
import com.core.daoInterface.ISUsuarioDAO;
import com.core.entity.SUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sistemas
 */
@Service
public class SUsuarioService implements ISUsuarioService{
    @Autowired
    private ISUsuarioDAO usuarioDAO;

    @Override
    public List<SUsuario> getAllUsuario() {
        return usuarioDAO.getAllUsuario();
    }

    @Override
    public SUsuario getUsuarioById(int id) {
        SUsuario obj = usuarioDAO.getUsuarioById(id);
	return obj;
    }

    @Override
    public synchronized boolean  addUsuario(SUsuario usuario) {
        if  (usuarioDAO.usuarioExists(usuario.getNombreUsu())) {
    	         return false;
            } 
        else{
    	         usuarioDAO.addPUsuario(usuario);
    	         return true;
            }   
    }

    @Override
    public void updateUsuario(SUsuario usuario) {
        usuarioDAO.updateUsuario(usuario);
    }

    @Override
    public void deleteUsuario(int id) {
       usuarioDAO.deleteUsuario(id);
    }
    
    @Override
    public SUsuario BuscarUsuario(String usuarioUsu){
        SUsuario usuario=usuarioDAO.BuscarUsuario(usuarioUsu);
        return usuario;
    }
}