package com.rlcf.spring.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

/**
 *
 * @author CHICHI Hamza
 *
 */
@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private ERole role;

	@Column
	@Enumerated(EnumType.STRING)
	private ERole rolee;

//	@Override
//	public String toString() {
//		StringBuilder student = new StringBuilder("{role : ");
//		return student.append(this.role).append(" }").toString();
//	}

	public Role(ERole role){
		this.role = role;
	};



}
