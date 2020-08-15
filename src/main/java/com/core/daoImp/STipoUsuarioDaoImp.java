/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.daoImp;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.core.entity.STipoUsuario;
import com.core.dao.STipoUsuarioDao;

/**
 *
 * @author sistemas
 */

@Transactional
@Repository
public class STipoUsuarioDaoImp implements STipoUsuarioDao{

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
    public String[] StringTipoUsuario() {
        String hql = "FROM STipoUsuario ";
        String[] roles = null;
        int pos=0;
        List<STipoUsuario> list=(List<STipoUsuario>) getCurrentSession().createQuery(hql).list();
        if(list.size()>0){
            roles=new String[list.size()];
            for (STipoUsuario usuario : list){
                roles[pos]= usuario.getNombreTus();
                pos++;
            }
        }
        return  roles;
    }
    
}
