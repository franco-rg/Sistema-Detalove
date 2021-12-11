

$(document).on("click", ".btneliminarinventario", function() {
	$("#mensajeeliminar").text("¿Está seguro de inhabilitar el Inventario Nº " +
		$(this).attr("data-codinventario") + "?");
	$("#hddcodguiaentradaeliminar").val($(this).attr("data-codinventario"));
	$("#modaleliminarguiaentrada").modal("show");
});

$(document).on("click", "#btneliminarguiaentrada", function() {
	$.ajax({
		type: "DELETE",
		contentType: "application/json",
		url: "/Inventario/inhabilitarInventariojs",
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