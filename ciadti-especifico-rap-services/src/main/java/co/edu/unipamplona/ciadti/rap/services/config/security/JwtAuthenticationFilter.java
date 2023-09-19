package co.edu.unipamplona.ciadti.rap.services.config.security;

import co.edu.unipamplona.ciadti.rap.services.config.security.register.RegisterContext;
import co.edu.unipamplona.ciadti.rap.services.model.common.dto.AccionDTO;
import co.edu.unipamplona.ciadti.rap.services.util.constant.Metadata;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @NotNull HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull FilterChain filterChain
    ) throws ServletException, IOException {
        final String authHeader = request.getHeader(Metadata.AUTHORIZATION);
        final String jwt;

        if (authHeader == null || !authHeader.startsWith(Metadata.BEARER + " ")) {
            jwt = request.getParameter("token");
            if ( jwt != null){
                this.procesar(request, jwt);
            }
            filterChain.doFilter(request, response);
            return;
        }
        jwt = authHeader.substring(7);
        this.procesar(request, jwt);
        filterChain.doFilter(request, response);
    }

    private void procesar(HttpServletRequest request, String jwt){
        final String username;
        username = jwtService.extractUsername(jwt);
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            if (jwtService.isTokenValid(jwt, userDetails)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);

                //Sección aprovechada para obtener toda información de quien ejecuta la acción a través del token
                AccionDTO accionDTO = jwtService.extractAccionDTO(jwt);
                RegisterContext.setAccionDTO(accionDTO);
            }
        }
    }
}
