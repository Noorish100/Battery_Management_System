package com.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Repository.BatteryRepository;
import com.entity.Battery;
import com.exception.BatteryException;

@Service
public class BatteryServiceImpl implements BatteryService {
	
	String[] con= {"current","voltage","temperature","time"};
	
	@Autowired
	private BatteryRepository batteryRepository;

	
	@Override
	public String saveBattery(Battery battery) {
		Optional<Battery> existedBattery = batteryRepository.findById(battery.getBatteryId());
		if(existedBattery.isPresent()) {
			return "already present";
		}
	     batteryRepository.save(battery);
		return "Battery data has been saved";
	}

	@Override
	public Battery getInfoOfBattery(Integer id)throws BatteryException {
		Optional<Battery> existedBattery = batteryRepository.findById(id);
		
		Battery b=existedBattery.get();
		
		if(existedBattery.isEmpty()) {
			throw new BatteryException("not Found");
		}
		return b;
	}

	@Override
	public String getSpecificInfoOfBattery(Integer id, List<String> namesOfDetail)throws BatteryException {
     Optional<Battery> existedBattery = batteryRepository.findById(id);
		String ans="";
		Battery b=existedBattery.get();
		
		if(existedBattery.isEmpty()) {
			throw new BatteryException("not Found");
		}
		for(int i=0;i<con.length;i++) {
			if(namesOfDetail.contains(con[i])) {
			if(con[i].equalsIgnoreCase("current")) {
				ans=ans+" "+"Current"+"= "+b.getCurrent();
			}
		     if(con[i].equalsIgnoreCase("voltage")) {
				ans=ans+" "+"Voltage"+"= "+b.getVoltage();
			}
		     if(con[i].equalsIgnoreCase("temperature")) {
		    	 ans=ans+" "+"Temperature"+"= "+b.getTemprature();
		     }
		     if(con[i].equalsIgnoreCase("time")) {
		    	 ans=ans+" "+"time"+"= "+b.getTime();
		     }
			  	
		}}
		return ans;	
	}

	@Override
	public Object getSpecificInfoOfBatteryInTimeRange(Integer id, String[] namesOfDetail, LocalDateTime startTime, LocalDateTime endTime) {
		String s="";
		for(int i=0;i<namesOfDetail.length;i++) {
			if(i<namesOfDetail.length-1) {
			s=s+"bd."+namesOfDetail[i]+",";
			}
			else {
				s=s+"bd."+namesOfDetail[i];
			}
		}
     
     
    
		return batteryRepository.findDataBetweenTimeRange(s,id, startTime, endTime);
		
		
	
	}
	
	

}
