package mx.uv.SaludarCRUDRest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoControlador {

    List<Saludo> lista = new ArrayList<>();
    private int contador = 0;   

    @RequestMapping("/")
    public String home(){
        return "Actividad 03/05/2022 - SALUDOS SOAP A REST SIN BD";
    }

    //AGREGO UN SALUDO
    @GetMapping("/agregar")
    public String agregar(@RequestParam(name="nombre",defaultValue="fantasma") String nombre){

        Saludo saludo = new Saludo();
        saludo.setNombre(nombre);
        saludo.setId(contador);
        lista.add(saludo);
        contador++;
        return " " + nombre + " ,se ha agregado con exito";
    }

    //LISTA DE SALUDOS
    //http://localhost:8080/lista
    @GetMapping("/lista")
    public List<Saludo> lista(){
        return lista;
    } 

    //MODIFICAR UN SALUDO
    //http://localhost:8080/modificar?id=1&nombre=x
    @GetMapping("/modificar")
    public String modificar(@RequestParam(name="id",defaultValue="") int id, @RequestParam(name="nombre",defaultValue="") String nombre){

        Saludo saludo = new Saludo();
        //int idN = Integer.parseInt(id);
        saludo.setId(id);
        saludo.setNombre(nombre);
        lista.set(id,saludo);
        return "Se ha modificado con exito";
    }

    //ELIMINAR
    //http://localhost:8080/eliminar?id=1
    @GetMapping("/eliminar")
    public String eliminar(@RequestParam(name="id",defaultValue="") int id){
        Saludo saludo = new Saludo();
        saludo.setId(id);
        lista.remove(saludo.getId());
        return "Se ha eliminado con exito";
    }


}
