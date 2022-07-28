package com.rlcf.spring.services.ServiceImpl;


import com.rlcf.spring.configuration.security.JWTProvider;
import com.rlcf.spring.dto.AccountDTO;
import com.rlcf.spring.dto.AuthenticationDTO;
import com.rlcf.spring.dto.JwtDTO;
import com.rlcf.spring.models.Account;
import com.rlcf.spring.models.Role;
import com.rlcf.spring.repository.AccountRepository;
import com.rlcf.spring.repository.RoleRepository;
import com.rlcf.spring.services.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 
 * @author EL KOTB ZAKARIA
 *
 */
@Service
@Transactional
public class AccountImplService implements AccountService {

		
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AuthenticationManager authenticationManger;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Value("${security.jwt.secret}")
	private String secret;

	@Value("${security.jwt.expiration.time}")
	private long expirationTime;

	@Value("${default.role}")
	private String defaultRole;


	@Override
	public Optional<Account> findByLogin(String login) {
		return this.accountRepository.findByLogin(login);
	}

	@Override
	public List<AccountDTO> getAccounts() {
		return this.accountRepository.findAll().stream().map(account -> this.modelMapper.map(account, AccountDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public JwtDTO authenticateUser(AuthenticationDTO authenticationDTO) {
		this.authenticationManger.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationDTO.getLogin(), authenticationDTO.getPassword()));
		Account account = this.findByLogin(authenticationDTO.getLogin()).orElse(null);
		String jwt = JWTProvider.generateJWT(authenticationDTO.getLogin(),
				((account != null) && (account.getRole() != null)) ? String.valueOf(account.getRole().getRole()) : this.defaultRole,
				this.secret, this.expirationTime);
		JwtDTO jwtDTO = new JwtDTO();
		jwtDTO.setJwt(jwt);
		return jwtDTO;
	}
	@Override
	public String getConnectedUser() {
		String email=(String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return email;
	}

	@Override
	public void createAccount(Account account) {
		String cryptedPwd = bCryptPasswordEncoder.encode(account.getPassword());
		account.setPassword(cryptedPwd);
		accountRepository.save(account);
	}

	@Override
	public void createRole(Role role) {
	 roleRepository.save(role);
	}
}
