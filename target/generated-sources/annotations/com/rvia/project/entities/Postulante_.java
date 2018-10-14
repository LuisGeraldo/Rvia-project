package com.rvia.project.entities;

import com.rvia.project.entities.Departamento;
import com.rvia.project.entities.PostulanteCapacitacion;
import com.rvia.project.entities.PostulanteCompetencia;
import com.rvia.project.entities.PostulanteExperiencia;
import com.rvia.project.entities.PostulanteIdioma;
import com.rvia.project.entities.Puesto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-14T13:05:10")
@StaticMetamodel(Postulante.class)
public class Postulante_ { 

    public static volatile SingularAttribute<Postulante, String> cedula;
    public static volatile SingularAttribute<Postulante, Puesto> idPuesto;
    public static volatile SingularAttribute<Postulante, String> direccion;
    public static volatile SingularAttribute<Postulante, String> salarioDeseado;
    public static volatile ListAttribute<Postulante, PostulanteCapacitacion> postulanteCapacitacionList;
    public static volatile SingularAttribute<Postulante, String> nombre;
    public static volatile SingularAttribute<Postulante, String> recomendacion;
    public static volatile SingularAttribute<Postulante, Departamento> idDepartamento;
    public static volatile ListAttribute<Postulante, PostulanteExperiencia> postulanteExperienciaList;
    public static volatile ListAttribute<Postulante, PostulanteCompetencia> postulanteCompetenciaList;
    public static volatile SingularAttribute<Postulante, String> apellido;
    public static volatile ListAttribute<Postulante, PostulanteIdioma> postulanteIdiomaList;
    public static volatile SingularAttribute<Postulante, Integer> id;
    public static volatile SingularAttribute<Postulante, String> telefono;
    public static volatile SingularAttribute<Postulante, String> email;

}