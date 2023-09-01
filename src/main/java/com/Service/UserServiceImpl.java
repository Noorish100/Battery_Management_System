package com.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Repository.BatteryRepository;
import com.Repository.UserRepo;
import com.entity.Battery;
import com.entity.BatteryUser;
import com.exception.BatteryException;


@Service
public class UserServiceImpl implements UserService {
	
	String[] con = { "current", "voltage", "temperature", "time" };
	
	@Autowired
	private BatteryRepository batteryRepository;
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public Battery getInfoOfBattery(Integer id) throws BatteryException {
		
		Optional<Battery> existedBattery = batteryRepository.findById(id);

		Battery b = existedBattery.get();

		if (existedBattery.isEmpty()) {
			throw new BatteryException("not Found");
		}
		return b;
	}

	@Override
	public String getSpecificInfoOfBattery(Integer id, List<String> namesOfDetail) throws BatteryException {
		Optional<Battery> existedBattery = batteryRepository.findById(id);
		String ans = "";
		Battery b = existedBattery.get();

		if (existedBattery.isEmpty()) {
			throw new BatteryException("not Found");
		}
		for (int i = 0; i < con.length; i++) {
			if (namesOfDetail.contains(con[i])) {
				if (con[i].equalsIgnoreCase("current")) {
					ans = ans + " " + "Current" + "= " + b.getCurrent();
				}
				if (con[i].equalsIgnoreCase("voltage")) {
					ans = ans + " " + "Voltage" + "= " + b.getVoltage();
				}
				if (con[i].equalsIgnoreCase("temperature")) {
					ans = ans + " " + "Temperature" + "= " + b.getTemprature();
				}
				if (con[i].equalsIgnoreCase("time")) {
					ans = ans + " " + "time" + "= " + b.getTime();
				}

			}
		}
		return ans;
	}

	@Override
	public Object getSpecificInfoOfBatteryInTimeRange(Integer id, String[] namesOfDetail, LocalDateTime startTime,
			LocalDateTime endTime) {

		Optional<Battery> batteryData = batteryRepository.findDataBetweenTimeRange(id, startTime, endTime);
		List<Object> result = new ArrayList<>();

		if (batteryData.isEmpty()) {
			return "Sorry Query result empty set ";
		}
		Battery battery = batteryData.get();

		for (int i = 0; i < namesOfDetail.length; i++) {
			switch (namesOfDetail[i]) {
			case "current":
				result.add("current=" + battery.getCurrent());
				break;
			case "voltage":
				result.add("voltage=" + battery.getVoltage());
				break;
			case "time":
				result.add("time=" + battery.getTime());
				break;
			case "temprature":
				result.add("temprature=" + battery.getTemprature());
				break;
			// Add cases for other columns as needed

			}
		}
		return result;
	}

	@Override
	public String saveUser(BatteryUser user) {
		Optional<BatteryUser> existedBattery = userRepo.findById(user.getUserid());
		if (existedBattery.isPresent()) {
			return "already present";
		}
		userRepo.save(existedBattery.get());
		return "Battery data has been saved";
	}
	
	

}
