package com.rvia.project.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author clear
 */
@Entity
@Table(name = "CAPACITACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Capacitacion.findAll", query = "SELECT c FROM Capacitacion c")
    , @NamedQuery(name = "Capacitacion.findById", query = "SELECT c FROM Capacitacion c WHERE c.id = :id")
    , @NamedQuery(name = "Capacitacion.findByDescripcion", query = "SELECT c FROM Capacitacion c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Capacitacion.findByFechaInicio", query = "SELECT c FROM Capacitacion c WHERE c.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Capacitacion.findByFechaFinal", query = "SELECT c FROM Capacitacion c WHERE c.fechaFinal = :fechaFinal")})
public class Capacitacion implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_FINAL")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "ID_INSTITUCION", referencedColumnName = "ID")
    @ManyToOne
    private Institucion idInstitucion;
    @JoinColumn(name = "ID_NIVEL", referencedColumnName = "ID")
    @ManyToOne
    private NivelEducacional idNivel;
    @OneToMany(mappedBy = "idCapacitacion")
    private List<PostulanteCapacitacion> postulanteCapacitacionList;

    public Capacitacion() {
    }

    public Capacitacion(Integer id) {
        this.id = id;
    }

    public Capacitacion(Integer id, String descripcion, Date fechaInicio, Date fechaFinal) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Institucion getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Institucion idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public NivelEducacional getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(NivelEducacional idNivel) {
        this.idNivel = idNivel;
    }

    @XmlTransient
    public List<PostulanteCapacitacion> getPostulanteCapacitacionList() {
        return postulanteCapacitacionList;
    }

    public void setPostulanteCapacitacionList(List<PostulanteCapacitacion> postulanteCapacitacionList) {
        this.postulanteCapacitacionList = postulanteCapacitacionList;
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
        if (!(object instanceof Capacitacion)) {
            return false;
        }
        Capacitacion other = (Capacitacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descripcion;
    } 
}
