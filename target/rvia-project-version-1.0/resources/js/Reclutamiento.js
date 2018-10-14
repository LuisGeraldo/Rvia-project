/**
 * 
 */

$(document).ready(function(){
	$('#Siguiente').click(function(){ 
		var Nombre = $('.Nombre').val();
		var Apellido = $('.Apellido').val();
		var Cedula = $('.Cedula').val();
		var Telefono = $('.Telefono').val();
		var Direccion = $('.Direccion').val();
		var Email = $('.Email').val();
		
                     
		if(Nombre === ''){
			$('#ENombre').text('Campo requerido');
		}else if(Apellido === ''){
			$('#ENombre').text('');
			$('#EApellido').text('Campo requerido');
                        
		}else if (Cedula.length === 11){
			if(Telefono.length === 10){
				if(Direccion !== ""){
                                    if(Email!== ""){
                                        $('#PuestoAspirado').css({ 'display': 'block'});
					$('#DatosPersonales').css({ 'display': 'none'}); 
                                        
                                        $('#ENombre').text('');
                                        $('#EApellido').text('');
                                        $('#ETelefono').text('');
					$('#ECedula').text('');
					$('#EDireccion').text('');
                                        $('#EEmail').text('');      
                                        
                                    }else{
                                        $('#EDireccion').text('');
                                        $('#ETelefono').text('');
					$('#ECedula').text('');
					$('#EEmail').text('Campo requerido');   
                                    }		
				}else{
                                        $('#ETelefono').text('');
					$('#ECedula').text('');
					$('#EDireccion').text('Campo requerido');
				}					
			}else{
                                $('#EDireccion').text('');
                                $('#ETelefono').text('');
				$('#ECedula').text('');
				$('#ETelefono').text('Telefono invalido');	
			}
		}else{
                        $('#EDireccion').text('');
			$('#ENombre').text('');
			$('#EApellido').text('');
			$('#ECedula').text('Cedula invalida');
		}		
		
	});
	      
	$('#Atras').click(function(){ 
		$('#PuestoAspirado').css({ 'display': 'none'});
		$('#DatosPersonales').css({ 'display': 'block'});
	});
	
	$('#SiguientePuesto').click(function(){
		var Salario = $('.Salario').val();
		if(Salario >= 10000){
                    $('#Competencia').css({ 'display': 'block'});
                    $('#PuestoAspirado').css({ 'display': 'none'});
		}else{
			$('#ESalario').text('El salario minimo es de 10000, use solo numeros');
		}
	});
	
	$('#AtrasPuesto').click(function(){
		$('#DatosPersonales').css({ 'display': 'block'});
		$('#PuestoAspirado').css({ 'display': 'none'});
	});
	
	$('#SiguienteComp').click(function(){
		$('#Competencia').css({ 'display': 'none' });
		$('#Capacitaciones').css({ 'display': 'block' });
	});
	
	$('#AtrasComp').click(function(){
		$('#Competencia').css({ 'display': 'none' });
		$('#PuestoAspirado').css({ 'display': 'block' });
	});
	
	$('#SiguienteCap').click(function(){
                var Inicio = PF('fechaInicioCapacitacion').getDate();  
                var Final = PF('fechaFinalCapacitacion').getDate();
            
                var FechaInicio = $.datepicker.formatDate('yy-mm-dd', Inicio);
                var FechaFinal = $.datepicker.formatDate('yy-mm-dd', Final);
            
            
		
		 var Institucion = $('#Institucion').val();
		 if(FechaInicio < FechaFinal){
			 if(Institucion !== ""){
				 $('#ExperienciaLaboral').css({ 'display': 'block' });
				 $('#Capacitaciones').css({ 'display': 'none' });  
                                 $('#EFecha').text('');  
			 }else{
				 $('#EFecha').text('');
				 $('#EInstitucion').text('Campo requerido'); 
			 }
		 }else{
			 $('#EFecha').text('La fecha de finalizacion es inferior a la de inicio');
		 }	
	});
	
	$('#AtrasCap').click(function(){
		$('#Competencia').css({ 'display': 'block' });
		$('#Capacitaciones').css({ 'display': 'none' });
	});
	
	$('#SiguienteEx').click(function(){
                var Inicio = PF('fechaInicioLaboral').getDate();  
                var Final = PF('fechaFinalLaboral').getDate();
                
                var FechaInicio = $.datepicker.formatDate('yy-mm-dd', Inicio);
                var FechaFinal = $.datepicker.formatDate('yy-mm-dd', Final);

                 var Salario = $('.SalarioL').val();
         
                 if(FechaInicio === ''){
                     $('#EFechaInicio').text('Campo requerido');
                 }else if(FechaFinal === ''){
                     $('#EFechaFinal').text('Campo requerido');
                     $('#EFechaInicio').text('');
                 }else if(FechaInicio < FechaFinal){
			 if(Salario > 0){
				$('#ExperienciaLaboral').css({ 'display': 'none' });
				$('#Autenticacion').css({ 'display': 'block' });  
                                $('#EFechaFinal').text('');
                                $('#EFechaInicio').text('');
                                $('#ESalarioE').text('');
			 }else{
				 $('#EFechaE').text('');
				 $('#ESalarioE').text('Salario invalido');            
			 }
		 }else{
			 $('#EFechaFinal').text('La fecha de finalizacion es inferior a la de inicio');
		 }		
	});
	
	$('#AtrasEx').click(function(){
		$('#ExperienciaLaboral').css({ 'display': 'none' });
		$('#Capacitaciones').css({ 'display': 'block' });	
	});
	
	$('#AtrasAuto').click(function(){
		$('#Autenticacion').css({ 'display': 'none' });
		$('#ExperienciaLaboral').css({ 'display': 'block' });	
	});
	

//        $(window).scroll(function(){
//		if( $(this).scrollTop() > 100 ){
//			$('header').css({'transition': '0.5s','background': 'white', 'color': 'black'});
//			$('nav').css({'background': 'white'});
//			$('header a').css({'color': 'black', 'border-color': 'black'});
//			$('#Logo').attr('src', '../../Imagenes/Logo B.png');
//			$('#Menu').attr('src', '../../Imagenes/Menuq.png');
//			$('#Menu').hover({'background': 'rgba(0, 0, 0, 0.5)'});
//			
//		} else {
//			$('header').css({'background': '#357DEA', 'color': 'white'});
//			$('header a').css({'color': 'white', 'border-color': 'white'});
//			$('nav').css({'background': '#357DEA'});
//			$('#Logo').attr('src', '../../Imagenes/Logo.png');
//			$('#Menu').attr('src', '../../Imagenes/Menu B.png');
//		}
//		});	
    
});
