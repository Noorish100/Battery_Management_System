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
@RequestMapping("/battery")
public class BatteryController {

	@Autowired
	private BatteryServiceImpl batteryServiceImpl;

	@PostMapping("/save")
	public ResponseEntity<String> saveAllMovies(@RequestBody Battery battery) throws IOException {
		battery.setTime(battery.getTime().now());
		return new ResponseEntity<String>(batteryServiceImpl.saveBattery(battery), HttpStatus.OK);

	}

	

}
