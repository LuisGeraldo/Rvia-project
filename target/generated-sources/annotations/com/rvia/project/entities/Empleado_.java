package com.rvia.project.entities;

import com.rvia.project.entities.Departamento;
import com.rvia.project.entities.Estado;
import com.rvia.project.entities.Puesto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-14T13:05:10")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> fechaIngreso;
    public static volatile SingularAttribute<Empleado, Departamento> idDepartamento;
    public static volatile SingularAttribute<Empleado, Estado> idEstado;
    public static volatile SingularAttribute<Empleado, String> cedula;
    public static volatile SingularAttribute<Empleado, String> apellido;
    public static volatile SingularAttribute<Empleado, Long> salario;
    public static volatile SingularAttribute<Empleado, Puesto> idPuesto;
    public static volatile SingularAttribute<Empleado, Integer> id;
    public static volatile SingularAttribute<Empleado, String> nombre;
    public static volatile SingularAttribute<Empleado, String> email;

}