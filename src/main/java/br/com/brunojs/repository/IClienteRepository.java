package br.com.brunojs.repository;

import br.com.brunojs.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteRepository extends CrudRepository<Cliente, Long> {
}
