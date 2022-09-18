package app.core.auth;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Demo1 {

	public static void main(String[] args) {
		
		// get a JWT Builder
		
		// generate key for signng the token
		
		// part 1 - secret
		String secret = "a".repeat(43);
//		byte[] secretBytes = secret.getBytes();
		System.out.println("secret = "+secret);
//		System.out.println("secretBytes = "+Arrays.toString(secretBytes));
		
		byte[] secretBytesDecoted = Base64.getDecoder().decode(secret);
		System.out.println("secretBytesDecoted = "+Arrays.toString(secretBytesDecoted));
		
		// part 2
		String JcaName = SignatureAlgorithm.HS256.getJcaName();
		System.out.println("Algorithm = "+JcaName);
		
		// part 3
		Key key = new SecretKeySpec(secretBytesDecoted,JcaName);
		
		
		Instant now = Instant.now();
		Instant exp = now.plus(5, ChronoUnit.MINUTES);
		
		JwtBuilder builder = Jwts.builder();
		//String token = builder.compact();
		String token = builder
				.setSubject("ariel@gmail")
				.setIssuedAt(Date.from(now))
				.setExpiration(Date.from(exp))
				.claim("name", "ariel")
				.claim("lastName", "stollman")
				.signWith(key)
				.compact();
		System.out.print(token);
		System.out.println();
		
		// parsing 
		JwtParser parser = Jwts.parserBuilder().setSigningKey(key).build();
		Jws<Claims> jwt = parser.parseClaimsJws(token);
		
		System.out.println("jwt = "+jwt);


	}

}
