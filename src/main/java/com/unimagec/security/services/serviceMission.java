package com.unimagec.security.services;

import java.util.List;

import com.unimagec.models.Mission;



public interface serviceMission {

	Mission createMission(Mission mission);

	Mission updateMission(Mission mission);

	List<Mission> getAllMission();

	Mission getMissionById(long missionId);

	void deleteMission(long missionId);
}
