package com.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Service.UserServiceImpl;
import com.entity.Battery;
import com.entity.BatteryUser;
import com.exception.BatteryException;

@RestController
@RequestMapping("/User")
public class UserController {
	
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveAllMovies(@RequestBody BatteryUser user) throws IOException {

		return new ResponseEntity<String>(userServiceImpl.saveUser(user), HttpStatus.OK);

	}

	
	
	@GetMapping("/getInfo/{id}")
	public ResponseEntity<Battery> getInfo(@PathVariable("id") Integer id) throws BatteryException {
		return new ResponseEntity<Battery>(userServiceImpl.getInfoOfBattery(id), HttpStatus.OK);

	}

	@GetMapping("/specificInfo")
	public ResponseEntity<Object> SpecificInfo(@RequestParam("list") List<String> list, @RequestParam("id") Integer id)
			throws BatteryException {

		return new ResponseEntity<Object>(userServiceImpl.getSpecificInfoOfBattery(id, list), HttpStatus.ACCEPTED);
	}

	@GetMapping("/specificInfoBetweenTimeRange")
	public ResponseEntity<Object> specificInfoBetweenTimeRange(@RequestParam("list") String[] list,
			@RequestParam("id") Integer id, @RequestParam("stTime") LocalDateTime stTime,
			@RequestParam("endTime") LocalDateTime endTime) {

		return new ResponseEntity<Object>(
				userServiceImpl.getSpecificInfoOfBatteryInTimeRange(id, list, stTime, endTime), HttpStatus.ACCEPTED);
	}

}
