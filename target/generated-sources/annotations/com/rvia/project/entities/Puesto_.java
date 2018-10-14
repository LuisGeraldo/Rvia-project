package com.rvia.project.entities;

import com.rvia.project.entities.Empleado;
import com.rvia.project.entities.Estado;
import com.rvia.project.entities.NivelRiesgo;
import com.rvia.project.entities.Postulante;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-14T13:05:10")
@StaticMetamodel(Puesto.class)
public class Puesto_ { 

    public static volatile SingularAttribute<Puesto, Estado> idEstado;
    public static volatile SingularAttribute<Puesto, NivelRiesgo> idNivelRiesgo;
    public static volatile ListAttribute<Puesto, Empleado> empleadoList;
    public static volatile ListAttribute<Puesto, Postulante> postulanteList;
    public static volatile SingularAttribute<Puesto, Integer> id;
    public static volatile SingularAttribute<Puesto, Long> salarioMaximo;
    public static volatile SingularAttribute<Puesto, String> nombre;
    public static volatile SingularAttribute<Puesto, Long> salarioMinimo;

}