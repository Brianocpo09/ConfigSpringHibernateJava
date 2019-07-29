/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sistemas
 */
@Entity
@Table(name = "s_tipo_usuario")

public class STipoUsuario implements Serializable {

    @OneToMany(mappedBy = "codigoTus")
    private Collection<SUsuario> sUsuarioCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_tus", updatable = false, nullable = false)
    private Integer codigoTus;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nombre_tus")
    private String nombreTus;

    public STipoUsuario() {
    }

    public STipoUsuario(Integer codigoTus) {
        this.codigoTus = codigoTus;
    }

    public STipoUsuario(Integer codigoTus, String nombreTus) {
        this.codigoTus = codigoTus;
        this.nombreTus = nombreTus;
    }

    public Integer getCodigoTus() {
        return codigoTus;
    }

    public void setCodigoTus(Integer codigoTus) {
        this.codigoTus = codigoTus;
    }

    public String getNombreTus() {
        return nombreTus;
    }

    public void setNombreTus(String nombreTus) {
        this.nombreTus = nombreTus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTus != null ? codigoTus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof STipoUsuario)) {
            return false;
        }
        STipoUsuario other = (STipoUsuario) object;
        if ((this.codigoTus == null && other.codigoTus != null) || (this.codigoTus != null && !this.codigoTus.equals(other.codigoTus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.core.entity.STipoUsuario[ codigoTus=" + codigoTus + " ]";
    }

    @XmlTransient
    public Collection<SUsuario> getSUsuarioCollection() {
        return sUsuarioCollection;
    }

    public void setSUsuarioCollection(Collection<SUsuario> sUsuarioCollection) {
        this.sUsuarioCollection = sUsuarioCollection;
    }
    
}
