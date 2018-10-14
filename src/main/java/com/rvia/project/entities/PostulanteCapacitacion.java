package com.rvia.project.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author clear
 */
@Entity
@Table(name = "POSTULANTE_CAPACITACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PostulanteCapacitacion.findAll", query = "SELECT p FROM PostulanteCapacitacion p")
    , @NamedQuery(name = "PostulanteCapacitacion.findById", query = "SELECT p FROM PostulanteCapacitacion p WHERE p.id = :id")})
public class PostulanteCapacitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "ID_CAPACITACION", referencedColumnName = "ID")
    @ManyToOne
    private Capacitacion idCapacitacion;
    @JoinColumn(name = "ID_POSTULANTE", referencedColumnName = "ID")
    @ManyToOne
    private Postulante idPostulante;

    public PostulanteCapacitacion() {
    }

    public PostulanteCapacitacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Capacitacion getIdCapacitacion() {
        return idCapacitacion;
    }

    public void setIdCapacitacion(Capacitacion idCapacitacion) {
        this.idCapacitacion = idCapacitacion;
    }

    public Postulante getIdPostulante() {
        return idPostulante;
    }

    public void setIdPostulante(Postulante idPostulante) {
        this.idPostulante = idPostulante;
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
        if (!(object instanceof PostulanteCapacitacion)) {
            return false;
        }
        PostulanteCapacitacion other = (PostulanteCapacitacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return " "+idCapacitacion;
    }
    
}
