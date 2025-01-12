package br.com.hennan.projeto.controller;


import br.com.hennan.projeto.dto.PerfilUsuarioDTO;
import br.com.hennan.projeto.dto.RecursoDTO;
import br.com.hennan.projeto.service.PerfilUsuarioService;
import br.com.hennan.projeto.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/perfil-usuario")
@CrossOrigin
public class PerfilUsuarioController {

    @Autowired
    private PerfilUsuarioService perfilUsuarioService;

    @GetMapping
    public List<PerfilUsuarioDTO> listarTodos() { return perfilUsuarioService.listarTodos();}

    @PostMapping
    public void inserir(@RequestBody PerfilUsuarioDTO perfil_de_usuario) { perfilUsuarioService.inserir(perfil_de_usuario);}

    @PutMapping
    public PerfilUsuarioDTO alterar(@RequestBody PerfilUsuarioDTO perfil_de_usuario) {return perfilUsuarioService.alterar(perfil_de_usuario);}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        perfilUsuarioService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
