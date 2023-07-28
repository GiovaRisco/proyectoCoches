package com.project.coches.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.project.coches.domain.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;


/**
 * Clase encargada de la creacion y validacion de jwt para el inicio de sesion de un Usuario
 */
@Component
public class JwtAuthenticationProvider {

    /**
     * Llave para cifrar el jwt
     */
    @Value("${jwt.secret.key}")
    private String secretKey;


    /**
     * Lista blanca con los jwt creados
     */
    private HashMap<String , CustomerDto>listToken = new HashMap<>();


    /**
     * Crea un nuevo jwt en base al cliente recibido por parametro y lo agrega a la lista blanca
     * customerJwt Cliente a utilizar en la creacion del jwt
     *  Jwt creado
     */
    public String createToken(CustomerDto customerjwt){

        Date now = new Date();
        Date validaty  = new Date(now.getTime() + 3600000); //1 hora en milisegundos

        Algorithm algorithm =Algorithm.HMAC256(secretKey);

        String tokenCreated = JWT.create()
                .withClaim("cardId",customerjwt.getCardId())
                .withClaim("fullname",customerjwt.getFullName())
                .withClaim("numberCellPhone",customerjwt.getNumberCellphone())
                .withClaim("email",customerjwt.getEmail())
                .withClaim("rol",customerjwt.getRol())
                .withIssuedAt(now)
                .withExpiresAt(validaty)
                .sign(algorithm);

        listToken.put(tokenCreated,customerjwt);
        return  tokenCreated;
    }


    /**
     * Valida si el token es valido y retorna una sesión del usuario
     *  token Token a validar
     *  retorna Sesion del usuario
     *  CredentialsExpiredException Si el token ya expiró
     *  BadCredentialsException Si el token no existe en la lista blanca
     */

    public Authentication validateToken(String token) throws AuthenticationException{
        System.out.println("entre tambien aqui");
        System.out.println(token);

        //verifica el token como su firma y expiración, lanza una excepcion si algo falla
        JWT.require(Algorithm.HMAC256(secretKey)).build().verify(token);

        CustomerDto exist = listToken.get(token);
        if(exist == null){
            throw new BadCredentialsException("Usuario no registrado");
        }

        //Lor Roles son en si autoridades
        HashSet<SimpleGrantedAuthority> rolesAndAuthorities = new HashSet<>();
        rolesAndAuthorities.add(new SimpleGrantedAuthority("ROLE_" + exist.getRol()));//Rol
        rolesAndAuthorities.add(new SimpleGrantedAuthority("COMPRAR_PRIVILEGE"));

        return new UsernamePasswordAuthenticationToken(exist,token,rolesAndAuthorities);
    }

    public String deleteToken(String jwt){
        if(!listToken.containsKey(jwt)){
            return  "No existe el token";
        }

        listToken.remove(jwt);
        return  "Cesion cerrada correctamente";
    }

}
