package com.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entity.Battery;



public interface BatteryRepository extends JpaRepository<Battery, Integer> {
	

	@Query(value = "SELECT  * FROM Battery bd WHERE bd.Battery_ID = :id AND bd.Time >= :startTime AND bd.Time <= :endTime", nativeQuery = true)
	Optional<Battery> findDataBetweenTimeRange(@Param("id") Integer id, @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);
	
}
