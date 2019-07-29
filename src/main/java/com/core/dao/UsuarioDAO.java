/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.core.daoInterface.IUsuarioDAO;
import com.core.entity.Usuario;
/**
 *
 * @author sistemas
 */
@Transactional
@Repository
public class UsuarioDAO implements IUsuarioDAO{
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Usuario> getAllUsuario() {
        String hql = "FROM Usuario ";
	return (List<Usuario>) getCurrentSession().createQuery(hql).list();
    }

    @Override
    public Usuario getUsuarioById(int id) {
       return getCurrentSession().get(Usuario.class, id);
    }

    @Override
    public void addPUsuario(Usuario usuario) {
        getCurrentSession().save(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        Usuario u = getUsuarioById(Integer.parseInt(usuario.getClaveUsu()));
        u.setClaveUsu(usuario.getClaveUsu());
        u.setNombreUsu(usuario.getNombreUsu());
        getCurrentSession().update(u);
    }

    @Override
    public void deleteUsuario(int id) {
        getCurrentSession().delete(getUsuarioById(id));
    }

    @Override
    public boolean usuarioExists(String username) {
        String hql = "FROM Usuario as u WHERE u.nombre_usu = '"+username+"'";
        List<Usuario> usuario = (List<Usuario>) getCurrentSession().createQuery(hql).list();
        return usuario.size() > 0;
    }
      
}