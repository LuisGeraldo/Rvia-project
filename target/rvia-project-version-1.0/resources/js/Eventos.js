/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




$(document).ready(function(){	
	$(window).scroll(function(){
		if( $(this).scrollTop() > 100 ){
			$('header').css({'transition': '0.5s','background': 'white', 'color': 'black'});
			$('nav').css({'background': 'white'});
			$('header a').css({'color': 'black', 'border-color': 'black'});
			$('#Logo').attr('src', 'resources/Imagenes/Logo B.png');
			$('#Menu').attr('src', 'resources/Imagenes/Menuq.png');
			$('#Menu').hover({'background': 'rgba(0, 0, 0, 0.5)'});
			
		} else {
			$('header').css({'background': '#357DEA', 'color': 'white'});
			$('header a').css({'color': 'white', 'border-color': 'white'});
			$('nav').css({'background': '#357DEA'});
			$('#Logo').attr('src', 'resources/Imagenes/Logo.png');
			$('#Menu').attr('src', 'resources/Imagenes/Menu B.png');
		}
		
	});	
});



