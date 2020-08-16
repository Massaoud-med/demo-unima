package com.unimagec.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unimagec.models.ERole;
import com.unimagec.models.Role;
import com.unimagec.models.User;
import com.unimagec.payload.request.LoginRequest;
import com.unimagec.payload.request.SignupRequest;
import com.unimagec.payload.response.JwtResponse;
import com.unimagec.payload.response.MessageResponse;
import com.unimagec.repository.RoleRepository;
import com.unimagec.repository.UserRepository;
import com.unimagec.security.jwt.JwtUtils;
import com.unimagec.security.services.UserDetailsImpl;



@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
				 userDetails.getId(), 
				 userDetails.getUsername(), 
				 userDetails.getEmail(),
				 userDetails.getNom(),
				 userDetails.getPrenom(),
				 userDetails.getAdress(),
				 userDetails.getCin(),
				 userDetails.getDateNaissanace(),
				 userDetails.getLieuNaissanace(),
				 userDetails.getTele(),
				 userDetails.getNiveauEtude(),
				 userDetails.getDateEntrer(),
				 userDetails.getDateSortir(),
				 userDetails.getTypeService(),
				 userDetails.getSituation(),
				 userDetails.getSexe(),
				 roles));	
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		/*if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
*/
		// Create new user's account
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()),
							 signUpRequest.getNom(),
							 signUpRequest.getPrenom(),
							 signUpRequest.getAdress(),
							 signUpRequest.getCin(),
							 signUpRequest.getDateNaissanace(),
							 signUpRequest.getLieuNaissanace(),
							 signUpRequest.getTele(),
							 signUpRequest.getNiveauEtude(),
							 signUpRequest.getDateEntrer(),
							 signUpRequest.getDateSortir(),
							 signUpRequest.getTypeService(),
							 signUpRequest.getSituation(),
							 signUpRequest.getSexe(),
							 signUpRequest.getRolee()	 
				);

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				case "user":
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		//userRepository.save(user);

		return ResponseEntity.ok(userRepository.save(user));
	}
}
