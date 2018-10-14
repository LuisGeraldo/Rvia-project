package com.rvia.project.entities;

import com.rvia.project.entities.Empleado;
import com.rvia.project.entities.Postulante;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-14T13:05:10")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile SingularAttribute<Departamento, String> descripcion;
    public static volatile ListAttribute<Departamento, Empleado> empleadoList;
    public static volatile ListAttribute<Departamento, Postulante> postulanteList;
    public static volatile SingularAttribute<Departamento, Integer> id;
    public static volatile SingularAttribute<Departamento, String> nombre;

}