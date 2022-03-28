package mx.uv.t4is.Saludos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludos.BorrarSaludoRequest;
import https.t4is_uv_mx.saludos.BorrarSaludoResponse;
import https.t4is_uv_mx.saludos.BuscarSaludosResponse;
import https.t4is_uv_mx.saludos.ModificarSaludoRequest;
import https.t4is_uv_mx.saludos.ModificarSaludoResponse;
import https.t4is_uv_mx.saludos.SaludarRequest;
import https.t4is_uv_mx.saludos.SaludarResponse;
import https.t4is_uv_mx.saludos.BuscarSaludosResponse.Saludos;

@Endpoint
public class SaludosEndPoint {
    int contador = 1;
    List<Saludo> saludos = new ArrayList<>();


    @PayloadRoot(localPart = "SaludarRequest" ,namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion) {
        SaludarResponse respuesta = new SaludarResponse();
        respuesta.setRespuesta("Hola "+peticion.getNombre());
        Saludo saludo = new Saludo();
        saludo.setNombre(peticion.getNombre());
        saludo.setId(contador);
        saludos.add(saludo);
        contador++;
        return respuesta;  
    }

    @PayloadRoot(localPart = "BuscarSaludosRequest" ,namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public BuscarSaludosResponse buscarSaludos(){
        BuscarSaludosResponse respuesta = new BuscarSaludosResponse();
        for (Saludo saludo : saludos) {
            BuscarSaludosResponse.Saludos saludosBuscar = new BuscarSaludosResponse.Saludos();
            saludosBuscar.setId(saludo.getId());
            saludosBuscar.setNombre(saludo.getNombre());
            respuesta.getSaludos().add(saludosBuscar);
        }
        return respuesta;
    }

    @PayloadRoot(localPart = "ModificarSaludoRequest" ,namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public ModificarSaludoResponse modificar(@RequestPayload ModificarSaludoRequest peticion){       
        ModificarSaludoResponse respuesta = new ModificarSaludoResponse(); 
        Saludo e = new Saludo();
        e.setNombre(peticion.getNombre());
        e.setId(peticion.getId());
        saludos.set(peticion.getId()-1,e);            
        respuesta.setRespuesta(true);        
        return respuesta;
    }

    @PayloadRoot(namespace = "https://t4is.uv.mx/saludos", localPart = "BorrarSaludoRequest")
	@ResponsePayload
	public BorrarSaludoResponse modificar(@RequestPayload BorrarSaludoRequest peticion){
		BorrarSaludoResponse respuesta = new BorrarSaludoResponse();
		Saludos e = new Saludos();

		e.setId(peticion.getId());
		saludos.remove(peticion.getId()-1);
		respuesta.setRespuesta(true);
		
		return respuesta;
    }

}
