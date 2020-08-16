package com.unimagec.payload.response;

import java.util.Date;
import java.util.List;

public class JwtResponse {
	
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	//////////////////////////////
	private String nom;
	private String prenom;
	private String adress;
	private String cin ;
	private Date    dateNaissanace ;
	private String lieuNaissanace ;
	private String tele;
	private String niveauEtude;
	private Date dateEntrer;
	private Date dateSortir;
	private String typeService;
	private String situation ;
	private String sexe ;
	////////////////////////////////
	
	private List<String> roles;

	public JwtResponse(String accessToken, Long id, String username, String email,String nom, String prenom,
			String adress, String cin, Date dateNaissanace, String lieuNaissanace, String tele, String niveauEtude,
			Date dateEntrer, Date dateSortir, String typeService, String situation, String sexe, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.adress = adress;
		this.cin = cin;
		this.dateNaissanace = dateNaissanace;
		this.lieuNaissanace = lieuNaissanace;
		this.tele = tele;
		this.niveauEtude = niveauEtude;
		this.dateEntrer = dateEntrer;
		this.dateSortir = dateSortir;
		this.typeService = typeService;
		this.situation = situation;
		this.sexe = sexe;
		this.roles = roles;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public Date getDateNaissanace() {
		return dateNaissanace;
	}

	public void setDateNaissanace(Date dateNaissanace) {
		this.dateNaissanace = dateNaissanace;
	}

	public String getLieuNaissanace() {
		return lieuNaissanace;
	}

	public void setLieuNaissanace(String lieuNaissanace) {
		this.lieuNaissanace = lieuNaissanace;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getNiveauEtude() {
		return niveauEtude;
	}

	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}

	public Date getDateEntrer() {
		return dateEntrer;
	}

	public void setDateEntrer(Date dateEntrer) {
		this.dateEntrer = dateEntrer;
	}

	public Date getDateSortir() {
		return dateSortir;
	}

	public void setDateSortir(Date dateSortir) {
		this.dateSortir = dateSortir;
	}

	public String getTypeService() {
		return typeService;
	}

	public void setTypeService(String typeService) {
		this.typeService = typeService;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}
}
