package com.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entity.Battery;



public interface BatteryRepository extends JpaRepository<Battery, Integer> {
	
//	@Query(value="select m.,m.primary_title,m.runtime_minutes,m.genres from Battery m order by m.runtime_minutes desc limit 10",nativeQuery = true) 
//    List<Object> findByRuntimeMinutes();
	        //  Substri   //          "bd.vol"
	@Query(value="SELECT :s FROM Battery bd WHERE bd.Battery_ID = :id AND bd.Time >= :startTime AND bd.Time <= :endTime", nativeQuery=true)
	Object findDataBetweenTimeRange(@Param("s") String s, @Param("id") Integer id, @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);


	
}
