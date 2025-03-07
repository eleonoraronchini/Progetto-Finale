package ProgettoFInale.configuration;

import ProgettoFInale.model.Utente;
import ProgettoFInale.service.UtenteService;
import ProgettoFInale.utils.JWTTools;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {
    @Autowired
    JWTTools jwtTools;
    @Autowired
    UtenteService utenteService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        // Escludi il filtro per l'endpoint di registrazione
        if (requestURI.contains("/utente/register") || requestURI.contains("/utente/login")) {
            // Non fare nulla, lascia che il filtro passi senza alcuna logica di autenticazione
            filterChain.doFilter(request, response);
            return;
        }
        String token = request.getHeader("Authorization");
        //controllo che il token ci sia
        if (token != null && token.startsWith("Bearer ")){
            //se si, decode token --> email dell'utente loggato, cerco utente sul db e imposto AuthenticationPrincipal
          String email = jwtTools.decodeToken(token.substring(7));
           Utente utente = utenteService.findByEmail(email);
           UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(utente,null,utente.getAuthorities());
           SecurityContextHolder.getContext().setAuthentication(auth);
           filterChain.doFilter(request,response);
        } else throw  new RuntimeException("Perfavore fornisci un token valido!");




    }
}
