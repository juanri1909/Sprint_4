package cat.itacademy.barcelonactiva.rios.juan.s04.t02.n01_.S04T02N01RiosJuan_.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.rios.juan.s04.t02.n01_.S04T02N01RiosJuan_.Entity.Fruita;
import cat.itacademy.barcelonactiva.rios.juan.s04.t02.n01_.S04T02N01RiosJuan_.Repositori.FruitaRepositori;

@Service
public class FruitaServiceImpl implements FruitaService{
	@Autowired
	private FruitaRepositori fruitarepositori;

	@Override
	public List<Fruita> Listar() {
		return (List<Fruita>) fruitarepositori.findAll();
	}

	@Override
	public void Guardar(Fruita f) {
		fruitarepositori.save(f);
		
	}

	@Override
	public ResponseEntity<?> modificar(Fruita f) {
		Map<String, Object> response = new HashMap<>();
		Optional<Fruita> f1 = null;
		f1=fruitarepositori.findById(f.getId());
		if (!f1.isEmpty()) {
			fruitarepositori.save(f);
			response.put("Mensaje: ", "OK. ENCONTRADO Y MODIFICADO");
		}
		else {
			response.put("Mensaje:", " FRUTA NO EXISTE. NO SE PUEDE MODIFICAR");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);				
			}					
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> eliminar(int identif) {
		Map<String, Object> response = new HashMap<>();
		try {
			fruitarepositori.deleteById(identif);
			response.put("Mensaje", "Se elimino".concat("La fruta"));
			
		}
		catch(DataAccessException e){
			response.put("Mensaje", "Ocurrio un error ".concat("no exite la fruta con id ".concat(String.valueOf(identif))));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> listarPorId(int identif) {
		Optional<Fruita> f = null;
		Map<String, Object> response = new HashMap<>();
		f=fruitarepositori.findById(identif);
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
