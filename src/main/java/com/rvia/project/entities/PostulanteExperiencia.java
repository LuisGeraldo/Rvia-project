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
@Table(name = "POSTULANTE_EXPERIENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PostulanteExperiencia.findAll", query = "SELECT p FROM PostulanteExperiencia p")
    , @NamedQuery(name = "PostulanteExperiencia.findById", query = "SELECT p FROM PostulanteExperiencia p WHERE p.id = :id")})
public class PostulanteExperiencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "ID_EXPERIENCIA", referencedColumnName = "ID")
    @ManyToOne
    private ExperienciaLaboral idExperiencia;
    @JoinColumn(name = "ID_POSTULANTE", referencedColumnName = "ID")
    @ManyToOne
    private Postulante idPostulante;

    public PostulanteExperiencia() {
    }

    public PostulanteExperiencia(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ExperienciaLaboral getIdExperiencia() {
        return idExperiencia;
    }

    public void setIdExperiencia(ExperienciaLaboral idExperiencia) {
        this.idExperiencia = idExperiencia;
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
        if (!(object instanceof PostulanteExperiencia)) {
            return false;
        }
        PostulanteExperiencia other = (PostulanteExperiencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idExperiencia.getDecripcion();
    }
    
}
