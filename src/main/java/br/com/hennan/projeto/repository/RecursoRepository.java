package br.com.hennan.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.hennan.projeto.entity.RecursoEntity;

public interface RecursoRepository extends JpaRepository<RecursoEntity, Long> {

}
