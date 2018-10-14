package com.rvia.project.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author clear
 */
@Entity
@Table(name = "PUESTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puesto.findAll", query = "SELECT p FROM Puesto p")
    , @NamedQuery(name = "Puesto.findById", query = "SELECT p FROM Puesto p WHERE p.id = :id")
    , @NamedQuery(name = "Puesto.findByNombre", query = "SELECT p FROM Puesto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Puesto.findBySalarioMinimo", query = "SELECT p FROM Puesto p WHERE p.salarioMinimo = :salarioMinimo")
    , @NamedQuery(name = "Puesto.findBySalarioMaximo", query = "SELECT p FROM Puesto p WHERE p.salarioMaximo = :salarioMaximo")})
public class Puesto implements Serializable {

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
    @Column(name = "SALARIO_MINIMO")
    private long salarioMinimo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALARIO_MAXIMO")
    private long salarioMaximo;
    @OneToMany(mappedBy = "idPuesto")
    private List<Empleado> empleadoList;
    @OneToMany(mappedBy = "idPuesto")
    private List<Postulante> postulanteList;
    @JoinColumn(name = "ID_NIVEL_RIESGO", referencedColumnName = "ID")
    @ManyToOne
    private NivelRiesgo idNivelRiesgo;
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID")
    @ManyToOne
    private Estado idEstado;

    public Puesto() {
    }

    public Puesto(Integer id) {
        this.id = id;
    }

    public Puesto(Integer id, String nombre, long salarioMinimo, long salarioMaximo) {
        this.id = id;
        this.nombre = nombre;
        this.salarioMinimo = salarioMinimo;
        this.salarioMaximo = salarioMaximo;
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

    public long getSalarioMinimo() {
        return salarioMinimo;
    }

    public void setSalarioMinimo(long salarioMinimo) {
        this.salarioMinimo = salarioMinimo;
    }

    public long getSalarioMaximo() {
        return salarioMaximo;
    }

    public void setSalarioMaximo(long salarioMaximo) {
        this.salarioMaximo = salarioMaximo;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @XmlTransient
    public List<Postulante> getPostulanteList() {
        return postulanteList;
    }

    public void setPostulanteList(List<Postulante> postulanteList) {
        this.postulanteList = postulanteList;
    }

    public NivelRiesgo getIdNivelRiesgo() {
        return idNivelRiesgo;
    }

    public void setIdNivelRiesgo(NivelRiesgo idNivelRiesgo) {
        this.idNivelRiesgo = idNivelRiesgo;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
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
        if (!(object instanceof Puesto)) {
            return false;
        }
        Puesto other = (Puesto) object;
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
