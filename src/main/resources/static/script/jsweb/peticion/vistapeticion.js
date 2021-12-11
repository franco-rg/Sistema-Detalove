$(document).on("click", "#btnagregarpeticion", function(){
    $("#txtasunto").val("");
    $("#txtdescripcion").val("");
    $("#txtimagen").val("");
    $("#txtcodcliente").val("");
    $("#hddcodpeticion").val("");
    $("#modalpeticion").modal("show")
})

$(document).on("click", ".btnactualizarpeticion", function(){
    $("#txtasunto").val($(this).attr("data-asunto"));
    $("#txtdescripcion").val($(this).attr("data-descripcion"));
    $("#txtimagen").val($(this).attr("data-imagen"));
    $("#txtcodcliente").val($(this).attr("data-codcliente"));
    $("#hddcodpeticion").val($(this).attr("data-codpeticion"));
    $("#modalpeticion").modal("show")
    
})

$(document).on("click", "#btnregistrarpeticion", function(){
	if ($("#txtasunto").val() === "") {
		$("#errorasunto").text("Es obligatorio el asunto de la peticion.")
	} else {
		$("#errorasunto").text("");
	}
	if ($("#txtdescripcion").val() === "") {
		$("#errordescripcion").text("Es obligatorio la descripcion de la peticion.")
	} else {
		$("#errordescripcion").text("");
	}
	if ($("#txtimagen").val() === "") {
		$("#errorimagen").text("Es obligatorio la imagen de la peticion.")
	} else {
		$("#errorimagen").text("");
	}
	if ($("#txtcodcliente").val() === "") {
		$("#errorcodcliente").text("Es obligatorio el codigo del cliente.")
	} else {
		$("#errorcodcliente").text("");
	}
	if ($("#txtasunto").val() !== "" && $("#txtdescripcion").val() !== "" && $("#txtimagen").val() !== "" && $("#txtcodcliente").val() !== "") {
		
	}
	
    if ($("#hddcodpeticion").val() === "") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Peticion/registrarPeticionjs",
				data: JSON.stringify({
					asunto: $("#txtasunto").val(),
					descripcion: $("#txtdescripcion").val(),
					imagen: $("#txtimagen").val(),
					codcliente: $("#txtcodcliente").val(),
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarPeticion();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		} else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Peticion/registrarPeticionjs",
				data: JSON.stringify({
					codpeticion: $("#hddcodpeticion").val(),
					asunto: $("#txtasunto").val(),
					descripcion: $("#txtdescripcion").val(),
					imagen: $("#txtimagen").val(),
					codcliente: $("#txtcodcliente").val(),
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarPeticion();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		}
		$("#modalpeticion").modal("hide");
    
});
function ListarPeticion(){
    $.ajax({
        type: "GET",
        url: "/Peticion/listarPeticionjs",
        dataType: "json",
        success:function(resultado){
            $("#tblpeticion > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblpeticion > tbody").append("<tr>"+
                    "<td>" + value.codpeticion + "</td>"+
                    "<td>" + value.asunto + "</td>"+
                    "<td>" + value.descripcion + "</td>"+
                    "<td>" + value.imagen + "</td>"+
                    "<td>" + value.codcliente + "</td>"+
                    "<td><button type='button' class='btn btn-secondary btnactualizarpeticion' "+
                    " data-codpeticion='"+value.codpeticion+"'"+
                    " data-asunto='"+value.asunto+"'"+
                    " data-descripcion='"+value.descripcion+"'"+
                    " data-imagen='"+value.imagen+"'"+
                    " data-codcliente='"+value.codcliente+"'><i class='fas fa-edit'></i></button>"+
                    "</td>"+
                    "<td><button type='button' class='btn btn-danger btneliminarpeticion' "+
                    " data-codpeticion='"+value.codpeticion+"'"+
                    " data-asunto='"+value.asunto+"'"+
                    " data-descripcion='"+value.descripcion+"'"+
                    " data-imagen='"+value.imagen+"'"+
                    " data-codcliente='"+value.codcliente+"'><i class='fas fa-trash-alt'></i></button>"+
                    "</td></tr>")
            })
                        
        }
    })
}

 

$(document).on("click", ".btneliminarpeticion", function(){
    $("#mensajeeliminar").text("¿Estas seguro de eliminar la peticion? " +
        $(this).attr("data-asunto")+"?"); 
    $("#hddcodpeticioneliminar").val($(this).attr("data-codpeticion")); 
    $("#modaleliminarpeticion").modal("show");
})

 

$(document).on("click", "#btneliminarpeticion", function() {
	$.ajax({
		type: "DELETE",
		contentType: "application/json",
		url: "/Peticion/eliminarPeticionjs",
		data: JSON.stringify({
			codpeticion: $("#hddcodpeticioneliminar").val()
		}),
		success: function(resultado) {
			var estilo = "danger";
			if (resultado.respuesta) {
				estilo = "success";
				ListarPeticion();
			}
			mostrarMensaje(resultado.mensaje, estilo);
			$("#modaleliminarpeticion").modal("hide");
		}
	});
});