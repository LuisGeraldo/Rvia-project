package com.rvia.project.entities;

import com.rvia.project.entities.Competencia;
import com.rvia.project.entities.Empleado;
import com.rvia.project.entities.Idioma;
import com.rvia.project.entities.Puesto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-14T13:05:10")
@StaticMetamodel(Estado.class)
public class Estado_ { 

    public static volatile SingularAttribute<Estado, String> descripcion;
    public static volatile ListAttribute<Estado, Puesto> puestoList;
    public static volatile ListAttribute<Estado, Idioma> idiomaList;
    public static volatile ListAttribute<Estado, Empleado> empleadoList;
    public static volatile ListAttribute<Estado, Competencia> competenciaList;
    public static volatile SingularAttribute<Estado, Integer> id;
    public static volatile SingularAttribute<Estado, String> nombre;

}