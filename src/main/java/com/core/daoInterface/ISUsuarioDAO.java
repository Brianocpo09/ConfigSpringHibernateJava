/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.daoInterface;

import com.core.entity.SUsuario;
import java.util.List;
/**
 *
 * @author sistemas
 */
public interface ISUsuarioDAO {
    List<SUsuario> getAllUsuario();
    SUsuario getUsuarioById(int id);
    void addPUsuario(SUsuario usuario);
    void updateUsuario(SUsuario usuario);
    void deleteUsuario(int id);
    boolean usuarioExists(String username);
    SUsuario BuscarUsuario(String username);
}
