package com.rvia.project.entities;

import com.rvia.project.entities.Puesto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-14T13:05:10")
@StaticMetamodel(NivelRiesgo.class)
public class NivelRiesgo_ { 

    public static volatile SingularAttribute<NivelRiesgo, String> descripcion;
    public static volatile ListAttribute<NivelRiesgo, Puesto> puestoList;
    public static volatile SingularAttribute<NivelRiesgo, Integer> id;
    public static volatile SingularAttribute<NivelRiesgo, String> nombre;

}