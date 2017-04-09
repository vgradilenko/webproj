package com.andersen.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.andersen.domain.User;

public class CustomUserDetails extends User implements UserDetails {
	
	private List<String> userRoles;
	

	public CustomUserDetails(User user,List<String> userRoles){
		super(user);
		this.userRoles=userRoles;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		String roles=StringUtils.collectionToCommaDelimitedString(userRoles);			
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}


	@Override
	public String getUsername() {
		return super.getUserName();
	}


}
