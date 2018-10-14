package com.rvia.project.entities;

import com.rvia.project.entities.Estado;
import com.rvia.project.entities.PostulanteIdioma;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-14T13:05:10")
@StaticMetamodel(Idioma.class)
public class Idioma_ { 

    public static volatile SingularAttribute<Idioma, Estado> idEstado;
    public static volatile ListAttribute<Idioma, PostulanteIdioma> postulanteIdiomaList;
    public static volatile SingularAttribute<Idioma, Integer> id;
    public static volatile SingularAttribute<Idioma, String> nombre;

}