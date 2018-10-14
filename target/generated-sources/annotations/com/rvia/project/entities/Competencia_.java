package com.rvia.project.entities;

import com.rvia.project.entities.Estado;
import com.rvia.project.entities.PostulanteCompetencia;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-14T13:05:10")
@StaticMetamodel(Competencia.class)
public class Competencia_ { 

    public static volatile SingularAttribute<Competencia, String> descripcion;
    public static volatile SingularAttribute<Competencia, Estado> idEstado;
    public static volatile ListAttribute<Competencia, PostulanteCompetencia> postulanteCompetenciaList;
    public static volatile SingularAttribute<Competencia, Integer> id;
    public static volatile SingularAttribute<Competencia, String> nombre;

}