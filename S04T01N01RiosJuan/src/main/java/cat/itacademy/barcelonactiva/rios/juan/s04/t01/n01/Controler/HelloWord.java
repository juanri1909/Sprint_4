package cat.itacademy.barcelonactiva.rios.juan.s04.t01.n01.Controler;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWord {
	
	@RequestMapping("/HelloWord")
	@ResponseBody
    public String saluda(@RequestParam(defaultValue = "UNKNOWN")String nom) 
    { 
		
        return "Hola " + nom +  " Estàs executant un projecte Maven.";
    }
	
	@RequestMapping(value = {"/HelloWord2", "/HelloWord2/{id}"})
	public String saluda2(@PathVariable Optional<String> id) {
		String articleId;
		if (id.isPresent()) {
	        articleId = "Hola "+ id.get() + "Estàs executant un projecte Maven.";
	        //...
	    } else {
	        //...
	    	articleId="UNKNOWN";
	    	
	    }
		return articleId;
	}

}
