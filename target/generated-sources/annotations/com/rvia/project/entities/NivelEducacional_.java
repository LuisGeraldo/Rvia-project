package com.rvia.project.entities;

import com.rvia.project.entities.Capacitacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-14T13:05:10")
@StaticMetamodel(NivelEducacional.class)
public class NivelEducacional_ { 

    public static volatile SingularAttribute<NivelEducacional, String> descripcion;
    public static volatile SingularAttribute<NivelEducacional, Integer> id;
    public static volatile ListAttribute<NivelEducacional, Capacitacion> capacitacionList;
    public static volatile SingularAttribute<NivelEducacional, String> nombre;

}