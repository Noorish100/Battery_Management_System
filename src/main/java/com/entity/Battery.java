package com.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Battery {
	
	@Id
	private Integer batteryId;
	private String current;
	private String voltage;
	private String temprature;
	private LocalDateTime time;
	
	

}
