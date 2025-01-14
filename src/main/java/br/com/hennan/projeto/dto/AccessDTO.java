package br.com.hennan.projeto.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class AccessDTO {

    private String token;

    public AccessDTO(String token) {
        super();
        this.token = token;
    }
}
