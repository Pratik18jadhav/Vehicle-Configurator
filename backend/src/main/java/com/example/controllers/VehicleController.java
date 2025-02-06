package com.example.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.entities.Vehicle;
import com.example.services.VehicleManager;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
	
	@Autowired
	VehicleManager vehiclemanager;
	
	@GetMapping(value = "/vehicleBymodelId/{modelid}")
	Optional<List<Map<String, Object>>> getVehicle(@PathVariable int modelid){
		return vehiclemanager.getByModel_id( modelid);
	}
	
	

}
