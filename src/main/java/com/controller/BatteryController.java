package com.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String>  saveAllMovies(@RequestBody Battery battery) throws IOException {
		battery.setTime(battery.getTime().now());
		return new ResponseEntity<String>(batteryServiceImpl.saveBattery(battery),HttpStatus.OK);
		
	}
	@GetMapping("/getInfo/{id}")
	public ResponseEntity<Battery> getInfo(@PathVariable("id") Integer id) throws BatteryException {
	    return new ResponseEntity<Battery>(batteryServiceImpl.getInfoOfBattery(id),HttpStatus.OK);
	    
	}
	@GetMapping("/SpecificInfo")
	public ResponseEntity<Object> SpecificInfo(@RequestParam("list") List<String> list,@RequestParam("id")Integer id) throws BatteryException{

	    return new ResponseEntity<Object>(batteryServiceImpl.getSpecificInfoOfBattery(id, list), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/specificInfoBetweenTimeRange")
	public ResponseEntity<Object> specificInfoBetweenTimeRange(@RequestParam("list") String[] list,@RequestParam("id")Integer id,@RequestParam("stTime")LocalDateTime stTime,@RequestParam("endTime")LocalDateTime endTime){
		
            
				return new ResponseEntity<Object>(batteryServiceImpl.getSpecificInfoOfBatteryInTimeRange(id, list, stTime, endTime), HttpStatus.ACCEPTED);
			} 
    		
}
