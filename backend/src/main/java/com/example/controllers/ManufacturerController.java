package com.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Manufacturer;
import com.example.services.ManufacturerManager;

@RestController
@RequestMapping("/api/manufacturer")
public class ManufacturerController {
	
	@Autowired
	ManufacturerManager manufacturermanager;
	
	@GetMapping(value = "/manufacturerBysegId/{segid}")
	Optional<List<Manufacturer>> getManufacturer(@PathVariable int segid){
		return manufacturermanager.findBySegId(segid);
	}
}
