package com.example.board.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.board.domain.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsImpl implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private User user;
	
	public UserDetailsImpl(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> roleList = new ArrayList<>();
		roleList.add(new GrantedAuthority() {	
			@Override
			public String getAuthority() {
				return "ROLE_" + user.getRole();
			}
		}); // roleList.add(() -> "ROLE_" + user.getRole()); 이렇게 간단히 줄일 수도 있긴 함...
		return roleList;
	}

	@Override
	public String getPassword() {
//		return "{noop}" + user.getPassword();
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

//	public String getEmail() { // 추가적으로 만들고 싶은 거 있으면 만들면 됨 근데 걍 user있고 getter 있는데 몰...ㅋㅋㅋ
//		return user.getEmail();
//	}

	@Override
	public boolean isAccountNonExpired() {
		// 만료 여부를 알려주는 메서드, 만료 안 됐으면 true
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// 잠긴 계정이 아닌지 알려주는 메서드, 임시 계정 잠금 등등 
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// 비밀번호 만료 여부
		return true;
	}

	@Override
	public boolean isEnabled() {
		// 계정이 활성화되어 있는지, 휴먼계정인지 아닌지
		return true;
	}

}
