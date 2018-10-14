package com.rvia.project.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "NIVEL_RIESGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelRiesgo.findAll", query = "SELECT n FROM NivelRiesgo n")
    , @NamedQuery(name = "NivelRiesgo.findById", query = "SELECT n FROM NivelRiesgo n WHERE n.id = :id")
    , @NamedQuery(name = "NivelRiesgo.findByNombre", query = "SELECT n FROM NivelRiesgo n WHERE n.nombre = :nombre")
    , @NamedQuery(name = "NivelRiesgo.findByDescripcion", query = "SELECT n FROM NivelRiesgo n WHERE n.descripcion = :descripcion")})
public class NivelRiesgo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "idNivelRiesgo")
    private List<Puesto> puestoList;

    public NivelRiesgo() {
    }

    public NivelRiesgo(Integer id) {
        this.id = id;
    }

    public NivelRiesgo(Integer id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Puesto> getPuestoList() {
        return puestoList;
    }

    public void setPuestoList(List<Puesto> puestoList) {
        this.puestoList = puestoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelRiesgo)) {
            return false;
        }
        NivelRiesgo other = (NivelRiesgo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
