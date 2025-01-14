package br.com.hennan.projeto.service;

import br.com.hennan.projeto.dto.AccessDTO;
import br.com.hennan.projeto.dto.AuthenticationDTO;
import br.com.hennan.projeto.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    public AccessDTO login(AuthenticationDTO authenticationDTO) {
        AccessDTO accessDto = null;
        try {
            //Cria mecanismo de credencial para o spring
            UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(authenticationDTO.getUsername(), authenticationDTO.getPassword());

            //Prepara mecanisco para autenticação
            Authentication authentication = authenticationManager.authenticate(userAuth);

            //Busca usuario logado
            UserDetailsImpl userAuthenticate = (UserDetailsImpl) authentication.getPrincipal();

            String token = JwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);

            accessDto = new AccessDTO(token);

            return accessDto;
        } catch (BadCredentialsException e) {

        }
        return new AccessDTO("Acesso negado");
    }
}
