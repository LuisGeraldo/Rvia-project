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
@Table(name = "EXPERIENCIA_LABORAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExperienciaLaboral.findAll", query = "SELECT e FROM ExperienciaLaboral e")
    , @NamedQuery(name = "ExperienciaLaboral.findById", query = "SELECT e FROM ExperienciaLaboral e WHERE e.id = :id")
    , @NamedQuery(name = "ExperienciaLaboral.findByIdEmpresa", query = "SELECT e FROM ExperienciaLaboral e WHERE e.idEmpresa = :idEmpresa")
    , @NamedQuery(name = "ExperienciaLaboral.findByIdPuesto", query = "SELECT e FROM ExperienciaLaboral e WHERE e.idPuesto = :idPuesto")
    , @NamedQuery(name = "ExperienciaLaboral.findByFechaInicio", query = "SELECT e FROM ExperienciaLaboral e WHERE e.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "ExperienciaLaboral.findByFechaFinal", query = "SELECT e FROM ExperienciaLaboral e WHERE e.fechaFinal = :fechaFinal")
    , @NamedQuery(name = "ExperienciaLaboral.findByDecripcion", query = "SELECT e FROM ExperienciaLaboral e WHERE e.decripcion = :decripcion")
    , @NamedQuery(name = "ExperienciaLaboral.findBySalario", query = "SELECT e FROM ExperienciaLaboral e WHERE e.salario = :salario")})
public class ExperienciaLaboral implements Serializable {

  
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
    
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID")
    @ManyToOne
    private Empresa idEmpresa;
    
    
    @JoinColumn(name = "ID_PUESTO", referencedColumnName = "ID")
    @ManyToOne
    private Puesto idPuesto;
    
    @Size(max = 60)
    @Column(name = "DECRIPCION")
    private String decripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALARIO")
    private long salario;
    @OneToMany(mappedBy = "idExperiencia")
    private List<PostulanteExperiencia> postulanteExperienciaList;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(Integer id) {
        this.id = id;
    }

    public ExperienciaLaboral(Integer id, Date fechaInicio, Date fechaFinal, long salario) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.salario = salario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Puesto getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Puesto idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getDecripcion() {
        return decripcion;
    }

    public void setDecripcion(String decripcion) {
        this.decripcion = decripcion;
    }

    public long getSalario() {
        return salario;
    }

    public void setSalario(long salario) {
        this.salario = salario;
    }

    @XmlTransient
    public List<PostulanteExperiencia> getPostulanteExperienciaList() {
        return postulanteExperienciaList;
    }

    public void setPostulanteExperienciaList(List<PostulanteExperiencia> postulanteExperienciaList) {
        this.postulanteExperienciaList = postulanteExperienciaList;
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
        if (!(object instanceof ExperienciaLaboral)) {
            return false;
        }
        ExperienciaLaboral other = (ExperienciaLaboral) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return decripcion;
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
}
