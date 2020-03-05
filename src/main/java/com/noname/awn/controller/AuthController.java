package com.noname.awn.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noname.awn.enums.ERole;
import com.noname.awn.model.Roles;
import com.noname.awn.model.Users;
import com.noname.awn.payload.request.LoginRequest;
import com.noname.awn.payload.request.SignupRequest;
import com.noname.awn.payload.response.JwtResponse;
import com.noname.awn.payload.response.MessageResponse;
import com.noname.awn.repository.RolesRepository;
import com.noname.awn.repository.UsersRepository;
import com.noname.awn.security.jwt.JwtUtils;
import com.noname.awn.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private RolesRepository roleRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private JwtUtils jwtUtils;

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
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		System.out.println("Toi day ko");
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		
		System.out.print("Toi day ko");

		// Create new user's account
		Users user = new Users();

		Set<String> strRoles = signUpRequest.getRoles();
		Set<Roles> roles = new HashSet<>();

		if (strRoles == null) {
			Roles userRole = roleRepository.findByName(ERole.PERSON)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "operator":
					Roles operatorRole = roleRepository.findByName(ERole.OPERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(operatorRole);
					break;
				case "company":
					Roles companyRole = roleRepository.findByName(ERole.COMPANY)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(companyRole);
					break;
				case "administrator":
					Roles administratorRole = roleRepository.findByName(ERole.ADMINISTRATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(administratorRole);

					break;
				default:
					Roles userRole = roleRepository.findByName(ERole.PERSON)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.set_id(ObjectId.get());
		user.setUsername(signUpRequest.getUsername());
		user.setEmail(signUpRequest.getEmail());
		user.setPassword(encoder.encode(signUpRequest.getPassword()));
		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	@GetMapping("/{id}")
	public Users getUsers(@PathVariable("id") ObjectId id) {
		return userRepository.findBy_id(id);
	}
}
