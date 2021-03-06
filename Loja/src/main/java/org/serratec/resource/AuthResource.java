package org.serratec.resource;
import org.serratec.exceptions.ClienteException;
import org.serratec.model.Cliente;
import org.serratec.repository.ClienteRepository;
import org.serratec.dto.LoginDTO;
import org.serratec.dto.TokenDTO;
import org.serratec.exceptions.ClienteException;
import org.serratec.model.Cliente;
import org.serratec.repository.ClienteRepository;
import org.serratec.security.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("API para login de usuários na loja")
@RestController
public class AuthResource {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@ApiOperation(value = "Envio de Usuário e Senha para Login")
	@PostMapping("/auth")
	public ResponseEntity<?> auth(@RequestBody @Validated LoginDTO loginDTO) throws ClienteException{
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getUser(), loginDTO.getPass());
		
		Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		
		String token = tokenService.generateToken(authentication);		
		
		TokenDTO tokenDTO = new TokenDTO();
		tokenDTO.setToken(token);
		tokenDTO.setType("Bearer");
		
		Cliente cliente = clienteRepository.findByUsuarioIgnoreCase(loginDTO.getUser())
				.orElseThrow(() -> new ClienteException("Cliente não cadastrado"));
		tokenDTO.setIdCliente(cliente.getId());
		tokenDTO.setUser(cliente.getUsername());
		tokenDTO.setNome(cliente.getNome());
		
		return new ResponseEntity<>(tokenDTO, HttpStatus.OK);		
	}
}