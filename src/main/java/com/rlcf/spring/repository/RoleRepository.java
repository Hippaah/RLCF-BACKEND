package com.rlcf.spring.repository;


import com.rlcf.spring.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 
 * @author CHICHI Hamza
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByRole(String role);
}
