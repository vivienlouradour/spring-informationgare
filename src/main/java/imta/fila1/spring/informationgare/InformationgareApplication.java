package imta.fila1.spring.informationgare;

import org.emn.messageBroker.CatalogueConsumer;
import org.emn.messageBroker.MajConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InformationgareApplication {

	public static void main(String[] args) {
		SpringApplication.run(InformationgareApplication.class, args);
		Thread t = new Thread(new CatalogueConsumer());
		t.start();

		Thread t2 = new Thread(new MajConsumer());
		t2.start();
		System.out.println("coucou");
	}
}
