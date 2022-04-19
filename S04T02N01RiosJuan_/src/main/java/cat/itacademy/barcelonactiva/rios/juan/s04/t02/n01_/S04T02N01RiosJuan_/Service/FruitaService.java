package cat.itacademy.barcelonactiva.rios.juan.s04.t02.n01_.S04T02N01RiosJuan_.Service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import cat.itacademy.barcelonactiva.rios.juan.s04.t02.n01_.S04T02N01RiosJuan_.Entity.Fruita;

public interface FruitaService {
	public List<Fruita> Listar();
	public void Guardar(Fruita f);
	public ResponseEntity<?> modificar(Fruita f);
	public ResponseEntity<?> eliminar(int identif);
	public ResponseEntity<?> listarPorId(int identif);

}
