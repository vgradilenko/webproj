package com.andersen.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    @Column(name="userid")
    private Long userId;

	@Column(name = "username")
    private String userName;   

	@Column(name = "password")
    private String password;   

	@Column(name = "email")
    private String email;
    
	@Column(name ="enabled")
	private int enabled;

	public User(User user) {
		this.userId = user.userId;
		this.userName = user.userName;
		this.email = user.email;
		this.password = user.password;
		this.enabled=user.enabled;
	}
}