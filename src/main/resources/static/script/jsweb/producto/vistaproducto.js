$(document).on("click", "#btnagregarproducto", function(){
	$("#txtnombre").val("");
	$("#txtpreciouni").val("");
	$("#txtdetalle").val("");
	$("#txtimagen").val("");
	$("#txtcodcategoria").val("");
	$("#hddcodproducto").val("0");
	$("#modalproducto").modal("show")
})

$(document).on("click", ".btnactualizarproducto", function(){
	$("#txtnombre").val($(this).attr("data-nombre"));
	$("#txtpreciouni").val($(this).attr("data-preciouni"));
	$("#txtdetalle").val($(this).attr("data-detalle"));
	$("#txtimagen").val($(this).attr("data-imagen"));
	$("#txtcodcategoria").val($(this).attr("data-codcategoria"));
	$("#hddcodproducto").val($(this).attr("data-codproducto"));
	$("#modalproducto").modal("show")
	
})

$(document).on("click", "#btnregistrarproducto", function(){
	if($("#txtnombre").val() === ""){
		$("#errornombre").text("Es obligatorio el nombre del Producto")
	}else{
		$("#errornombre").text("");
	}
	if($("#txtpreciouni").val() === ""){
		$("#errorpreciouni").text("Es obligatorio asignarle un precio al producto")
	}else{
		$("#errorpreciouni").text("");
	}
	if($("#txtdetalle").val() === ""){
		$("#errordetalle").text("Es obligatorio rellenar el campo")
	}else{
		$("#errordetalle").text("");
	}
	if($("#txtcategoria").val() === ""){
		$("#errorcategoria").text("Es obligatorio asignarle una categoria al producto")
	}else{
		$("#errorcategoria").text("");
	}
	if($("#txtnombre").val() !== "" && $("txtcategoria".val() !== "")){
		 if ($("#hddcodproducto").val() === "0") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Producto/registrarProductojs",
				data: JSON.stringify({
					nombre: $("#txtnombre").val(),
					preciouni: $("#txtpreciouni").val(),
					detalle: $("#txtdetalle").val(),
					imagen: $("#txtimagen").val(),
					codcategoria: $("#txtcodcategoria").val(),
				}),
				success: function(resultado) {
					if (resultado.respuesta) {
						alert(resultado.mensaje);
						ListarProductos();
					} else {
						alert(resultado.mensaje);
					}
				}
			});
		} else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Producto/registrarProductojs",
				data: JSON.stringify({
					codproducto: $("#hddcodproducto").val(),
					nombre: $("#txtnombre").val(),
					preciouni: $("#txtpreciouni").val(),
					detalle: $("#txtdetalle").val(),
					imagen: $("#txtimagen").val(),
					codcategoria: $("#txtcodcategoria").val()
				}),
				success: function(resultado) {
					if (resultado.respuesta) {
						alert(resultado.mensaje);
						ListarProductos();
					} else {
						alert(resultado.mensaje);
					}
				}
			});
		}
		$("#modalproducto").modal("hide");
	}
});
function ListarProductos(){
	$.ajax({
		type: "GET",
		url: "/Producto/listarProductojs",
		dataType: "json",
		success:function(resultado){
			$("#tblproducto > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblproducto > tbody").append("<tr>"+
					"<td>" + value.codproducto + "</td>"+
					"<td>" + value.nombre + "</td>"+
					"<td>" + value.preciouni + "</td>"+
					"<td>" + value.detalle + "</td>"+
					"<td>" + value.imagen + "</td>"+
					"<td>" + value.codcategoria + "</td>"+
					"<td><button type='button' class='btn btn-info btnactualizarproducto' "+
					" data-codproducto='"+value.codproducto+"'"+
					" data-nombre='"+value.nombre+"'"+
					" data-preciouni='"+value.preciouni+"'"+
					" data-detalle='"+value.detalle+"'"+
					" data-imagen='"+value.imagen+"'"+
					" data-codcategoria='"+value.codcategoria+"'>Actualizar</button>"+
					"</td>"+
					"<td><button type='button' class='btn btn-danger btneliminarproducto' "+
					" data-codproducto='"+value.codproducto+"'"+
					" data-nombre='"+value.nombre+"'"+
					" data-preciouni='"+value.preciouni+"'"+
					" data-detalle='"+value.detalle+"'"+
					" data-imagen='"+value.imagen+"'"+
					" data-codcategoria='"+value.codcategoria+"'>Eliminar</button>"+
					"</td></tr>")
			})
						
		}
	})
}

$(document).on("click", ".btneliminarproducto", function(){
	$("#mensajeeliminar").text("¿Estas seguro de eliminar el producto " +
		$(this).attr("data-nombre")+"?"); 
	$("#hddcodproductoeliminar").val($(this).attr("data-codproducto")); 
	$("#modaleliminarproducto").modal("show");
})

$(document).on("click", "#btneliminarproducto", function(){
	
})