package br.com.hennan.projeto.entity;

import br.com.hennan.projeto.dto.PerfilDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "H_PERFIL")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PerfilEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    public PerfilEntity(PerfilDTO perfil) {
        BeanUtils.copyProperties(perfil, this);
    }
}
