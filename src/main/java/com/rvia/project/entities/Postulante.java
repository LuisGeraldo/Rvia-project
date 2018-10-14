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
@Table(name = "POSTULANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Postulante.findAll", query = "SELECT p FROM Postulante p")
    , @NamedQuery(name = "Postulante.findById", query = "SELECT p FROM Postulante p WHERE p.id = :id")
    , @NamedQuery(name = "Postulante.findByNombre", query = "SELECT p FROM Postulante p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Postulante.findByApellido", query = "SELECT p FROM Postulante p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Postulante.findByCedula", query = "SELECT p FROM Postulante p WHERE p.cedula = :cedula")
    , @NamedQuery(name = "Postulante.findByEmail", query = "SELECT p FROM Postulante p WHERE p.email = :email")
    , @NamedQuery(name = "Postulante.findByTelefono", query = "SELECT p FROM Postulante p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Postulante.findByDireccion", query = "SELECT p FROM Postulante p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "Postulante.findBySalarioDeseado", query = "SELECT p FROM Postulante p WHERE p.salarioDeseado = :salarioDeseado")
    , @NamedQuery(name = "Postulante.findByRecomendacion", query = "SELECT p FROM Postulante p WHERE p.recomendacion = :recomendacion")})
public class Postulante implements Serializable {

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
    @Size(min = 1, max = 30)
    @Column(name = "APELLIDO")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CEDULA")
    private String cedula;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SALARIO_DESEADO")
    private String salarioDeseado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "RECOMENDACION")
    private String recomendacion;
    @OneToMany(mappedBy = "idPostulante")
    private List<PostulanteCapacitacion> postulanteCapacitacionList;
    @OneToMany(mappedBy = "idPostulante")
    private List<PostulanteIdioma> postulanteIdiomaList;
    @JoinColumn(name = "ID_DEPARTAMENTO", referencedColumnName = "ID")
    @ManyToOne
    private Departamento idDepartamento;
    @JoinColumn(name = "ID_PUESTO", referencedColumnName = "ID")
    @ManyToOne
    private Puesto idPuesto;
    @OneToMany(mappedBy = "idPostulante")
    private List<PostulanteExperiencia> postulanteExperienciaList;
    @OneToMany(mappedBy = "idPostulante")
    private List<PostulanteCompetencia> postulanteCompetenciaList;

    public Postulante() {
    }

    public Postulante(Integer id) {
        this.id = id;
    }

    public Postulante(Integer id, String nombre, String apellido, String cedula, String email, String telefono, String direccion, String salarioDeseado, String recomendacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.salarioDeseado = salarioDeseado;
        this.recomendacion = recomendacion;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSalarioDeseado() {
        return salarioDeseado;
    }

    public void setSalarioDeseado(String salarioDeseado) {
        this.salarioDeseado = salarioDeseado;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    @XmlTransient
    public List<PostulanteCapacitacion> getPostulanteCapacitacionList() {
        return postulanteCapacitacionList;
    }

    public void setPostulanteCapacitacionList(List<PostulanteCapacitacion> postulanteCapacitacionList) {
        this.postulanteCapacitacionList = postulanteCapacitacionList;
    }

    @XmlTransient
    public List<PostulanteIdioma> getPostulanteIdiomaList() {
        return postulanteIdiomaList;
    }

    public void setPostulanteIdiomaList(List<PostulanteIdioma> postulanteIdiomaList) {
        this.postulanteIdiomaList = postulanteIdiomaList;
    }

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Puesto getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Puesto idPuesto) {
        this.idPuesto = idPuesto;
    }

    @XmlTransient
    public List<PostulanteExperiencia> getPostulanteExperienciaList() {
        return postulanteExperienciaList;
    }

    public void setPostulanteExperienciaList(List<PostulanteExperiencia> postulanteExperienciaList) {
        this.postulanteExperienciaList = postulanteExperienciaList;
    }

    @XmlTransient
    public List<PostulanteCompetencia> getPostulanteCompetenciaList() {
        return postulanteCompetenciaList;
    }

    public void setPostulanteCompetenciaList(List<PostulanteCompetencia> postulanteCompetenciaList) {
        this.postulanteCompetenciaList = postulanteCompetenciaList;
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
        if (!(object instanceof Postulante)) {
            return false;
        }
        Postulante other = (Postulante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre +" "+apellido;
    }
    
}
