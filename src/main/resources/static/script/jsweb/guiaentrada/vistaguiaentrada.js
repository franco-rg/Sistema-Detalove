/*$(document).on("click", "#btnagregarguiaentrada", function() {
	$("#txtdescripcion").val("");
	$("#fechadate").val("");
	$("#cboproveedor").val("0");
	$("#cbofacturacompra").val("0");
	$("#cbousuario").val("0");
	$("#hddcodguiaentrada").val("");
	$("#modalguiaentrada").modal("show");
});*/

$(document).on("click", ".btnactualizarguiaentrada", function() {
	$("#txtdescripcion").val($(this).attr("data-descripcion"));
	$("#fechadate").val($(this).attr("data-fechaentrada"));
	$("#cboproveedor").val($(this).attr("data-codproveedor"));
	$("#cbofacturacompra").val($(this).attr("data-codfacturacompra"));
	$("#cbousuario").val($(this).attr("data-codusuario"));
	$("#hddcodguiaentrada").val($(this).attr("data-codguiaentrada"));
	$("#modalguiaentrada").modal("show");
});

$(document).on("click", "#btnregistrarguiaentrada", function() {
	if ($("#txtdescripcion").val() === "") {
		$("#errordescripcion").text("Es obligatorio especificar la descripcion de la Guia.");
	} else {
		$("#errordescripcion").text("");
	}
	if ($("#cboproveedor").val() === "") {
		$("#errorproveedor").text("Es obligatorio asignar el Proveedor.");
	} else {
		$("#errorproveedor").text("");
	}
	if ($("#txtdescripcion").val() !== "" && $("#cboproveedor").val() !== "" && $("#cbofacturacompra").val() !== "") {
		if ($("#hddcodguiaentrada").val() === "") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/GuiaEntrada/registrarGuiaEntradajs",
				data: JSON.stringify({
					descripcion: $("#txtdescripcion").val(),
					fechaentrada: $("fechadate").val(),
					codproveedor: $("cboproveedor").val(),
					codfacturacompra: $("cbofacturacompra").val(),
					codusuario: $("cbousuario").val()
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarGuiaEntrada();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		} else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/GuiaEntrada/registrarGuiaEntradajs",
				data: JSON.stringify({
					codguiaentrada: $("#hddcodguiaentrada").val(),
					descripcion: $("#txtdescripcion").val(),
					fechaentrada: $("fechadate").val(),
					codproveedor: $("cboproveedor").val(),
					codfacturacompra: $("cbofacturacompra").val(),
					codusuario: $("cbousuario").val()
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarGuiaEntrada();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		}
		$("#modalguiaentrada").modal("hide");
	}
});

$(document).on("click", ".btneliminarguiaentrada", function() {
	$("#mensajeeliminar").text("¿Está seguro de inhabilitar la Guia de entrada " +
		$(this).attr("data-codguiaentrada") + "?" + ' Si haces esto, la Guia seleccionada no tendra ningun tipo de validez y sera considerada nula.');
	$("#hddcodguiaentradaeliminar").val($(this).attr("data-codguiaentrada"));
	$("#modaleliminarguiaentrada").modal("show");
});

$(document).on("click", "#btneliminarguiaentrada", function() {
	$.ajax({
		type: "DELETE",
		contentType: "application/json",
		url: "/GuiaEntrada/inhabilitarGuiaEntradajs",
		data: JSON.stringify({
			codguiaentrada: $("#hddcodguiaentradaeliminar").val()
		}),
		success: function(resultado) {
			var estilo = "danger";
			if (resultado.respuesta) {
				estilo = "success";
				location.reload(true);
			}
			mostrarMensaje(resultado.mensaje, estilo);
			$("#modaleliminarguiaentrada").modal("hide");
		}
	});
});


function ListarGuiaEntrada() {
	$.ajax({
		type: "GET",
		url: "/GuiaEntrada/listarGuiaEntradajs",
		dataType: "json",
		success: function(resultado) {
			$("#tblguiaentrada > tbody").html("");
			$.each(resultado, function(index, value) {
				$("#tblguiaentrada > tbody").append("<tr>" +
					"<td>" + value.codguiaentrada + "</td>" +
					"<td>" + value.descripcion + "</td>" +
					"<td>" + value.fechaentrada + "</td>" +
					"<td>" + value.codproveedor + "</td>" +
					"<td>" + value.codfacturacompra + "</td>" +
					"<td>" + value.codusuario + "</td>" +
					"<td><button type='button' class='btn btn-secondary btnactualizarguiaentrada' " +
					" data-codguiaentrada='"+value.codguiaentrada+"'" +
					" data-descripcion='"+value.descripcion+"'" +
					" data-fechaentrada='"+value.fechaentrada+"'" +
					" data-codproveedor='"+value.codproveedor+"'" +
					" data-codfacturacompra='"+value.codfacturacompra+"'" +
					" data-codusuario='"+value.codusuario+"'><i class='fas fa-edit'></i></button>" +
					"</td>" +
					"<td><button type='button' class='btn btn-danger btneliminarguiaentrada' " +
					" data-codguiaentrada='"+value.codguiaentrada+"'" +
					" data-descripcion='" + value.descripcion + "'><i class='far fa-times-circle'></i></button>" +
					"</td></tr>")
			})
		}
	})
}