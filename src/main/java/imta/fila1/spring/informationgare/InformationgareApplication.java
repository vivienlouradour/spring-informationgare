package imta.fila1.spring.informationgare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.delivery.request"})
public class InformationgareApplication {

	public static void main(String[] args) {
		SpringApplication.run(InformationgareApplication.class, args);
	}
}
