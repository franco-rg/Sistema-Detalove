$(document).on("click", "#btnagregarcategoria", function() {
	$("#txtnombre").val("");
	$("#txtdescripcion").val("");
	$("#hddcodcategoria").val("");
	$("#modalcategoria").modal("show");
});

$(document).on("click", ".btnactualizarcategoria", function() {
	$("#txtnombre").val($(this).attr("data-nombre"));
	$("#txtdescripcion").val($(this).attr("data-descripcion"));
	$("#hddcodcategoria").val($(this).attr("data-codcategoria"));
	$("#modalcategoria").modal("show");
});

$(document).on("click", "#btnregistrarcategoria", function() {
	if ($("#txtnombre").val() === "") {
		$("#errornombre").text("Es obligatorio el nombre de la categoria.");
	} else {
		$("#errornombre").text("");
	}
	if ($("#txtdescripcion").val() === "") {
		$("#errordescripcion").text("Es obligatorio la descripcion de la categoria.");
	} else {
		$("#errordescripcion").text("");
	}
	if ($("#txtnombre").val() !== "" && $("#txtdescripcion").val() !== "") {
		if ($("#hddcodcategoria").val() === "") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Categoria/registrarCategoriajs",
				data: JSON.stringify({
					nombre: $("#txtnombre").val(),
					descripcion: $("#txtdescripcion").val(),
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarCategoria();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		} else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Categoria/registrarCategoriajs",
				data: JSON.stringify({
					codcategoria: $("#hddcodcategoria").val(),
					nombre: $("#txtnombre").val(),
					descripcion: $("#txtdescripcion").val(),
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarCategoria();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		}
		$("#modalcategoria").modal("hide");
	}
});

$(document).on("click", ".btneliminarcategoria", function() {
	$("#mensajeeliminar").text("¿Está seguro de eliminar la categoria " +
		$(this).attr("data-nombre") + "?");
	$("#hddcodcategoriaeliminar").val($(this).attr("data-codcategoria"));
	$("#modaleliminarcategoria").modal("show");
});

$(document).on("click", "#btneliminarcategoria", function() {
	$.ajax({
		type: "DELETE",
		contentType: "application/json",
		url: "/Categoria/eliminarCategoriajs",
		data: JSON.stringify({
			codcategoria: $("#hddcodcategoriaeliminar").val()
		}),
		success: function(resultado) {
			var estilo = "danger";
			if (resultado.respuesta) {
				estilo = "success";
				ListarCategoria();
			}
			mostrarMensaje(resultado.mensaje, estilo);
			$("#modaleliminarcategoria").modal("hide");
		}
	});
});


function ListarCategoria() {
	$.ajax({
		type: "GET",
		url: "/Categoria/listarCategoriajs",
		dataType: "json",
		success: function(resultado) {
			$("#tblcategoria > tbody").html("");
			$.each(resultado, function(index, value) {
				$("#tblcategoria > tbody").append("<tr>" +
					"<td>" + value.codcategoria + "</td>" +
					"<td>" + value.nombre + "</td>" +
					"<td>" + value.descripcion + "</td>" +
					"<td><button type='button' class='btn btn-secondary btnactualizarcategoria' " +
					" data-codcategoria='"+value.codcategoria+"'" +
					" data-nombre='"+value.nombre+"'" +
					" data-descripcion='"+value.descripcion+"'><i class='fas fa-edit'></i></button>" +
					"</td>" +
					"<td><button type='button' class='btn btn-danger btneliminarcategoria' " +
					" data-codcategoria='" + value.codcategoria + "'" +
					" data-nombre='" + value.nombre + "'><i class='fas fa-trash-alt'></i></button>" +
					"</td></tr>")
			})
		}
	})
}
