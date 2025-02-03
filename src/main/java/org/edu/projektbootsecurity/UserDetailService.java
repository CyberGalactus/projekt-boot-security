package org.edu.projektbootsecurity;

import org.edu.projektbootsecurity.Model.ApplicationsUser;
import org.edu.projektbootsecurity.Repository.ApplicationsUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailService implements org.springframework.security.core.userdetails.UserDetailsService{

    private final ApplicationsUserRepository applicationsUserRepository;

    //kontruktor
    public UserDetailService(ApplicationsUserRepository applicationsUserRepository) {
        this.applicationsUserRepository = applicationsUserRepository;
    }


    @Override
    //Om användaren inte hittas kastas ett UsernameNotFoundException
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        ApplicationsUser applicationsUser = applicationsUserRepository.findByUsername(username);
        //Hämta användaren


        //Om ingen användare hittas kastas ett UsernameNotFoundException
        //skapas en lista med behörigheter för användare
        if (applicationsUser == null) {
            throw new UsernameNotFoundException("user not found");
        }
        List<GrantedAuthority> authorities = List.of(
                new SimpleGrantedAuthority("ROLE_" + applicationsUser.getRole())
        );

        return new org.springframework.security.core.userdetails.User(
                applicationsUser.getUsername(),
                applicationsUser.getPassword(),
                true, // enabled
                true, // accountNonExpired
                true, // credentialsNonExpired
                true, // accountNonLocked
                authorities
        );
    }
}
