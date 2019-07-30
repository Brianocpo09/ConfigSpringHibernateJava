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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sistemas
 */
@Entity
@Table(name = "s_usuario")
public class SUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_usu", updatable = false, nullable = false)
    private Integer codigoUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_usu")
    private String nombreUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "usuario_usu", unique = true)
    private String usuarioUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "clave_usu")
    private String claveUsu;
    @Column(name = "estado_usu")
    private Boolean estadoUsu;
    @JoinColumn(name = "codigo_tus", referencedColumnName = "codigo_tus")
    @ManyToOne
    private STipoUsuario codigoTus;

    public SUsuario() {
    }

    public SUsuario(Integer codigoUsu) {
        this.codigoUsu = codigoUsu;
    }

    public SUsuario(Integer codigoUsu, String nombreUsu, String usuarioUsu, String claveUsu) {
        this.codigoUsu = codigoUsu;
        this.nombreUsu = nombreUsu;
        this.usuarioUsu = usuarioUsu;
        this.claveUsu = claveUsu;
    }

    public Integer getCodigoUsu() {
        return codigoUsu;
    }

    public void setCodigoUsu(Integer codigoUsu) {
        this.codigoUsu = codigoUsu;
    }

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    public String getUsuarioUsu() {
        return usuarioUsu;
    }

    public void setUsuarioUsu(String usuarioUsu) {
        this.usuarioUsu = usuarioUsu;
    }

    public String getClaveUsu() {
        return claveUsu;
    }

    public void setClaveUsu(String claveUsu) {
        this.claveUsu = claveUsu;
    }

    public Boolean getEstadoUsu() {
        return estadoUsu;
    }

    public void setEstadoUsu(Boolean estadoUsu) {
        this.estadoUsu = estadoUsu;
    }

    public STipoUsuario getCodigoTus() {
        return codigoTus;
    }

    public void setCodigoTus(STipoUsuario codigoTus) {
        this.codigoTus = codigoTus;
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
        if (!(object instanceof SUsuario)) {
            return false;
        }
        SUsuario other = (SUsuario) object;
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
