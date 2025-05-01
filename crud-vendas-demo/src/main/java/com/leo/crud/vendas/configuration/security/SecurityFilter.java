package com.leo.crud.vendas.configuration.security;

import com.leo.crud.vendas.entities.Role;
import com.leo.crud.vendas.repositories.UserRepository;
import com.leo.crud.vendas.service.GeneratedHash;
import com.leo.crud.vendas.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.util.LimitedInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.leo.crud.vendas.entities.Role;

import java.io.IOException;
import java.util.List;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    GeneratedHash generatedHash;

    @Autowired
    UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try{

            String token = recoverToken(request);

            if(token != null){
                String subject = generatedHash.verifyToken(token);

                UserDetails userDetails = userService.loadUserByUsername(subject);

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(subject, null, userDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            filterChain.doFilter(request, response);

        } catch (UsernameNotFoundException ex) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("Usuário não encontrado");
            response.getWriter().flush();
        }
    }

    private String recoverToken(HttpServletRequest request){
        String authReader = request.getHeader("Authorization");

        if(authReader == null) return null;

        return authReader.replace("Bearer ", "");
    }
}
