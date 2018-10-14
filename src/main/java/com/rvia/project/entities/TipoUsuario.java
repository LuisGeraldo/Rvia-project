package com.rvia.project.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author clear
 */
@Entity
@Table(name = "TIPO_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoUsuario.findAll", query = "SELECT t FROM TipoUsuario t")
    , @NamedQuery(name = "TipoUsuario.findByIdNombre", query = "SELECT t FROM TipoUsuario t WHERE t.idNombre = :idNombre")
    , @NamedQuery(name = "TipoUsuario.findByDescripcion", query = "SELECT t FROM TipoUsuario t WHERE t.descripcion = :descripcion")})
public class TipoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ID_NOMBRE")
    private String idNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNombre")
    private List<Usuario> usuarioList;

    public TipoUsuario() {
    }

    public TipoUsuario(String idNombre) {
        this.idNombre = idNombre;
    }

    public TipoUsuario(String idNombre, String descripcion) {
        this.idNombre = idNombre;
        this.descripcion = descripcion;
    }

    public String getIdNombre() {
        return idNombre;
    }

    public void setIdNombre(String idNombre) {
        this.idNombre = idNombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNombre != null ? idNombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoUsuario)) {
            return false;
        }
        TipoUsuario other = (TipoUsuario) object;
        if ((this.idNombre == null && other.idNombre != null) || (this.idNombre != null && !this.idNombre.equals(other.idNombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idNombre;
    }
    
}
