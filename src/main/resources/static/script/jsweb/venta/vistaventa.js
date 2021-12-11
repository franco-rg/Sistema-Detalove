$(document).on("click", "#btnagregarventa", function(){
    $("#txttipodocumento").val("");
    $("#txtformapago").val("");
    $("#txtfecha").val("");
    $("#txtigv").val("");
    $("#txtsubtotal").val("");
    $("#txttotal").val("");
    $("#txtestado").val("");
    $("#txtcodcliente").val("");
    $("#hddcodventa").val("");
    $("#modalventa").modal("show")
})

$(document).on("click", ".btnactualizarventa", function(){
    $("#txttipodocumento").val($(this).attr("data-tipodocumento"));
    $("#txtformapago").val($(this).attr("data-formapago"));
    $("#txtfecha").val($(this).attr("data-fecha"));
    $("#txtigv").val($(this).attr("data-igv"));
    $("#txtsubtotal").val($(this).attr("data-subtotal"));
    $("#txttotal").val($(this).attr("data-total"));
    $("#txtestado").val($(this).attr("data-estado"));
    $("#txtcodcliente").val($(this).attr("data-codcliente"));
    $("#hddcodventa").val($(this).attr("data-codventa"));
    $("#modalventa").modal("show")
    
})

$(document).on("click", "#btnregistrarventa", function(){
	if ($("#txttipodocumento").val() === "") {
		$("#errortipodocumento").text("Es obligatorio el tipo de documento.")
	} else {
		$("#errortipodocumento").text("");
	}
	if ($("#txtformapago").val() === "") {
		$("#errorformapago").text("Es obligatorio la forma de pago.")
	} else {
		$("#errorformapago").text("");
	}
	if ($("#txtfecha").val() === "") {
		$("#errorfecha").text("Es obligatoria la fecha.")
	} else {
		$("#errorfecha").text("");
	}
	if ($("#txtigv").val() === "") {
		$("#errorigv").text("Es obligatorio el igv.")
	} else {
		$("#errorigv").text("");
		
	if ($("#txtsubtotal").val() === "") {
		$("#errorsubtotal").text("Es obligatorio el sub total.")
	} else {
		$("#errorsubtotal").text("");
		
	}
		if ($("#txttotal").val() === "") {
		$("#errortotal").text("Es obligatorio el total.")
	} else {
		$("#errortotal").text("");
		
	}
		if ($("#txtestado").val() === "") {
		$("#errorestado").text("Es obligatorio el estado.")
	} else {
		$("#errorestado").text("");
		
	}
	    if ($("#txtcodcliente").val() === "") {
		$("#errorcodcliente").text("Es obligatorio el codigo del cliente.")
	} else {
		$("#errorcodcliente").text("");
		
	}
	
	
	}
	if ($("#txttipodocumento").val() !== "" && $("#txtformapago").val() !== "" && $("#txtfecha").val() !== "" && $("#txtigv").val() !== "" && $("#txtsubtotal").val() !== "" && $("#txttotal").val() !==  "" && $("#txtestado").val() !==  "" && $("#txtcodcliente").val() ) {
		
	}
	
    if ($("#hddcodventa").val() === "") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Venta/registrarVentajs",
				data: JSON.stringify({
					tipodocumento: $("#txttipodocumento").val(),
				    formapago: $("#txtformapago").val(),
					fecha: $("#txtfecha").val(),
					igv: $("#txtigv").val(),
					subtotal: $("#txtsubtotal").val(),
					total: $("#txttotal").val(),
					estado: $("#txtestado").val(),
					codcliente: $("#txtcodcliente").val(),
					
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarVenta();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		} else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Venta/registrarVentajs",
				data: JSON.stringify({
					codventa: $("#hddcodventa").val(),
					tipodocumento: $("#txttipodocumento").val(),
					formapago: $("#txtformapago").val(),
					fecha: $("#txtfecha").val(),
					igv: $("#txtigv").val(),
					subtotal: $("#txtsubtotal").val(),
					total: $("#txttotal").val(),
					estado: $("#txtestado").val(),
					codcliente: $("#txtcodcliente").val(),
					
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarVenta();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		}
		$("#modalventa").modal("hide");
    
});
function ListarVenta(){
    $.ajax({
        type: "GET",
        url: "/Venta/listarVentajs",
        dataType: "json",
        success:function(resultado){
            $("#tblventa > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblventa > tbody").append("<tr>"+
                    "<td>" + value.codventa + "</td>"+
                    "<td>" + value.tipodocumento + "</td>"+
                    "<td>" + value.fecha + "</td>"+
                    "<td>" + value.igv + "</td>"+
                    "<td>" + value.subtotal + "</td>"+
                    "<td>" + value.total + "</td>"+
                    "<td>" + value.estado + "</td>"+
                    "<td>" + value.codcliente + "</td>"+
                    "<td><button type='button' class='btn btn-secondary btnactualizarventa' "+
                    " data-codventa='"+value.codventa+"'"+
                    " data-tipodocumento='"+value.tipodocumento+"'"+
                    " data-fecha='"+value.fecha+"'"+
                    " data-igv='"+value.igv+"'"+
                    " data-subtotal='"+value.subtotal+"'"+
                    " data-total='"+value.total+"'"+
                    " data-estado='"+value.estado+"'"+                       
                    " data-codcliente='"+value.codcliente+"'><i class='fas fa-edit'></i></button>"+
                    "</td>"+
                    "<td><button type='button' class='btn btn-danger btneliminarventa' "+
                    " data-codventa='"+value.codventa+"'"+
                    " data-tipodocumento='"+value.nombre+"'"+
                    " data-fecha='"+value.fecha+"'"+
                    " data-igv='"+value.igv+"'"+
                    " data-subtotal='"+value.subtotal+"'"+
                    " data-total='"+value.total+"'"+
                    " data-estado='"+value.estado+"'"+
                    " data-codcliente='"+value.codcliente+"'><i class='fas fa-trash-alt'></i></button>"+
                    "</td></tr>")
            })
                        
        }
    })
}

 

$(document).on("click", ".btneliminarventa", function(){
    $("#mensajeeliminar").text("¿Estas seguro de eliminar la venta " +
        $(this).attr("data-tipodocumento")+"?"); 
    $("#hddcodventaeliminar").val($(this).attr("data-codventa")); 
    $("#modaleliminarventa").modal("show");
})

 

$(document).on("click", "#btneliminarventa", function() {
	$.ajax({
		type: "DELETE",
		contentType: "application/json",
		url: "/Venta/eliminarVentajs",
		data: JSON.stringify({
			codventa: $("#hddcodventaeliminar").val()
		}),
		success: function(resultado) {
			var estilo = "danger";
			if (resultado.respuesta) {
				estilo = "success";
				ListarVenta();
			}
			mostrarMensaje(resultado.mensaje, estilo);
			$("#modaleliminarventa").modal("hide");
		}
	});
});