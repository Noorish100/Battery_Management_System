package com.Service;

import java.time.LocalDateTime;
import java.util.List;

import com.entity.Battery;
import com.entity.BatteryUser;
import com.exception.BatteryException;

public interface UserService {
	
	String saveUser(BatteryUser battery);
	
	Battery getInfoOfBattery(Integer id) throws Exception;
	  
	  String getSpecificInfoOfBattery(Integer id,List<String> namesOfDetail) throws BatteryException ;
	  
	  Object getSpecificInfoOfBatteryInTimeRange(Integer id,String[] namesOfDetail,LocalDateTime startTime,LocalDateTime endTime);

}
