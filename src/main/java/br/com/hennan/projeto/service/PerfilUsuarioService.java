package br.com.hennan.projeto.service;

import br.com.hennan.projeto.dto.PerfilUsuarioDTO;
import br.com.hennan.projeto.dto.UsuarioDTO;
import br.com.hennan.projeto.entity.PerfilUsuarioEntity;
import br.com.hennan.projeto.entity.UsuarioEntity;
import br.com.hennan.projeto.repository.PerfilUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilUsuarioService {

    @Autowired
    private PerfilUsuarioRepository perfilUsuarioRepository;

    public List<PerfilUsuarioDTO> listarTodos() {
        List<PerfilUsuarioEntity> perfis_de_usuario = perfilUsuarioRepository.findAll();
        return perfis_de_usuario.stream().map(PerfilUsuarioDTO::new).toList();
    }

    public void inserir(PerfilUsuarioDTO perfil_de_usuario) {
        PerfilUsuarioEntity perfilUsuarioEntity = new PerfilUsuarioEntity(perfil_de_usuario);
        perfilUsuarioRepository.save(perfilUsuarioEntity);
    }

    public PerfilUsuarioDTO alterar(PerfilUsuarioDTO perfil_de_usuario) {
        PerfilUsuarioEntity perfilUsuarioEntity = new PerfilUsuarioEntity(perfil_de_usuario);
        return new PerfilUsuarioDTO(perfilUsuarioRepository.save(perfilUsuarioEntity));
    }

    public void excluir(Long id) {
        PerfilUsuarioEntity perfil_de_usuario = perfilUsuarioRepository.findById(id).get();
        perfilUsuarioRepository.delete(perfil_de_usuario);
    }

    public PerfilUsuarioDTO buscarPorId(Long id) {
        return new PerfilUsuarioDTO(perfilUsuarioRepository.findById(id).get());
    }
}
