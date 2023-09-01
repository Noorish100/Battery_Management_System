package com.Service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Repository.BatteryRepository;
import com.entity.Battery;

@Service
public class BatteryServiceImpl implements BatteryService {

	

	@Autowired
	private BatteryRepository batteryRepository;

	@Override
	public String saveBattery(Battery battery) {
		Optional<Battery> existedBattery = batteryRepository.findById(battery.getSerno());
		if (existedBattery.isPresent()) {
			return "already present";
		}
		batteryRepository.save(battery);
		return "Battery data has been saved";
	}

}
