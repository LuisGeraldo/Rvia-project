package com.rvia.project.entities;

import com.rvia.project.entities.Institucion;
import com.rvia.project.entities.NivelEducacional;
import com.rvia.project.entities.PostulanteCapacitacion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-14T13:05:10")
@StaticMetamodel(Capacitacion.class)
public class Capacitacion_ { 

    public static volatile SingularAttribute<Capacitacion, String> descripcion;
    public static volatile SingularAttribute<Capacitacion, Institucion> idInstitucion;
    public static volatile SingularAttribute<Capacitacion, Date> fechaInicio;
    public static volatile SingularAttribute<Capacitacion, Date> fechaFinal;
    public static volatile SingularAttribute<Capacitacion, NivelEducacional> idNivel;
    public static volatile SingularAttribute<Capacitacion, Integer> id;
    public static volatile ListAttribute<Capacitacion, PostulanteCapacitacion> postulanteCapacitacionList;

}