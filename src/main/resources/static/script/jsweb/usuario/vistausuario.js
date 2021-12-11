$(document).on("click", "#btnagregarusuario", function(){
    $("#txtnombre").val("");
    $("#txtclave").val("");
    $("#txtcargo").val("");
    $("#txtcliente").val("");
    $("#txtpeticion").val("");
    $("#hddcodusuario").val("");
    $("#modalusuario").modal("show")
})

$(document).on("click", ".btnactualizarusuario", function(){
    $("#txtnombre").val($(this).attr("data-nombre"));
    $("#txtclave").val($(this).attr("data-clave"));
    $("#txtcargo").val($(this).attr("data-cargo"));
    $("#txtcliente").val($(this).attr("data-cliente"));
    $("#txtpeticion").val($(this).attr("data-peticion"));
    $("#hddcodusuario").val($(this).attr("data-codusuario"));
    $("#modalusuario").modal("show")
    
})

$(document).on("click", "#btnregistrarusuario", function(){
	if ($("#txtnombre").val() === "") {
		$("#errornombre").text("Es obligatorio el nombre del usuario.")
	} else {
		$("#errornombre").text("");
	}
	if ($("#txtclave").val() === "") {
		$("#errorclave").text("Es obligatorio la clave del usuario.")
	} else {
		$("#errorclave").text("");
	}
	if ($("#txtcargo").val() === "") {
		$("#errorcargo").text("Es obligatorio el cargo del usuario.")
	} else {
		$("#errorcargo").text("");
	}
	if ($("#txtcliente").val() === "") {
		$("#errorcliente").text("Es obligatorio el cliente del usuario.")
	} else {
		$("#errorcliente").text("");
	}
	if ($("#txtpeticion").val() === "") {
		$("#errorpeticion").text("Es obligatorio la peticion del usuario.")
	} else {
		$("#errorpeticion").text("");
	}
	if ($("#txtnombre").val() !== "" && $("#txtclave").val() !== "" && $("#txtcargo").val() !== "" && $("#txtcliente").val() !== "" && $("#txtpeticion").val() !== "") {
		
	}
	
    if ($("#hddcodusuario").val() === "") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Usuario/registrarUsuariojs",
				data: JSON.stringify({
					nombre: $("#txtnombre").val(),
					clave: $("#txtclave").val(),
					cargo: $("#txtcargo").val(),
					cliente: $("#txtcliente").val(),
					peticion: $("#txtpeticion").val(),
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarUsuario();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		} else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Usuario/registrarUsuariojs",
				data: JSON.stringify({
					codusuario: $("#hddcodusuario").val(),
					nombre: $("#txtnombre").val(),
					clave: $("#txtclave").val(),
					cargo: $("#txtcargo").val(),
					cliente: $("#txtcliente").val(),
					peticion: $("#txtpeticion").val(),
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarUsuario();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		}
		$("#modalusuario").modal("hide");
    
});
function ListarUsuario(){
    $.ajax({
        type: "GET",
        url: "/Usuario/listarUsuariojs",
        dataType: "json",
        success:function(resultado){
            $("#tblusuario > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblusuario > tbody").append("<tr>"+
                    "<td>" + value.codusuario + "</td>"+
                    "<td>" + value.nombreusuario + "</td>"+
                    "<td>" + value.clave + "</td>"+
                    "<td>" + value.codcargo + "</td>"+
                    "<td>" + value.codcliente + "</td>"+
                    "<td>" + value.codpeticion + "</td>"+
                    "<td><button type='button' class='btn btn-secondary btnactualizarusuario' "+
                    " data-codusuario='"+value.codusuario+"'"+
                    " data-nombre='"+value.nombreusuario+"'"+
                    " data-clave='"+value.clave+"'"+
                    " data-cargo='"+value.codcargo+"'"+
                    " data-cliente='"+value.codcliente+
                    " data-peticion='"+value.codpeticion+"'><i class='fas fa-edit'></i></button>"+
                    "</td>"+
                    "<td><button type='button' class='btn btn-danger btneliminarusuario' "+
                    " data-codusuario='"+value.codusuario+"'"+
                    " data-nombre='"+value.nombreusuario+"'"+
                    " data-clave='"+value.clave+"'"+
                    " data-cargo='"+value.codcargo+"'"+
                    " data-cliente='"+value.codcliente+"'"+
                    " data-peticion='"+value.codpeticion+"'><i class='fas fa-trash-alt'></i></button>"+
                    "</td></tr>")
            })
                        
        }
    })
}

 

$(document).on("click", ".btneliminarusuario", function(){
    $("#mensajeeliminar").text("¿Estas seguro de eliminar al usuario " +
        $(this).attr("data-nombre")+"?"); 
    $("#hddcodusuarioeliminar").val($(this).attr("data-codusuario")); 
    $("#modaleliminarusuario").modal("show");
})

 

$(document).on("click", "#btneliminarusuario", function() {
	$.ajax({
		type: "DELETE",
		contentType: "application/json",
		url: "/Usuario/eliminarUsuariojs",
		data: JSON.stringify({
			codproveedor: $("#hddcodusuarioeliminar").val()
		}),
		success: function(resultado) {
			var estilo = "danger";
			if (resultado.respuesta) {
				estilo = "success";
				ListarUsuario();
			}
			mostrarMensaje(resultado.mensaje, estilo);
			$("#modaleliminarusuario").modal("hide");
		}
	});
});