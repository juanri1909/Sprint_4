package cat.itacademy.barcelonactiva.rios.juan.s04.t02.n01_.S04T02N01RiosJuan_;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import cat.itacademy.barcelonactiva.rios.juan.s04.t02.n01_.S04T02N01RiosJuan_.Entity.Fruita;
import cat.itacademy.barcelonactiva.rios.juan.s04.t02.n01_.S04T02N01RiosJuan_.Service.FruitaService;

@RestController
public class FruitaControler {
	
	@Autowired
	private FruitaService fruitaservice;
	
	@GetMapping("/fruita/getAll")
	public List<Fruita> listar(){
		return fruitaservice.Listar();
	}
	
	@PostMapping("/fruita/add")
	public void insertar(@RequestBody Fruita f) {
		fruitaservice.Guardar(f);
	}
	
	@PutMapping("/fruita/update")
	public ResponseEntity<?> modificar(@RequestBody Fruita f) {
		return fruitaservice.modificar(f);
	}
	
	@DeleteMapping(value ="/fruita/delete/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") int identif) {
		return fruitaservice.eliminar(identif);
	}
	
	@GetMapping("/fruita/getOne/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable("id") int identif){
		return fruitaservice.listarPorId(identif);		
	}
	

}


