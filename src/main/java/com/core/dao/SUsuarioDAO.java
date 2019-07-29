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
import com.core.daoInterface.ISUsuarioDAO;
import com.core.entity.SUsuario;
/**
 *
 * @author sistemas
 */

@Transactional
@Repository
public class SUsuarioDAO implements ISUsuarioDAO{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    //@SuppressWarnings("unchecked")
    @Override
    public List<SUsuario> getAllUsuario() {
        String hql = "FROM SUsuario ";
	return (List<SUsuario>) getCurrentSession().createQuery(hql).list();
    }

    @Override
    public SUsuario getUsuarioById(int id) {
       return getCurrentSession().get(SUsuario.class, id);
    }

    @Override
    public void addPUsuario(SUsuario usuario) {
        getCurrentSession().save(usuario);
    }

    @Override
    public void updateUsuario(SUsuario usuario) {
        SUsuario u = getUsuarioById(usuario.getCodigoUsu());
        u.setClaveUsu(usuario.getClaveUsu());
        u.setNombreUsu(usuario.getNombreUsu());
        u.setEstadoUsu(usuario.getEstadoUsu());
        u.setCodigoTus(usuario.getCodigoTus());
        u.setUsuarioUsu(usuario.getUsuarioUsu());
        getCurrentSession().update(u);
    }

    @Override
    public void deleteUsuario(int id) {
        getCurrentSession().delete(getUsuarioById(id));
    }

    @Override
    public boolean usuarioExists(String usuarioUsu) {
        String hql = "FROM SUsuario as u WHERE u.usuario_usu = '"+usuarioUsu+"'";
        List<SUsuario> usuario = (List<SUsuario>) getCurrentSession().createQuery(hql).list();
        return usuario.size() > 0;
    }
    
}
