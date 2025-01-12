package br.com.hennan.projeto.dto;


import br.com.hennan.projeto.entity.PerfilUsuarioEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PerfilUsuarioDTO {

    private Long id;
    private UsuarioDTO usuario;
    private PerfilDTO perfil;


    public PerfilUsuarioDTO(PerfilUsuarioEntity perfilUsuario) {
        BeanUtils.copyProperties(perfilUsuario, this);
        if(perfilUsuario != null && perfilUsuario.getUsuario() != null) {
            this.usuario =  new UsuarioDTO(perfilUsuario.getUsuario());
        }
        if(perfilUsuario != null && perfilUsuario.getPerfil() != null) {
            this.perfil = new PerfilDTO(perfilUsuario.getPerfil());
        }
    }
}
