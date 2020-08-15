/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.serviceImp;

import com.core.entity.SUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.core.dao.SUsuarioDAO;
import com.core.service.SUsuarioService;

/**
 *
 * @author sistemas
 */
@Service
public class SUsuarioServiceImp implements SUsuarioService{
    @Autowired
    private SUsuarioDAO usuarioDAO;

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