package com.unimagec.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unimagec.Exception.ResourceNotFoundException;
import com.unimagec.models.Mission;
import com.unimagec.repository.MissionRepository;



@Service
public class serviceMissionImpl  implements serviceMission{

	@Autowired
	private MissionRepository missionRepository;

	@Override
	public Mission createMission(Mission mission) {
		// TODO Auto-generated method stub
		return missionRepository.save(mission);
	}

	@Override
	public Mission updateMission(Mission mission) {

		Optional<Mission> UtilisateurDB = this.missionRepository.findById(mission.getIdMission());

		if (UtilisateurDB.isPresent()) {

			Mission utitlisateurUpdate = UtilisateurDB.get();
			utitlisateurUpdate.setIdMission(mission.getIdMission());
			utitlisateurUpdate.setNom(mission.getNom());
			utitlisateurUpdate.setPrenom(mission.getPrenom());
			utitlisateurUpdate.setTache(mission.getTache());
			utitlisateurUpdate.setDateDebut(mission.getDateDebut());
			utitlisateurUpdate.setDateExpiration(mission.getDateExpiration());
			utitlisateurUpdate.setService(mission.getService());
	
			return utitlisateurUpdate;
		} else {
			throw new ResourceNotFoundException("Enregistrement introuvable avec id : " + mission.getIdMission());
		}
	}

	@Override
	public List<Mission> getAllMission() {

		return missionRepository.findAll();
	}

	@Override
	public Mission getMissionById(long missionId) {
		// TODO Auto-generated method stub
		Optional<Mission> utilisateur = this.missionRepository.findById(missionId);

		if (utilisateur.isPresent()) {
			return utilisateur.get();
		} else {
			throw new ResourceNotFoundException("Enregistrement introuvable avec l'identifiant : " + missionId);
		}
	}
	

	@Override
	public void deleteMission(long missionId) {

		Optional<Mission> utilisateur = this.missionRepository.findById(missionId);

		if (utilisateur.isPresent()) {
			this.missionRepository.deleteById(missionId);
		} else {
			throw new ResourceNotFoundException("Enregistrement introuvable avec l'identifiant : " + missionId);
		}
	}

	

}
