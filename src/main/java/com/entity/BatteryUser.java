package com.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class BatteryUser {
	
	@Id
	private Integer userid;
	private String userName;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Battery> battery;

}
