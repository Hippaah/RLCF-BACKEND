package com.rlcf.spring.services;



import com.rlcf.spring.dto.AccountDTO;
import com.rlcf.spring.dto.AuthenticationDTO;
import com.rlcf.spring.dto.JwtDTO;
import com.rlcf.spring.models.Account;

import java.util.List;
import java.util.Optional;

/**
 * 
 * @author EL KOTB ZAKARIA
 *
 */
public interface AccountService {

	Optional<Account> findByLogin(String login);

	JwtDTO authenticateUser(AuthenticationDTO authenticationDTO) throws Exception;

	List<AccountDTO> getAccounts();

	String getConnectedUser();
    void createAccount(Account account);
	void createRole(Role role);

}
