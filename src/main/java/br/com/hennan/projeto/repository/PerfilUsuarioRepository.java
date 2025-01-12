package br.com.hennan.projeto.repository;

import br.com.hennan.projeto.entity.PerfilUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuarioEntity, Long> {
}
