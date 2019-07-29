/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.serviceInterface;

import com.core.entity.STipoUsuario;
import java.util.List;

/**
 *
 * @author sistemas
 */
public interface ISTipoUsuarioService {
     List<STipoUsuario> getAllTipoUsuario();
     STipoUsuario getTipoUsuarioById(int id);
     boolean addTipoUsuario(STipoUsuario tipousuario);
     void updateTipoUsuario(STipoUsuario tipousuario);
     void deleteTipoUsuario(int id);
}
