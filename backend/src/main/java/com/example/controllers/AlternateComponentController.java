package com.example.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.AlternateComponent;
import com.example.entities.Component;
import com.example.services.AlternateComponentManager;
import com.example.services.ComponentManager;
import com.example.services.EmailService;
import com.example.services.InvoicePdfManager;

@RestController
@RequestMapping("/api/alternatecomponent")
public class AlternateComponentController {
	
	@Autowired
	AlternateComponentManager alternatecomponentmanager;
	
	@Autowired
	EmailService mailservice;
	
	@GetMapping("/alternatecompBycomp_idAndmodelId/{comp_id}/{model_id}")
	public AlternateComponent findAltCompbyModel_IdAndComp_Id(@PathVariable int comp_id,@PathVariable int model_id) {
		return alternatecomponentmanager.findAlternateComponentbyModel_IdAndComp_Id(comp_id, model_id);
	}
	
	@GetMapping("/alternatecompbymodel_idandalt_comp_id/{model_id}/{alt_id}")
	public List<Map<String, Object>> findByModel_idAndAlt_Comp_Id(@PathVariable int model_id,@PathVariable int alt_id) {
		
		
		//mailservice.sendEmail("ishankhekre123456@gmail.com","Email from Spring Boot", "Hi My name is Ishan and this mail is send from vehical configurator ");
		return alternatecomponentmanager.findByModel_idAndAlt_Comp_Id(model_id, alt_id);
	}
	
	
}

