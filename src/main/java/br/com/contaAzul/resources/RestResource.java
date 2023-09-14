package br.com.contaAzul.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.contaAzul.exceptions.BadRequestException;
import br.com.contaAzul.model.Terreno;
import br.com.contaAzul.services.RoboService;

@RestController
@RequestMapping("rest")
public class RestResource {

	@Autowired
	RoboService roboService;

	@RequestMapping(value = "/mars/{posicao:[A-Z]*}", method = RequestMethod.POST)
	public ResponseEntity<String> funcMars(@PathVariable("posicao") String posicao) throws BadRequestException {
		var terreno = new Terreno(5);
		roboService.init(0, 0, 'N', terreno);
		try {
			roboService.andar(posicao);
		} catch (BadRequestException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.ok().body(roboService.posToString());
	}

}
