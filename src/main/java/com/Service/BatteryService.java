package com.Service;

import java.time.LocalDateTime;
import java.util.List;

import com.entity.Battery;
import com.exception.BatteryException;

public interface BatteryService {
	
  String saveBattery(Battery battery);
    
  Battery getInfoOfBattery(Integer id) throws Exception;
  
  String getSpecificInfoOfBattery(Integer id,List<String> namesOfDetail) throws BatteryException ;
  
  Object getSpecificInfoOfBatteryInTimeRange(Integer id,String[] namesOfDetail,LocalDateTime startTime,LocalDateTime endTime);
  
}
