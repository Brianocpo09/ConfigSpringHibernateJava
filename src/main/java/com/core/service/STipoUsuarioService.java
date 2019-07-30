/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.service;

import com.core.serviceInterface.ISTipoUsuarioService;
import com.core.daoInterface.ISTipoUsuarioDAO;
import com.core.entity.STipoUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sistemas
 */
@Service
public class STipoUsuarioService implements ISTipoUsuarioService{
    @Autowired
    private ISTipoUsuarioDAO tipousuarioDAO;

    @Override
    public List<STipoUsuario> getAllTipoUsuario() {
        return tipousuarioDAO.getAllSTipoUsuario();
    }

    @Override
    public STipoUsuario getTipoUsuarioById(int id) {
        STipoUsuario obj = tipousuarioDAO.getSTipoUsuarioById(id);
	return obj;
    }

    @Override
    public synchronized boolean  addTipoUsuario(STipoUsuario tipousuario) {
        tipousuarioDAO.addSTipoUsuario(tipousuario);
        return true;
    }

    @Override
    public void updateTipoUsuario(STipoUsuario tipousuario) {
        tipousuarioDAO.updateSTipoUsuario(tipousuario);
    }

    @Override
    public void deleteTipoUsuario(int id) {
       tipousuarioDAO.deleteSTipoUsuario(id);
    }
    @Override
    public String[] StringTipoUsuario(){
        return tipousuarioDAO.StringTipoUsuario();
    }
}