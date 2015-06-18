/**
 * 
 */


$(document).ready(function(){
	var brAdded=false;
	$('#my-button').on('click',function(){
		if(!brAdded)
		{
			$('#add-br').append('<br><br><br>');
			brAdded=true;
		}
	});
	
	window.onresize=function(){
		var window_width=$(window).width();
		if(window_width>750)
		{
			$('#add-br').empty();
			brAdded=false;
		}
	};
	
	$('.btn-danger').on('click',function(){
		alert("You are logged out");
	});
	
	$('#cntct').on('click',function(){
		$(this).addClass('active');
	});
	
	
	
});