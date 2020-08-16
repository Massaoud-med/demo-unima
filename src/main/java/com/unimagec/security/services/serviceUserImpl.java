package com.unimagec.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unimagec.Exception.ResourceNotFoundException;
import com.unimagec.models.User;
import com.unimagec.repository.UserRepository;



@Service
public class serviceUserImpl  implements serviceUser{
	
	@Autowired
	private UserRepository repositoryUser;

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return repositoryUser.save(user);
	}

	@Override
	public User updateUser(User user) {

		Optional<User> UtilisateurDB = this.repositoryUser.findById(user.getId());

		if (UtilisateurDB.isPresent()) {

			User utitlisateurUpdate = UtilisateurDB.get();
			utitlisateurUpdate.setId(user.getId());
			utitlisateurUpdate.setUsername(user.getUsername());
			utitlisateurUpdate.setEmail(user.getEmail());
			utitlisateurUpdate.setPassword(user.getPassword());
			utitlisateurUpdate.setNom(user.getNom());
			utitlisateurUpdate.setPrenom(user.getPrenom());
			utitlisateurUpdate.setAdress(user.getAdress());
			utitlisateurUpdate.setCin(user.getCin());
			utitlisateurUpdate.setDateNaissance(user.getDateNaissanace());
			utitlisateurUpdate.setLieuNaissance(user.getLieuNaissance());
			utitlisateurUpdate.setNiveauEtude(user.getNiveauEtude());
			utitlisateurUpdate.setDateEntrer(user.getDateEntrer());
			utitlisateurUpdate.setDateSortir(user.getDateSortir());
			utitlisateurUpdate.setTypeService(user.getTypeService());
			utitlisateurUpdate.setSituation(user.getSituation());
			utitlisateurUpdate.setSexe(user.getSexe());

			
			return utitlisateurUpdate;
		} else {
			throw new ResourceNotFoundException("Enregistrement introuvable avec id : " + user.getId());
		}
	}

	@Override
	public List<User> getAllUser() {

		return repositoryUser.findAll();
	}

	@Override
	public User getUserById(long userId) {
		// TODO Auto-generated method stub
		Optional<User> utilisateur = this.repositoryUser.findById(userId);

		if (utilisateur.isPresent()) {
			return utilisateur.get();
		} else {
			throw new ResourceNotFoundException("Enregistrement introuvable avec l'identifiant : " + userId);
		}
	}
	

	@Override
	public void deleteUser(long userId) {


		Optional<User> utilisateur = this.repositoryUser.findById(userId);

		if (utilisateur.isPresent()) {
			this.repositoryUser.deleteById(userId);
		} else {
			throw new ResourceNotFoundException("Enregistrement introuvable avec l'identifiant : " + userId);
		}

		
	}

	
	
	

}
