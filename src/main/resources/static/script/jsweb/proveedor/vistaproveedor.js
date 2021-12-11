$(document).on("click", "#btnagregarproveedor", function(){
    $("#txtnombre").val("");
    $("#txtdireccion").val("");
    $("#txttelefono").val("");
    $("#txtcorreo").val("");
    $("#hddcodproveedor").val("");
    $("#modalproveedor").modal("show")
})

$(document).on("click", ".btnactualizarproveedor", function(){
    $("#txtnombre").val($(this).attr("data-nombre"));
    $("#txtdireccion").val($(this).attr("data-direccion"));
    $("#txttelefono").val($(this).attr("data-telefono"));
    $("#txtcorreo").val($(this).attr("data-correo"));
    $("#hddcodproveedor").val($(this).attr("data-codproveedor"));
    $("#modalproveedor").modal("show")
    
})

$(document).on("click", "#btnregistrarproveedor", function(){
	if ($("#txtnombre").val() === "") {
		$("#errornombre").text("Es obligatorio el nombre del proveedor.")
	} else {
		$("#errornombre").text("");
	}
	if ($("#txtdireccion").val() === "") {
		$("#errordireccion").text("Es obligatorio la direccion del proveedor.")
	} else {
		$("#errordireccion").text("");
	}
	if ($("#txttelefono").val() === "") {
		$("#errortelefono").text("Es obligatorio el telefono del proveedor.")
	} else {
		$("#errortelefono").text("");
	}
	if ($("#txtcorreo").val() === "") {
		$("#errorcorreo").text("Es obligatorio el correo del proveedor.")
	} else {
		$("#errorcorreo").text("");
	}
	if ($("#txtnombre").val() !== "" && $("#txtdireccion").val() !== "" && $("#txttelefono").val() !== "" && $("#txtcorreo").val() !== "") {
		
	}
	
    if ($("#hddcodproveedor").val() === "") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Proveedor/registrarProveedorjs",
				data: JSON.stringify({
					nombre: $("#txtnombre").val(),
					direccion: $("#txtdireccion").val(),
					telefono: $("#txttelefono").val(),
					correo: $("#txtcorreo").val(),
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarProveedor();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		} else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Proveedor/registrarProveedorjs",
				data: JSON.stringify({
					codproveedor: $("#hddcodproveedor").val(),
					nombre: $("#txtnombre").val(),
					direccion: $("#txtdireccion").val(),
					telefono: $("#txttelefono").val(),
					correo: $("#txtcorreo").val(),
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarProveedor();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		}
		$("#modalproveedor").modal("hide");
    
});
function ListarProveedor(){
    $.ajax({
        type: "GET",
        url: "/Proveedor/listarProveedorjs",
        dataType: "json",
        success:function(resultado){
            $("#tblproveedor > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblproveedor > tbody").append("<tr>"+
                    "<td>" + value.codproveedor + "</td>"+
                    "<td>" + value.nombre + "</td>"+
                    "<td>" + value.direccion + "</td>"+
                    "<td>" + value.telefono + "</td>"+
                    "<td>" + value.correo + "</td>"+
                    "<td><button type='button' class='btn btn-secondary btnactualizarproveedor' "+
                    " data-codproveedor='"+value.codproveedor+"'"+
                    " data-nombre='"+value.nombre+"'"+
                    " data-direccion='"+value.direccion+"'"+
                    " data-telefono='"+value.telefono+"'"+
                    " data-correo='"+value.correo+"'><i class='fas fa-edit'></i></button>"+
                    "</td>"+
                    "<td><button type='button' class='btn btn-danger btneliminarproveedor' "+
                    " data-codproveedor='"+value.codproveedor+"'"+
                    " data-nombre='"+value.nombre+"'"+
                    " data-direccion='"+value.direccion+"'"+
                    " data-telefono='"+value.telefono+"'"+
                    " data-correo='"+value.correo+"'><i class='fas fa-trash-alt'></i></button>"+
                    "</td></tr>")
            })
                        
        }
    })
}

 

$(document).on("click", ".btneliminarproveedor", function(){
    $("#mensajeeliminar").text("¿Estas seguro de eliminar al proveedor " +
        $(this).attr("data-nombre")+"?"); 
    $("#hddcodproveedoreliminar").val($(this).attr("data-codproveedor")); 
    $("#modaleliminarproveedor").modal("show");
})

 

$(document).on("click", "#btneliminarproveedor", function() {
	$.ajax({
		type: "DELETE",
		contentType: "application/json",
		url: "/Proveedor/eliminarProveedorjs",
		data: JSON.stringify({
			codproveedor: $("#hddcodproveedoreliminar").val()
		}),
		success: function(resultado) {
			var estilo = "danger";
			if (resultado.respuesta) {
				estilo = "success";
				ListarProveedor();
			}
			mostrarMensaje(resultado.mensaje, estilo);
			$("#modaleliminarproveedor").modal("hide");
		}
	});
});