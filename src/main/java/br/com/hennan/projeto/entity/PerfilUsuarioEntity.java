package br.com.hennan.projeto.entity;

import br.com.hennan.projeto.dto.PerfilDTO;
import br.com.hennan.projeto.dto.PerfilUsuarioDTO;
import br.com.hennan.projeto.dto.UsuarioDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "H PERFIL_USUARIO")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PerfilUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "ID_PERFIL")
    private PerfilEntity perfil;

    public PerfilUsuarioEntity(PerfilUsuarioDTO perfilUsuario) {
        BeanUtils.copyProperties(perfilUsuario, this);
        if(perfilUsuario != null && perfilUsuario.getUsuario() != null) {
            this.usuario =  new UsuarioEntity(perfilUsuario.getUsuario());
        }
        if(perfilUsuario != null && perfilUsuario.getPerfil() != null) {
            this.perfil = new PerfilEntity(perfilUsuario.getPerfil());
        }
    }
}
