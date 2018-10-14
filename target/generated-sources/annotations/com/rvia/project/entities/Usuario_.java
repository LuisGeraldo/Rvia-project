package com.rvia.project.entities;

import com.rvia.project.entities.TipoUsuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-14T13:05:10")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> pass;
    public static volatile SingularAttribute<Usuario, TipoUsuario> idNombre;
    public static volatile SingularAttribute<Usuario, Integer> id;
    public static volatile SingularAttribute<Usuario, String> email;

}