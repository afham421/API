package com.firsttask.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private CostomUserDetail userDetailsService;
    @Autowired
    private JwtTokenHelper jwtTokenHelper;



    @Override
    protected void doFilterInternal(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.FilterChain filterChain) throws javax.servlet.ServletException, IOException {
        // get token
        String requestToken = request.getHeader("Authorization");

        // get detail // Bearer 6564357

        String username = null;
        String token = null;

        if (requestToken != null && requestToken.startsWith("Bearer")){

            token = requestToken.substring(7);
            try {
                username = this.jwtTokenHelper.getUsernameFromToken(token);
            }catch (IllegalArgumentException e){
                System.out.println("unable to get jwt token!!!!!!");
            }catch (ExpiredJwtException e){
                System.out.println("jwt token expired!!!!!!!");
            }catch (MalformedJwtException e){
                System.out.println("invalid jwt exception!!!!");
            }

        }else {
            System.out.println(" is null!!!! or not begin with bearer!!!");
        }
// once we get the token , now we will validate

        if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            if (this.jwtTokenHelper.validToken(token,userDetails)){
                //sahi chal rha hy // Authenticatiion kerna hy
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails((javax.servlet.http.HttpServletRequest) request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }else {
                System.out.println("invalid jwt token or detail!!!!");
            }
        }else {
            System.out.println("username is null or security context is not null!!!!");
        }


        filterChain.doFilter(request,response);

    }
}
