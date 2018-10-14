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
@Table(name = "POSTULANTE_IDIOMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PostulanteIdioma.findAll", query = "SELECT p FROM PostulanteIdioma p")
    , @NamedQuery(name = "PostulanteIdioma.findById", query = "SELECT p FROM PostulanteIdioma p WHERE p.id = :id")})
public class PostulanteIdioma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    @JoinColumn(name = "ID_IDIOMA", referencedColumnName = "ID")
    @ManyToOne
    private Idioma idIdioma;
        
    @JoinColumn(name = "ID_POSTULANTE", referencedColumnName = "ID")
    @ManyToOne
    private Postulante idPostulante;

    public PostulanteIdioma() {
    }

    public PostulanteIdioma(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Idioma getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Idioma idIdioma) {
        this.idIdioma = idIdioma;
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
        if (!(object instanceof PostulanteIdioma)) {
            return false;
        }
        PostulanteIdioma other = (PostulanteIdioma) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idIdioma.getNombre();
    }
    
}
