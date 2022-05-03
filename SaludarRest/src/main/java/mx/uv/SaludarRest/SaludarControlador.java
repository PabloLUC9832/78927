package mx.uv.SaludarRest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

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


}


