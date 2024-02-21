package br.com.brunojs;

import br.com.brunojs.domain.Cliente;
import br.com.brunojs.repository.IClienteRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.brunojs.repository")
@EntityScan("br.com.brunojs.*")
@ComponentScan(basePackages = "br.com.brunojs")
@Service
public class ProjetoSpringBootApplication implements CommandLineRunner {

	//** Log da aplicacao
//	private static final Logger log = (Logger) LoggerFactory.getLogger(ProjetoSpringBootApplication.class);

	//** Repositorio do cliente
	@Autowired
	private IClienteRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		log.info("StartApplication...");
		Cliente cliente = createCliente();
		repository.save(cliente);
	}

	private Cliente createCliente() {
		return Cliente.builder()
				.cidade("DF")
				.cpf(12312312310L)
				.end("End")
				.estado("DF")
				.nome("Teste Spring Boot")
				.numero(102030)
				.tel(10203040L)
				.build();
	}
}
