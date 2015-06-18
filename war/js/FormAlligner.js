/**
 * 
 */

$(document).ready(function(){
	$('#main-form').css('margin-top',(($(window).height())/2)-($('#main-form').height()/2)-($('.navbar').height())-20);
	if(((($(window).width())/2)-(($('#main-form').width()*0.4166666666666667)/2)-20)>20)
		$('#main-form').css('margin-left',(($(window).width())/2)-(($('#main-form').width()*0.4166666666666667)/2)-20);
	else
		$('#main-form').css('margin-left',20);		
	window.onresize=function(){
		$('#main-form').css('margin-top',(($(window).height())/2)-($('#main-form').height()/2)-($('.navbar').height())-20);
		if(((($(window).width())/2)-(($('#main-form').width()*0.4166666666666667)/2)-20)>20)
			$('#main-form').css('margin-left',(($(window).width())/2)-(($('#main-form').width()*0.4166666666666667)/2)-20);
		else
			$('#main-form').css('margin-left',20);		};
	
});