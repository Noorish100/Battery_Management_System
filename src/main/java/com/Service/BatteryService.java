package com.Service;

import java.time.LocalDateTime;
import java.util.List;

import com.entity.Battery;
import com.exception.BatteryException;

public interface BatteryService {
	
  String saveBattery(Battery battery);
    
}
