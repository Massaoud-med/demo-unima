package com.unimagec.security.services;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unimagec.models.User;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String email;

	@JsonIgnore
	private String password;
	
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
	
	private Collection<? extends GrantedAuthority> authorities;


	public UserDetailsImpl(Long id, String username, String email, String password, String nom, String prenom,
			String adress, String cin, Date dateNaissanace, String lieuNaissanace, String tele, String niveauEtude,
			Date dateEntrer, Date dateSortir, String typeService, String situation, String sexe,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
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
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getId(), 
				user.getUsername(), 
				user.getEmail(),
				user.getPassword(),
				user.getNom(),
				user.getPrenom(),
				user.getAdress(),
				user.getCin(),
				user.getDateNaissanace(),
				user.getLieuNaissance(),
				user.getTele(),
				user.getNiveauEtude(),
				user.getDateEntrer(),
				user.getDateSortir(),
				user.getTypeService(),
				user.getSituation(),
				user.getSexe(),
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}
