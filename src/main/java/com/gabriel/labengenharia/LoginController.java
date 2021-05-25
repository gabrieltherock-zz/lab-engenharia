package com.gabriel.labengenharia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailServiceImpl usuarioService;

    @Autowired
    JwtUtil jwtUtil;

    @RequestMapping(
            value = "/login", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody UsuarioCredenciais usuarioCredenciais) throws Exception {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuarioCredenciais.getUsuario(),
                        usuarioCredenciais.getSenha())
        );
        final UserDetails userDetails = usuarioService
                .loadUserByUsername(usuarioCredenciais.getUsuario());
        final String token = jwtUtil.generateToken(userDetails);
        return "{\"token\":\"" + token + "\"}";
    }
}
