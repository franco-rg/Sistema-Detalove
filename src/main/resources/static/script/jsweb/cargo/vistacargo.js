$(document).on("click", "#btnagregarcargo", function(){
    $("#txtnombre").val("");
    $("#txtestado").val("");
    $("#hddcodcargo").val("");
    $("#modalcargo").modal("show")
})

$(document).on("click", ".btnactualizarcargo", function(){
    $("#txtnombre").val($(this).attr("data-nombre"));
    $("#txtestado").val($(this).attr("data-estado"));
    $("#hddcodcargo").val($(this).attr("data-codcargo"));
    $("#modalcargo").modal("show")
    
})

$(document).on("click", "#btnregistrarcargo", function(){
	if ($("#txtnombre").val() === "") {
		$("#errornombre").text("Es obligatorio el nombre del cargo.")
	} else {
		$("#errornombre").text("");
	}
	if ($("#txtestado").val() === "") {
		$("#errorestado").text("Es obligatorio la direccion del cargo.")
	} else {
		$("#errorestado").text("");
	}
	if ($("#txtnombre").val() !== "" && $("#txtestado").val() !== "") {
		
	}
	
    if ($("#hddcodcargo").val() === "") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Cargo/registrarCargojs",
				data: JSON.stringify({
					nombre: $("#txtnombre").val(),
					estado: $("#txtestado").val(),
					
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarCargo();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		} else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Cargo/registrarCargojs",
				data: JSON.stringify({
					codcargo: $("#hddcodcargo").val(),
					nombre: $("#txtnombre").val(),
					estado: $("#txtestado").val(),
				
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarCargo();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		}
		$("#modalcargo").modal("hide");
    
});
function ListarCargo(){
    $.ajax({
        type: "GET",
        url: "/Cargo/listarCargojs",
        dataType: "json",
        success:function(resultado){
            $("#tblcargo > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblcargo > tbody").append("<tr>"+
                    "<td>" + value.codcargo + "</td>"+
                    "<td>" + value.nombre + "</td>"+
                    "<td>" + value.estado + "</td>"+
                    "<td><button type='button' class='btn btn-secondary btnactualizarcargo' "+
                    " data-codcargo='"+value.codcargo+"'"+
                    " data-nombre='"+value.nombre+"'"+
                    " data-estado='"+value.estado+"'><i class='fas fa-edit'></i></button>"+
                    "</td>"+
                    "<td><button type='button' class='btn btn-danger btneliminarcargo' "+
                    " data-codcargo='"+value.codcargo+"'"+
                    " data-nombre='"+value.nombre+"'"+
                    " data-estado='"+value.estado+"'><i class='fas fa-trash-alt'></i></button>"+
                    "</td></tr>")
            })
                        
        }
    })
}

 

$(document).on("click", ".btneliminarcargo", function(){
    $("#mensajeeliminar").text("¿Estas seguro de eliminar al cargo " +
        $(this).attr("data-nombre")+"?"); 
    $("#hddcodcargoeliminar").val($(this).attr("data-codcargo")); 
    $("#modaleliminarcargo").modal("show");
})

 

$(document).on("click", "#btneliminarcargo", function() {
	$.ajax({
		type: "DELETE",
		contentType: "application/json",
		url: "/Cargo/eliminarCargojs",
		data: JSON.stringify({
			codcargo: $("#hddcodcargoeliminar").val()
		}),
		success: function(resultado) {
			var estilo = "danger";
			if (resultado.respuesta) {
				estilo = "success";
				ListarCargo();
			}
			mostrarMensaje(resultado.mensaje, estilo);
			$("#modaleliminarcargo").modal("hide");
		}
	});
});