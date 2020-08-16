package com.unimagec.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "email") 
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Size(max = 20)
	private String username;


	@Size(max = 50)
	@Email
	private String email;


	@Size(max = 120)
	private String password;
	
	@Column(name = "Nom")
	private String nom;
	@Column(name = "Prenom")
	private String prenom;
	@Column(name = "Adresse")
	private String adress;
	@Column(name = "CIN")
	private String cin ;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "Date_Naissanace")
	private Date dateNaissance ;
	@Column(name = "Lieu_Naissance")
	private String lieuNaissance ;
	@Column(name = "Tele_stagiaire")
	private String tele;
	@Column(name = "Niveau_Etude")
	private String niveauEtude;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "Date_entrer")
	private Date dateEntrer;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "Date_Sortir")
	private Date dateSortir;
	@Column(name = "Typeservice")
	private String typeService;
	@Column(name = "Stuation_familiale")
	private String situation ;
	@Column(name = "Sexe")
	private String sexe ;
	@Column(name = "Rolee")
	private String rolee ;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User() {
	}



	public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, String nom, String prenom, String adress, String cin,
			Date dateNaissance, String lieuNaissance, String tele, String niveauEtude, Date dateEntrer,
			Date dateSortir, String typeService, String situation, String sexe, String rolee) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.adress = adress;
		this.cin = cin;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.tele = tele;
		this.niveauEtude = niveauEtude;
		this.dateEntrer = dateEntrer;
		this.dateSortir = dateSortir;
		this.typeService = typeService;
		this.situation = situation;
		this.sexe = sexe;
		this.rolee = rolee;
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
		return dateNaissance;
	}



	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}



	public String getLieuNaissance() {
		return lieuNaissance;
	}



	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
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



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public String getRolee() {
		return rolee;
	}



	public void setRolee(String rolee) {
		this.rolee = rolee;
	}
}
