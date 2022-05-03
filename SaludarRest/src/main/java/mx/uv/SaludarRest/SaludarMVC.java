package mx.uv.SaludarRest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class SaludarMVC {

	@GetMapping("/saludarHtml")
	public String bienvenido(Model modelo){
	//public String bienvenido(){
		modelo.addAttribute("Thnombre","mundo!!!");
		return "bienvenido";
	}

}