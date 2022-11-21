package com.flofyhome.FLOFYHOME.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flofyhome.FLOFYHOME.configuration.JwtUtils;
import com.flofyhome.FLOFYHOME.implement.UserDetailsServiceDao;
import com.flofyhome.FLOFYHOME.model.JwtRequest;
import com.flofyhome.FLOFYHOME.model.JwtResponse;
import com.flofyhome.FLOFYHOME.model.User;

import java.security.Principal;



@RestController
@CrossOrigin("*")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceDao userDetailsServiceDao;

	@Autowired
	private JwtUtils jwtUtils;

	@PostMapping("/generate-token")
	public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		try {
			autenticar(jwtRequest.getUsername(), jwtRequest.getPassword());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new Exception("USUARIO NO ENCONTRADO");
		}

		UserDetails userDetails = this.userDetailsServiceDao.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));

	}

	private void autenticar(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException disabledException) {
			throw new Exception("USUARIO DESHABILITADO " + disabledException.getMessage());
		} catch (BadCredentialsException badCredentialsException) {
			throw new Exception("CREDENCIALES INVALIDAS " + badCredentialsException.getMessage());
		}
	}
	
	@GetMapping("/actual-usuario")
    public User obtenerUsuarioActual(Principal principal){
        return (User) this.userDetailsServiceDao.loadUserByUsername(principal.getName());
	}
	
	
}
