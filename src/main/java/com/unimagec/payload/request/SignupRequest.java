package com.unimagec.payload.request;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

 
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
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
    private String rolee;
    
    
    public String getRolee() {
		return rolee;
	}

	public void setRolee(String rolee) {
		this.rolee = rolee;
	}

	private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
  
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
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
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
    
    
}
