window.onscroll = function(){
	if(document.documentElement.scrollTop > 500){
		document.querySelector('.master-container')
		.classList.add('show');
	}else{
		document.querySelector('.master-container')
		.classList.remove('show');
	}
}

document.querySelector('.master-container')
.addEventListener('click', () =>{
	window.scrollTo({
		top: 0,
		behavior: 'smooth'
	});
});