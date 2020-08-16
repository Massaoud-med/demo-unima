package com.unimagec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unimagec.models.User;
import com.unimagec.security.services.serviceUserImpl;



@RestController
//CrossOriginest est un mécanisme qui permet partage de ressources entre origines multiples.
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private serviceUserImpl  utitlisateuryServices;
	
	@GetMapping("/utilisateur")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<List<User>> getAllUtilisateurs() {
		return ResponseEntity.ok().body(utitlisateuryServices.getAllUser());
  }
	
  @GetMapping("/utilisateur/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<User> getUtilisateurById(@PathVariable("id") long utilisateurId) {
		return ResponseEntity.ok().body(utitlisateuryServices.getUserById(utilisateurId));
	}

  @PostMapping("/utilisateur")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public ResponseEntity<User> createUtilisateur(@RequestBody User utilisateur) {
		return ResponseEntity.ok().body(this.utitlisateuryServices.createUser(utilisateur));
  }

	@PutMapping("/utilisateur/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public ResponseEntity<User> updateUtilisateur(@PathVariable("id") long idUser,
			@RequestBody User utilisateur) {
		utilisateur.setId(idUser);
		return ResponseEntity.ok().body(this.utitlisateuryServices.updateUser(utilisateur));
	}
	
  @DeleteMapping("/utilisateur/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
  public String deleteUtilisateur(@PathVariable("id") long utilisateurId) {
		this.utitlisateuryServices.deleteUser(utilisateurId);

		return "OK";
      }
}
