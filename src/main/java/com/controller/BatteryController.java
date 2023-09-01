package com.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Service.BatteryServiceImpl;
import com.entity.Battery;
import com.exception.BatteryException;

@RestController
@RequestMapping("/Battery")
public class BatteryController {
	
	@Autowired
	private BatteryServiceImpl batteryServiceImpl;
	
	
	@PostMapping("/save")
	public String saveAllMovies(@RequestBody Battery battery) throws IOException {
		battery.setTime(battery.getTime().now());
		return batteryServiceImpl.saveBattery(battery);
		
	}
	@GetMapping("/getInfo/{id}")
	public Battery getInfo(@PathVariable("id") Integer id) throws BatteryException {
	    return batteryServiceImpl.getInfoOfBattery(id);
	    
	}
	@GetMapping("/SpecificInfo")
	public String SpecificInfo(@RequestParam("list") List<String> list,@RequestParam("id")Integer id) throws BatteryException {
	    return batteryServiceImpl.getSpecificInfoOfBattery(id, list);   
	}
	
	@GetMapping("/specificInfoBetweenTimeRange")
	public Object specificInfoBetweenTimeRange(@RequestParam("list") String[] list,@RequestParam("id")Integer id,@RequestParam("stTime")LocalDateTime stTime,@RequestParam("endTime")LocalDateTime endTime) {
	    return batteryServiceImpl.getSpecificInfoOfBatteryInTimeRange(id, list, stTime, endTime);    
	}

}
