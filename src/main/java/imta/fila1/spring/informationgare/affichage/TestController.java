package imta.fila1.spring.informationgare.affichage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/test")
	public String test() {
		return "testesttest";
	}
}
