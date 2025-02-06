package com.example.controllers;

import java.util.List;
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
	
	@GetMapping(value = "/vehicleBycompIdAndmodelId/{compid}/{modelid}")
	Optional<List<Vehicle>> getVehicle(@PathVariable int compid, @PathVariable int modelid){
		return vehiclemanager.getByComp_idAndModel_id(compid, modelid);
	}
	
	

}
