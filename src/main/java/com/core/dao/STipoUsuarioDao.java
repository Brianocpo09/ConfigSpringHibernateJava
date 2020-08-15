/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.dao;

import com.core.entity.STipoUsuario;
import java.util.List;

/**
 *
 * @author sistemas
 */
public interface STipoUsuarioDao {
    List<STipoUsuario> getAllSTipoUsuario();
    STipoUsuario getSTipoUsuarioById(int id);
    void addSTipoUsuario(STipoUsuario tipousuario);
    void updateSTipoUsuario(STipoUsuario tipousuario);
    void deleteSTipoUsuario(int id);
    String[] StringTipoUsuario();
}
