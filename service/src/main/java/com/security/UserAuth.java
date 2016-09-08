package com.security;


import facade.api.IUserFacade;
import model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class UserAuth  implements UserDetailsService {
    @Autowired
    private IUserFacade userFacade;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        model.User user = userFacade.findByUserName(username);
        if(user!=null) {
            List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());

            return buildUserForAuthentication(user, authorities);
        }
        return null;
    }

    private User buildUserForAuthentication(model.User user, List<GrantedAuthority> authorities) {

        return new CustomUserDetails(user.getId(), user.getUsername(), user.getPassword(), authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<Role> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (Role userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getName()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }



    public IUserFacade getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(IUserFacade userFacade) {
        this.userFacade = userFacade;
    }


}
