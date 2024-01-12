package com.practice.BarbecueManagementTool.services;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
//import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.practice.BarbecueManagementTool.models.ApplicationUser;

/**
 * Service class for Token
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
@Service
public class TokenService {

	@Autowired
	private JwtEncoder jwtEncoder;

	public String generateJwt(Authentication auth) {

		Instant now = Instant.now();

		String scope = auth.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(" "));

		JwtClaimsSet claims = JwtClaimsSet.builder().issuer("self").issuedAt(now).subject(auth.getName())
				.claim("roles", scope).claim("userId", ((ApplicationUser)auth.getPrincipal()).getUserId()).build();

		return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
	}

}
