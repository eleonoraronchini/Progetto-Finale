package ProgettoFInale.controller;

import ProgettoFInale.model.Utente;
import ProgettoFInale.model.enumerations.APIStatus;
import ProgettoFInale.payload.APIResponse;
import ProgettoFInale.payload.LoginDTO;
import ProgettoFInale.payload.TokenDTO;
import ProgettoFInale.payload.UtenteDTO;
import ProgettoFInale.service.UtenteService;
import ProgettoFInale.utils.JWTTools;
import org.apache.tomcat.Jar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utente")
public class UtenteController {
    @Autowired
    UtenteService utenteService;
    @Autowired JWTTools jwtTools;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public APIResponse<TokenDTO> login(@RequestBody @Validated LoginDTO loginDTO, BindingResult validation) {
        if (validation.hasErrors())
            throw new RuntimeException(validation.getAllErrors().stream().map(err -> err.getDefaultMessage()).toString());

        //validare l'email --> email presente nel db
        Utente utenteTrovato = this.utenteService.findByEmail(loginDTO.email());

        //validare la password --> verificare se la password è quella del database
        if (utenteTrovato.getPassword().equals(loginDTO.password())) {
            //ritorna un token
            return new APIResponse<TokenDTO>(APIStatus.SUCCESS, new TokenDTO(jwtTools.createToken(loginDTO.email(), null)));
        } else {
            throw new RuntimeException("password non valida");
        }

    }
    @GetMapping("/utente")
    @ResponseStatus(HttpStatus.OK)
    public Utente getUtente (@AuthenticationPrincipal Utente utente ){
        return utente;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public APIResponse<String> createUtente(@RequestBody @Validated UtenteDTO utenteDTO) {
        utenteService.createUtente(utenteDTO);
        return new APIResponse<>(APIStatus.SUCCESS, "Utente aggiunto con successo!");
    }
    }

