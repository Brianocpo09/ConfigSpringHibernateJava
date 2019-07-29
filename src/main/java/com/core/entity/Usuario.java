/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sistemas
 */
@Entity
@Table(name = "s_usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_usu")
    private Integer codigoUsu;
    @Size(max = 255)
    @Column(name = "clave_usu")
    private String claveUsu;
    @Size(max = 255)
    @Column(name = "nombre_usu")
    private String nombreUsu;

    public Usuario() {
    }

    public Usuario(Integer codigoUsu) {
        this.codigoUsu = codigoUsu;
    }

    public Integer getCodigoUsu() {
        return codigoUsu;
    }

    public void setCodigoUsu(Integer codigoUsu) {
        this.codigoUsu = codigoUsu;
    }

    public String getClaveUsu() {
        return claveUsu;
    }

    public void setClaveUsu(String claveUsu) {
        this.claveUsu = claveUsu;
    }

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoUsu != null ? codigoUsu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codigoUsu == null && other.codigoUsu != null) || (this.codigoUsu != null && !this.codigoUsu.equals(other.codigoUsu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.core.entity.SUsuario[ codigoUsu=" + codigoUsu + " ]";
    }
    
}
