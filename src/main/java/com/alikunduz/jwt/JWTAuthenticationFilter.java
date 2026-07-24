package com.alikunduz.jwt;

import com.alikunduz.exception.BaseExcepiton;
import com.alikunduz.exception.ErrorMessage;
import com.alikunduz.exception.MessageType;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component                           //servislerin süzüleceği katman
public class JWTAuthenticationFilter extends OncePerRequestFilter {


    @Autowired
    private JWTService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");
        if(header==null){
            filterChain.doFilter(request,response);
            return;
        }

        String token;
        String userName;

        //bearer Aaaaa  --->   Aaaa= token diyelim bu metodu kullandığımızda 7.indexten başlıyacak
        token=header.substring(7);                            //yani bearer ve aradaki boşluk gözükmeyecek
        try {
          userName = jwtService.getUsernameByToken(token);
          if (userName!=null && SecurityContextHolder.getContext().getAuthentication()==null){
              UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
              if (userDetails!=null && jwtService.isTokenValid(token)){
                  UsernamePasswordAuthenticationToken authenticationToken = new
                          UsernamePasswordAuthenticationToken(userName, null,userDetails.getAuthorities());

                  authenticationToken.setDetails(userDetails);
                  SecurityContextHolder.getContext().setAuthentication(authenticationToken);
              }

          }
        }
        catch (ExpiredJwtException ex){
            throw new BaseExcepiton(new ErrorMessage(MessageType.TOKEN_IS_EXPIRED,ex.getMessage()));
        }
        catch (Exception e){
            throw new BaseExcepiton(new ErrorMessage(MessageType.GENERAL_EXCEPTION,e.getMessage()));
        }

    }
}
