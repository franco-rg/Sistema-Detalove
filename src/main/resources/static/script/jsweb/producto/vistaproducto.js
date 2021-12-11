/*$(document).on("click", "#btnagregarproducto", function() {
	$("#txtnombre").val("");
	$("#txtpreciouni").val("");
	$("#txtdetalle").val("");
	$("#cbocategoria").val("0");
	$("#txtimagen").val("");
	$("#hddcodproducto").val("0");
	$("#modalproducto").modal("show");
});*/

$(document).on("click", ".btnactualizarproducto", function() {
	$("#txtimagen").val($(this).attr("data-imagen"));
	$("#txtnombre").val($(this).attr("data-nombre"));
	$("#txtpreciouni").val($(this).attr("data-preciouni"));
	$("#txtdetalle").val($(this).attr("data-detalle"));
	$("#txttamano").val($(this).attr("data-tamano"));
	$("#txtpublico").val($(this).attr("data-publico"));
	$("#cbocategoria").val($(this).attr("data-codcategoria"));
	$("#hddcodproducto").val($(this).attr("data-codproducto"));
	$("#modalproducto").modal("show");
});

//$(document).on("click", "#btnregistrarproducto", function() {
//	if ($("#txtnombre").val() === "") {
//		$("#errornombre").text("Es obligatorio el nombre del producto.");
//	} else {
//		$("#errornombre").text("");
//	}
//	if ($("#txtpreciouni").val() === "") {
//		$("#errorpreciouni").text("Es obligatorio el precio unitario.");
//	} else {
//		$("#errorpreciouni").text("");
//	}
//	if ($("#txtdetalle").val() === "") {
//		$("#errordetalle").text("Es obligatorio el detalle del producto.");
//	} else {
//		$("#errordetalle").text("");
//	}
//	if ($("#txttamano").val() === "") {
//		$("#errortamano").text("Es obligatorio el tamaño del producto.");
//	} else {
//		$("#errortamano").text("");
//	}
//	if ($("#txtpublico").val() === "") {
//		$("#errorpublico").text("Es obligatorio asignarle el publico del producto.");
//	} else {
//		$("#errorpublico").text("");
//	}
//	if ($("#cbocategoria").val() === "") {
//		$("#errorcodcategoria").text("Es obligatorio la categoria del producto.");
//	} else {
//		$("#errorcodcategoria").text("");
//	}
//	if ($("#txtnombre").val() !== "" && $("#txtpreciouni").val() !== "" && $("#txtdetalle").val() !== "" && $("#txttamano").val() !== "" && $("#txtpublico").val() !== "" && $("#cbocategoria").val() !== "") {
//		if ($("#hddcodproducto").val() === "") {
//			$.ajax({
//				type: "POST",
//				contentType: "application/json",
//				url: "/Producto/registrarProductojs",
//				data: JSON.stringify({
//					nombre: $("#txtnombre").val(),
//					preciouni: $("#txtpreciouni").val(),
//					detalle: $("#txtdetalle").val(),
//					imagen: $("#txtimagen").val(),
//					tamano: $("#txttamano").val(),
//					publico: $("#txtpublico").val(),
//					codcategoria: $("#cbocategoria").val()
//				}),
//				success: function(resultado) {
//					var estilo = "danger";
//					if (resultado.respuesta) {
//						estilo = "success";
//						ListarProducto();
//					}
//					mostrarMensaje(resultado.mensaje, estilo);
//				}
//			});
//		} else {
//			$.ajax({
//				type: "POST",
//				contentType: "application/json",
//				url: "/Producto/registrarProductojs",
//				data: JSON.stringify({
//					CodProducto: $("#hddcodproducto").val(),
//					nombre: $("#txtnombre").val(),
//					preciouni: $("#txtpreciouni").val(),
//					detalle: $("#txtdetalle").val(),
//					imagen: $("#txtimagen").val(),
//					tamano: $("#txttamano").val(),
//					publico: $("#txtpublico").val(),
//					codcategoria: $("#cbocategoria").val()
//				}),
//				success: function(resultado) {
//					var estilo = "danger";
//					if (resultado.respuesta) {
//						estilo = "success";
//						ListarProducto();
//					}
//					mostrarMensaje(resultado.mensaje, estilo);
//				}
//			});
//		}
//		$("#modalproducto").modal("hide");
//	}
//});

$(document).on("change", "#cbocategoria", function(){
	var codcategoria = $("cbocategoria").val();
	if(codcategoria === "0"){
		$("#tblproducto").val();
	}else{
		$.ajax({
			type: "GET",
			url: "Producto/listarProductosxCategoria",
			data: {
				catcod: codcategoria
			},
			success: function(resultado){
				console.log(resultado)
			}
		})
	}
});


$(document).on("click", ".btninformacion", function() {
	$("#txtcodproducto").text($(this).attr("data-codproducto"));
	$("#txtimagen").val($(this).attr("data-imagen"));
	$("#txtnombre").val($(this).attr("data-nombre"));
	$("#txtpreciouni").val($(this).attr("data-preciouni"));
	$("#txtdetalle").val($(this).attr("data-detalle"));
	$("#txtdescripcion").val($(this).attr("data-descripcion"));
	$("#txttamano").val($(this).attr("data-tamano"));
	$("#txtpublico").val($(this).attr("data-publico"));
	$("#cbocategoria").val($(this).attr("data-codcategoria"));
	$("#hddcodproducto").val($(this).attr("data-codproducto"));
	$("#modalinfoproducto").modal("show");
});


$(document).on("click", ".btneliminarproducto", function() {
	$("#mensajeeliminar").text("¿Está seguro de eliminar el producto: " +
		$(this).attr("data-nombre") + "?");
	$("#hddcodproductoeliminar").val($(this).attr("data-codproducto"));
	$("#modaleliminarproducto").modal("show");
});

$(document).on("click", "#btneliminarproducto", function() {
	$.ajax({
		type: "DELETE",
		contentType: "application/json",
		url: "/Producto/inhabilitarProductojs",
		data: JSON.stringify({
			codproducto: $("#hddcodproductoeliminar").val()
		}),
		success: function(resultado) {
			var estilo = "danger";
			if (resultado.respuesta) {
				estilo = "success";
				// ListarProducto();
				location.reload(true);
			}
			mostrarMensaje(resultado.mensaje, estilo);
			$("#modaleliminarproducto").modal("hide");
		}
	});
});


function ListarProducto() {
	$.ajax({
		type: "GET",
		url: "/Producto/listarProductojs",
		dataType: "json",
		success: function(resultado) {
			$("#tblproducto > tbody").html("");
			$.each(resultado, function(index, value) {
				$("#tblproducto > tbody").append("<tr>" +
					"<td>" + "<img th:src='@{'/imagen-detalove/'+${value.imagen}}' height='100' width='100'/>" + "</td>" +
					"<td>" + value.codproducto + "</td>" +
					"<td>" + value.codcategoria + "</td>" +
					"<td>" + value.nombre + "</td>" +
					"<td class='preciocss'>" + value.preciouni + "</td>" +
					"<td>" + value.detalle + "</td>" +
					"<td>" + value.tamano + "</td>" +
					"<td>" + value.publico + "</td>" +
					"<td class='estadocss'>" + value.estado + "</td>" +
					"<td><button type='button' class='btn btn-info btninformacion' " +
					"><i class='fas fa-eye'></i></button>" +
					"</td>" +
					"<td><button type='button' class='btn btn-secondary btnactualizarproducto' " +
					" data-imagen='"+value.imagen+"'" +
					" data-codproducto='"+value.codproducto+"'" +
					" data-codcategoria='"+value.codcategoria+"'" +
					" data-nombre='"+value.nombre+"'" +
					" data-preciouni='"+value.preciouni+"'" +
					" data-detalle='"+value.detalle+"'" +
					" data-tamano='"+value.tamano+"'" +
					" data-publico='"+value.publico+"'" +
					" data-estado='"+value.estado+"'><i class='fas fa-edit'></i></button>" +
					"</td>" +
					"<td><button type='button' class='btn btn-danger btneliminarproducto' " +
					" data-codproducto='" + value.codproducto + "'" +
					" data-nombre='" + value.nombre + "'><i class='fas fa-trash-alt'></i></button>" +
					"</td></tr>")
			})
		}
	})
}
