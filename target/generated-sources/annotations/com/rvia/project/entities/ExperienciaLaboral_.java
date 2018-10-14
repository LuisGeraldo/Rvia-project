package com.rvia.project.entities;

import com.rvia.project.entities.Empresa;
import com.rvia.project.entities.PostulanteExperiencia;
import com.rvia.project.entities.Puesto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-14T13:05:10")
@StaticMetamodel(ExperienciaLaboral.class)
public class ExperienciaLaboral_ { 

    public static volatile ListAttribute<ExperienciaLaboral, PostulanteExperiencia> postulanteExperienciaList;
    public static volatile SingularAttribute<ExperienciaLaboral, Date> fechaInicio;
    public static volatile SingularAttribute<ExperienciaLaboral, Puesto> idPuesto;
    public static volatile SingularAttribute<ExperienciaLaboral, Long> salario;
    public static volatile SingularAttribute<ExperienciaLaboral, Date> fechaFinal;
    public static volatile SingularAttribute<ExperienciaLaboral, Empresa> idEmpresa;
    public static volatile SingularAttribute<ExperienciaLaboral, Integer> id;
    public static volatile SingularAttribute<ExperienciaLaboral, String> decripcion;

}