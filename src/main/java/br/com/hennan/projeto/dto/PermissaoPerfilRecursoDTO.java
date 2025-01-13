package br.com.hennan.projeto.dto;

import br.com.hennan.projeto.entity.PermissaoPerfilRecursoEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PermissaoPerfilRecursoDTO {

    private Long id;
    private PerfilDTO perfil;
    private RecursoDTO recurso;

    public PermissaoPerfilRecursoDTO(PermissaoPerfilRecursoEntity permissaoPerfilRecurso) {
        BeanUtils.copyProperties(permissaoPerfilRecurso, this);
        if(permissaoPerfilRecurso.getRecurso() != null) {
            this.recurso =  new RecursoDTO(permissaoPerfilRecurso.getRecurso());
        }
        if(permissaoPerfilRecurso.getPerfil() != null) {
            this.perfil = new PerfilDTO(permissaoPerfilRecurso.getPerfil());
        }
    }
}
