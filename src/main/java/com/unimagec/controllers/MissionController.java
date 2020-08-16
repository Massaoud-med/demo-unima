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

import com.unimagec.models.Mission;
import com.unimagec.security.services.serviceMissionImpl;




@RestController
//CrossOriginest est un mécanisme qui permet partage de ressources entre origines multiples.
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/api/v1")
public class MissionController {
	
	@Autowired
	private serviceMissionImpl  serviceMissionImpl;
	
	@GetMapping("/Missions")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<List<Mission>> getAllMissions() {
		return ResponseEntity.ok().body(serviceMissionImpl.getAllMission());
  }
	
  @GetMapping("/Missions/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Mission> getMissionsById(@PathVariable("id") long missionId) {
		return ResponseEntity.ok().body(serviceMissionImpl.getMissionById(missionId));
	}

  @PostMapping("/Missions")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public ResponseEntity<Mission> createMissions(@RequestBody Mission mission) {
		return ResponseEntity.ok().body(this.serviceMissionImpl.createMission(mission));
  }
 
	@PutMapping("/Missions/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public ResponseEntity<Mission> updateMissions(@PathVariable("id") long idMission,
			@RequestBody Mission mission) {
		mission.setIdMission(idMission);
		;
		return ResponseEntity.ok().body(this.serviceMissionImpl.updateMission(mission));
	}
	
  @DeleteMapping("/Missions/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
  public String deleteMissions(@PathVariable("id") long missionId) {
		this.serviceMissionImpl.deleteMission(missionId);

		return "OK";
      }

}
