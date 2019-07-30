/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.service;

import com.core.entity.STipoUsuario;
import com.core.entity.SUsuario;
import com.core.serviceInterface.ISTipoUsuarioService;
import com.core.serviceInterface.ISUsuarioService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



/**
 *
 * @author sistemas
 */
@Service
public class UserDetailsServiceImp implements UserDetailsService{

    @Autowired
    private ISUsuarioService usuarioService;

    @Autowired
    private ISTipoUsuarioService tipousuarioService;

    @Override
    public
    UserDetails loadUserByUsername(String usuarioUsu) throws UsernameNotFoundException {
       
        SUsuario usuario=usuarioService.BuscarUsuario(usuarioUsu);
        String[] roles=tipousuarioService.StringTipoUsuario();
        UserBuilder builder = null;
        if(usuario==null){
             throw new UsernameNotFoundException("username " + usuarioUsu
                + " not found");
        }else{
                builder = org.springframework.security.core.userdetails.User.withUsername(usuarioUsu);
                builder.password(new BCryptPasswordEncoder().encode(usuario.getClaveUsu()));
                builder.roles(roles);
        }
        return builder.build();
    }
    
    
    
}
