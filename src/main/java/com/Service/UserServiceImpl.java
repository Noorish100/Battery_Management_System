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
	
	String[] con = { "current", "voltage", "temprature", "time","batteryId" };
	
	@Autowired
	private BatteryRepository batteryRepository;
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public List<Battery> getInfoOfBattery(Integer id) throws BatteryException {
		
		Optional<List<Battery>> existedBattery = batteryRepository.findByBatteryId(id);

		List<Battery> b = existedBattery.get();

		if (existedBattery.isEmpty()) {
			throw new BatteryException("not Found");
		}
		return b;
	}

	@Override
	public String getSpecificInfoOfBattery(Integer id, List<String> namesOfDetail) throws BatteryException {
		Optional<List<Battery>> existedBattery = batteryRepository.findByBatteryId(id);
		String ans = "";
		List<Battery> b = existedBattery.get();

		if (existedBattery.isEmpty()) {
			throw new BatteryException("not Found");
		}
		
		for(Battery batt:b) {
		for (int i = 0; i < con.length; i++) {
			if (namesOfDetail.contains(con[i])) {
				
				if (con[i].equalsIgnoreCase("current")) {
					ans = ans + " " + "Current" + "= " + batt.getCurrent();
				}
				if (con[i].equalsIgnoreCase("voltage")) {
					ans = ans + " " + "Voltage" + "= " + batt.getVoltage();
				}
				if (con[i].equalsIgnoreCase("temperature")) {
					ans = ans + " " + "Temperature" + "= " + batt.getTemprature();
				}
				if (con[i].equalsIgnoreCase("time")) {
					ans = ans + " " + "time" + "= " + batt.getTime();
				}
				if (con[i].equalsIgnoreCase("batteryid")) {
					ans = ans + " " + "BatteryId" + "= " + batt.getBatteryId();
				}

			}
			}
		}
		return ans;
	}

	@Override
	public Object getSpecificInfoOfBatteryInTimeRange(Integer id, String[] namesOfDetail, LocalDateTime startTime,
			LocalDateTime endTime) {

		Optional<List<Battery>> batteryData = batteryRepository.findDataBetweenTimeRange(id, startTime, endTime);
		List<Object> result = new ArrayList<>();

		if (batteryData.isEmpty()) {
			return "Sorry Query result empty set ";
		}
		List<Battery> battery = batteryData.get();

		for(Battery batt:battery) {
		for (int i = 0; i < namesOfDetail.length; i++) {
			switch (namesOfDetail[i]) {
			case "current":
				result.add("current=" + batt.getCurrent());
				break;
			case "voltage":
				result.add("voltage=" + batt.getVoltage());
				break;
			case "time":
				result.add("time=" + batt.getTime());
				break;
			case "temprature":
				result.add("temprature=" + batt.getTemprature());
				break;
			case "batteryId":
				result.add("batteryid=" + batt.getBatteryId());
				break;
			// Add cases for other columns as needed

			}
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
