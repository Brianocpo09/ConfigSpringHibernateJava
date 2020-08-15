/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.service;

import com.core.entity.SUsuario;
import java.util.List;

/**
 *
 * @author sistemas
 */
public interface SUsuarioService {
     List<SUsuario> getAllUsuario();
     SUsuario getUsuarioById(int pid);
     boolean addUsuario(SUsuario usuario);
     void updateUsuario(SUsuario usuario);
     void deleteUsuario(int pid);
     SUsuario BuscarUsuario(String usuarioUsu);
}
