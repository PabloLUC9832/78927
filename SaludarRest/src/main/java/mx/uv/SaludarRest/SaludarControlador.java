package mx.uv.SaludarRest;

import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludarControlador{
  @RequestMapping("/")
  public String home(){
    return "HOLA MUNDO :d";
  }

}

