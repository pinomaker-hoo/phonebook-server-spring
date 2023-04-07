package pinomaker.phonebook.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pinomaker.phonebook.domain.User;
import pinomaker.phonebook.repoistory.UserJpaRepository;

import java.util.*;
import java.util.stream.Collectors;

@Component("userDetailsService")
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserJpaRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return userRepository.findUserById(username).map(this::createUserDetails).orElseThrow(() -> new UsernameNotFoundException(username + " -> 데이터베이스에서 찾을 수 없습니다."));
    }

    private UserDetails createUserDetails(User user) {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getAuthority().toString());
        return new org.springframework.security.core.userdetails.User(String.valueOf(user.getIdx()), user.getPassword(), Collections.singleton(grantedAuthority));
    }

    private Collection<? extends GrantedAuthority> convertToSpringAuthorities(Optional<User> optUserAccount) {
        Set<String> permissions = new HashSet<>();
        User userAccount = new User();
        if (optUserAccount.isPresent()) {
            userAccount = optUserAccount.get();
        }

        return permissions.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
    }
}