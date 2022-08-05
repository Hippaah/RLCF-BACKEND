package com.rlcf.spring.controllers;

import com.rlcf.spring.dto.AccountDTO;
import com.rlcf.spring.dto.AuthenticationDTO;
import com.rlcf.spring.dto.JwtDTO;
import com.rlcf.spring.repository.AccountRepository;
import com.rlcf.spring.services.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rlcf/api/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountRepository rep;


	@PostMapping("/login")
	public JwtDTO authenticate(@RequestBody AuthenticationDTO authenticationDTO) throws Exception {
		return this.accountService.authenticateUser(authenticationDTO);
	}


	/*@PutMapping("/{id}")
	@Operation(security = { @SecurityRequirement(name = "Bearer Token") })
	public Account updateAccount(@PathVariable Long id, @Valid @RequestBody Account authenticationDTO)
			throws Exception {
		authenticationDTO.setId(id);
		return this.rep.save(authenticationDTO);
	}*/

	@GetMapping()
	@PreAuthorize("hasAuthority('DISPATCHER')")
	@Operation(security = { @SecurityRequirement(name = "Bearer Token") })
	public List<AccountDTO> getAccounts() {
		return this.accountService.getAccounts();
	}
}
