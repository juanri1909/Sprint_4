package cat.itacademy.barcelonactiva.rios.juan.s04.t02.n01_.S04T02N01RiosJuan_;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.rios.juan.s04.t02.n01_.S04T02N01RiosJuan_.Entity.Fruita;
import cat.itacademy.barcelonactiva.rios.juan.s04.t02.n01_.S04T02N01RiosJuan_.Repositori.FruitaRepositori;

@RestController
public class FruitaControler {
	
	@Autowired
	FruitaRepositori repositorio;
	
	@GetMapping("/fruita/getAll")
	public List<Fruita> listar(){
		return (List<Fruita>) repositorio.findAll();
	}
	
	@PostMapping("/fruita/add")
	public void insertar(@RequestBody Fruita f) {
		repositorio.save(f);
	}
	
	@PutMapping("/fruita/update")
	public ResponseEntity<?> modificar(@RequestBody Fruita f) {
		
		Map<String, Object> response = new HashMap<>();
		Optional<Fruita> f1 = null;
		f1=repositorio.findById(f.getId());
		
		if (!f1.isEmpty()) {
			repositorio.save(f);
			response.put("Mensaje: ", "OK. ENCONTRADO Y MODIFICADO");
		}
		else {
			response.put("Mensaje:", " FRUTA NO EXISTE. NO SE PUEDE MODIFICAR");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);				
			}					
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		//repositorio.save(f);
	}
	
	@DeleteMapping(value ="/fruita/delete/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") int identif) {
		Map<String, Object> response = new HashMap<>();
		try {
			repositorio.deleteById(identif);
			response.put("Mensaje", "Se elimino".concat("La fruta"));
			
		}
		catch(DataAccessException e){
			response.put("Mensaje", "Ocurrio un error ".concat("no exite la fruta con id ".concat(String.valueOf(identif))));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);	}
	
	
	@GetMapping("/fruita/getOne/{id}")
	public ResponseEntity<?> listarPorId3(@PathVariable("id") int identif){
		Optional<Fruita> f = null;
		Map<String, Object> response = new HashMap<>();
		f=repositorio.findById(identif);
		if (!f.isEmpty()) {
			response.put("Mensaje: OK. Fruta encontrada", f);
		}
		else {
			response.put("Mensaje:", " Fruta no encontrada");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);				
			}					
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);		
	}

}


