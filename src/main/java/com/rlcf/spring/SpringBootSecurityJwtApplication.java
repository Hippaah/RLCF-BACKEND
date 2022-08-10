package com.rlcf.spring;

import com.rlcf.spring.models.Account;
import com.rlcf.spring.models.ERole;
import com.rlcf.spring.models.Role;
import com.rlcf.spring.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringBootSecurityJwtApplication implements CommandLineRunner {
	@Autowired
	AccountService accountService;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
      accountService.createAccount(new Account("testrw","testpass", new Role(ERole.ROLE_RW)));
	    accountService.createAccount(new Account("testro","testpass",new Role(ERole.ROLE_RO)));
      accountService.createAccount(new Account("testadmin","testpass", new Role(ERole.ROLE_ADMIN)));

	}
}


