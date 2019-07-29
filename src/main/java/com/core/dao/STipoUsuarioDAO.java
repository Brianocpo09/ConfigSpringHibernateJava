/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.dao;


import com.core.daoInterface.ISTipoUsuarioDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.core.entity.STipoUsuario;

/**
 *
 * @author sistemas
 */

@Transactional
@Repository
public class STipoUsuarioDAO implements ISTipoUsuarioDAO{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    //@SuppressWarnings("unchecked")
    @Override
    public List<STipoUsuario> getAllSTipoUsuario() {
        String hql = "FROM STipoUsuario ";
	return (List<STipoUsuario>) getCurrentSession().createQuery(hql).list();
    }

    @Override
    public STipoUsuario getSTipoUsuarioById(int id) {
       return getCurrentSession().get(STipoUsuario.class, id);
    }

    @Override
    public void addSTipoUsuario(STipoUsuario TipoUsuario) {
        getCurrentSession().save(TipoUsuario);
    }

    @Override
    public void updateSTipoUsuario(STipoUsuario TipoUsuario) {
        STipoUsuario u = getSTipoUsuarioById(TipoUsuario.getCodigoTus());
        u.setNombreTus(TipoUsuario.getNombreTus());
        getCurrentSession().update(u);
    }

    @Override
    public void deleteSTipoUsuario(int id) {
        getCurrentSession().delete(getSTipoUsuarioById(id));
    }

    @Override
    public boolean STipoUsuarioExists(String nombre) {
        String hql = "FROM STipoUsuario as u WHERE u.nombre_tus = '"+nombre+"'";
        List<STipoUsuario> TipoUsuario = (List<STipoUsuario>) getCurrentSession().createQuery(hql).list();
        return TipoUsuario.size() > 0;
    }
    
}
