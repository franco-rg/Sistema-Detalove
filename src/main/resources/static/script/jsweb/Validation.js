function validar_registroproducto() {

	var nombre = document.getElementById('nombre').value;
	var preciouni = document.getElementById('preciouni').value;
	var detalle = document.getElementById('detalle').value;
	var tamano = document.getElementById('tamano').value;
	var publico = document.getElementById('publico').value;
	var categoria = document.getElementById('categoria').value;
	

	if (nombre === "" || preciouni === "" || detalle === "" || tamano === "" || publico === "" ||  categoria === "") {

		if (nombre === "" ) {

			$("#errornombre").text("El campo nombre del producto es requerido.");
		}
		else {
			$("#errornombre").text("");
		}

		if (preciouni === "") {

			$("#errorpreciouni").text("El campo precio unitario es requerido.");
		}
		else {
			$("#errorpreciouni").text("");
		}
		
		if (detalle === "") {

			$("#errordetalle").text("El campo detalle es requerido.");
		}
		else {
			$("#errordetalle").text("");
		}

		if (tamano === "") {

			$("#errortamano").text("El campo tamaño del producto es requerido.");
		}
		else {
			$("#errortamano").text("");
		}
		
		if (publico === "") {

			$("#errorpublico").text("Debe Seleccionar el publico a quien va dirigido.");
		}
		else {
			$("#errorpublico").text("");
		}
		
		if (categoria === "") {

			$("#errorcategoria").text("Debe seleccionar la categoria, la cual pertenece el producto.");
		}
		else {
			$("#errorcategoria").text("");
		}
		return false;
	}
}


function validar_registro_entrada(){
	
	var descripcion = document.getElementById('descripcion').value;
	var fechaingreso = document.getElementById('fechaingreso').value;
	var proveedor = document.getElementById('proveedor').value;
	var facturacompra = document.getElementById('facturacompra').value;
	var usuario = document.getElementById('usuario').value;
	var producto = document.getElementById('producto').value;
	var unidades = document.getElementById('unidades').value;

	if (descripcion === "" || fechaingreso === "" || proveedor === "" || facturacompra === "" || usuario === "" ||  producto === "" ||  unidades === "") {

		if (descripcion === "" ) {

			$("#infodescripcion").text("El campo descripcion permite conocer la descripcion de esta guia o inconvenientes que hubo.");
		}
		else {
			$("#infodescripcion").text("");
		}

		if (fechaingreso === "") {

			$("#errorfechaingreso").text("El campo fecha de ingreso es requerido.");
		}
		else {
			$("#errorfechaingreso").text("");
		}
		
		if (proveedor === "") {

			$("#errorproveedor").text("Debe seleccionar al proveedor el cual ha abastecido esta guia.");
		}
		else {
			$("#errorproveedor").text("");
		}
		
		if (facturacompra === "") {

			$("#errorfactura").text("Debe seleccionar la factura correspondiente.");
		}
		else {
			$("#errorfactura").text("");
		}

		if (usuario === "") {

			$("#errorusuario").text("Debe seleccionar el usuario actual.");
		}
		else {
			$("#errorusuario").text("");
		}
		
		if (producto === "") {

			$("#errorproducto").text("Debe seleccionar el producto el cual esta ingresando.");
		}
		else {
			$("#errorproducto").text("");
		}
		
		if (unidades === "") {

			$("#errorunidades").text("Debe ingresar la cantidad de unidades del producto entrante.");
		}
		else {
			$("#errorunidades").text("");
		}
		
		return false;
	}
	
	
}






























