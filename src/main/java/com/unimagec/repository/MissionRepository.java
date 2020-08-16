package com.unimagec.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unimagec.models.Mission;


@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
	

	

}
