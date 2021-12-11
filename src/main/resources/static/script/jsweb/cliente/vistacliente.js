$(document).on("click", "#btnagregarcliente", function(){
    $("#txtnombre").val("");
    $("#txtapellido").val("");
    $("#txtedad").val("");
    $("#txtcelular").val("");
    $("#txtgenero").val("");
    $("#txtdireccion").val("");
    $("#hddcodcliente").val("");
    $("#modalcliente").modal("show")
})

$(document).on("click", ".btnactualizarcliente", function(){
    $("#txtnombre").val($(this).attr("data-nombre"));
    $("#txtapellido").val($(this).attr("data-apellido"));
    $("#txtedad").val($(this).attr("data-edad"));
    $("#txtcelular").val($(this).attr("data-celular"));
    $("#txtgenero").val($(this).attr("data-genero"));
    $("#txtdireccion").val($(this).attr("data-direccion"));
    $("#hddcodcliente").val($(this).attr("data-codcliente"));
    $("#modalcliente").modal("show")
    
})

$(document).on("click", "#btnregistrarcliente", function(){
	if ($("#txtnombre").val() === "") {
		$("#errornombre").text("Es obligatorio el nombre del cliente.")
	} else {
		$("#errornombre").text("");
	}
	if ($("#txtapellido").val() === "") {
		$("#errorapellido").text("Es obligatorio el apellido del cliente.")
	} else {
		$("#errorapellido").text("");
	}
	if ($("#txtedad").val() === "") {
		$("#erroredad").text("Es obligatorio la edad del cliente.")
	} else {
		$("#erroredad").text("");
	}
	if ($("#txtcelular").val() === "") {
		$("#errorcelular").text("Es obligatorio el celular del cliente.")
	} else {
		$("#errorcelular").text("");
	}
	if ($("#txtgenero").val() === "") {
		$("#errorgenero").text("Es obligatorio el genero del cliente.")
	} else {
		$("#errorgenero").text("");
	}
	if ($("#txtdireccion").val() === "") {
		$("#errordireccion").text("Es obligatorio la direccion del cliente.")
	} else {
		$("#errordireccion").text("");
	}
	if ($("#txtnombre").val() !== "" && $("#txtapellido").val() !== "" && $("#txtedad").val() !== "" && $("#txtcelular").val() !== "" && $("#txtgenero").val() !== "" && $("#txtdireccion").val() !== "") {
		
	}
	
    if ($("#hddcodcliente").val() === "") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Cliente/registrarClientejs",
				data: JSON.stringify({
					nombre: $("#txtnombre").val(),
					apellido: $("#txtapellido").val(),
					edad: $("#txtedad").val(),
					celular: $("#txtcelular").val(),
					genero: $("#txtgenero").val(),
					direccion: $("#txtdireccion").val(),
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarCliente();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		} else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Cliente/registrarClientejs",
				data: JSON.stringify({
					codcliente: $("#hddcodcliente").val(),
					nombre: $("#txtnombre").val(),
					apellido: $("#txtapellido").val(),
					edad: $("#txtedad").val(),
					celular: $("#txtcelular").val(),
					genero: $("#txtgenero").val(),
					direccion: $("#txtdireccion").val(),
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarCliente();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		}
		$("#modalcliente").modal("hide");
    
});
function ListarCliente(){
    $.ajax({
        type: "GET",
        url: "/Cliente/listarClientejs",
        dataType: "json",
        success:function(resultado){
            $("#tblcliente > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblcliente > tbody").append("<tr>"+
                    "<td>" + value.codcliente + "</td>"+
                    "<td>" + value.nombre + "</td>"+
                    "<td>" + value.apellido + "</td>"+
                    "<td>" + value.edad + "</td>"+
                    "<td>" + value.celular + "</td>"+
                    "<td>" + value.genero + "</td>"+
                    "<td>" + value.direccion + "</td>"+
                    "<td><button type='button' class='btn btn-secondary btnactualizarcliente' "+
                    " data-codcliente='"+value.codcliente+"'"+
                    " data-nombre='"+value.nombre+"'"+
                    " data-apellido='"+value.apellido+"'"+
                    " data-edad='"+value.edad+"'"+
                    " data-celular='"+value.celular+"'"+
                    " data-genero='"+value.genero+"'"+
                    " data-direccion='"+value.direccion+"'><i class='fas fa-edit'></i></button>"+
                    "</td>"+
                    "<td><button type='button' class='btn btn-danger btneliminarcliente' "+
                    " data-codcliente='"+value.codcliente+"'"+
                    " data-nombre='"+value.nombre+"'"+
                    " data-apellido='"+value.apellido+"'"+
                    " data-edad='"+value.edad+"'"+
                    " data-celular='"+value.celular+"'"+
                    " data-genero='"+value.genero+"'"+
                    " data-direccion='"+value.direccion+"'><i class='fas fa-trash-alt'></i></button>"+
                    "</td></tr>")
            })
                        
        }
    })
}

 

$(document).on("click", ".btneliminarcliente", function(){
    $("#mensajeeliminar").text("¿Estas seguro de eliminar al cliente? " +
        $(this).attr("data-nombre")+"?"); 
    $("#hddcodclienteeliminar").val($(this).attr("data-codcliente")); 
    $("#modaleliminarcliente").modal("show");
})

 

$(document).on("click", "#btneliminarcliente", function() {
	$.ajax({
		type: "DELETE",
		contentType: "application/json",
		url: "/Cliente/eliminarClientejs",
		data: JSON.stringify({
			codcliente: $("#hddcodclienteeliminar").val()
		}),
		success: function(resultado) {
			var estilo = "danger";
			if (resultado.respuesta) {
				estilo = "success";
				ListarCliente();
			}
			mostrarMensaje(resultado.mensaje, estilo);
			$("#modaleliminarcliente").modal("hide");
		}
	});
});