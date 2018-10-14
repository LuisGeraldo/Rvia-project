package com.rvia.project.entities;

import com.rvia.project.entities.Capacitacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-14T13:05:10")
@StaticMetamodel(Institucion.class)
public class Institucion_ { 

    public static volatile SingularAttribute<Institucion, String> descripcion;
    public static volatile SingularAttribute<Institucion, Integer> id;
    public static volatile ListAttribute<Institucion, Capacitacion> capacitacionList;
    public static volatile SingularAttribute<Institucion, String> nombre;

}