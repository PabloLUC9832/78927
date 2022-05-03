package mx.uv.SaludarRest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class SaludarControlador{
  @RequestMapping("/")
  public String home(){
    return "HOLA MUNDO :d";
  }

  @RequestMapping(value="/saludar",method=RequestMethod.GET)
  public String saludarG(){
    return "hola /saludar GET";
  }

  @RequestMapping(value="/saludar",method=RequestMethod.POST)
  public String saludarP(){
    return "hola desde /saludar POST";
  }

  @GetMapping("/saludar1/{nombre}")
  public Saludador saludarPath1(@PathVariable String nombre){
    return new Saludador(nombre);
  }

  @RequestMapping(value="/saludar2/{nombrep}",method=RequestMethod.GET)
  public String saludarPath2(@PathVariable("nombrep") String nombre){
    return "Hola nombrep: "+ nombre;
  }

}


