package com.rvia.project.entities;

import com.rvia.project.entities.Competencia;
import com.rvia.project.entities.Postulante;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-14T13:05:10")
@StaticMetamodel(PostulanteCompetencia.class)
public class PostulanteCompetencia_ { 

    public static volatile SingularAttribute<PostulanteCompetencia, Postulante> idPostulante;
    public static volatile SingularAttribute<PostulanteCompetencia, Integer> id;
    public static volatile SingularAttribute<PostulanteCompetencia, Competencia> idCompetencia;

}