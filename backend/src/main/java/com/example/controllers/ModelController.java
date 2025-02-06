package com.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Manufacturer;
import com.example.entities.Model;
import com.example.services.ModelManager;

@RestController
@RequestMapping(("/api/model"))
public class ModelController {

	@Autowired
	ModelManager modelManager;
	
	@GetMapping(value="/modelBySegIdAndMfgId/{segid}/{mfgid}")
	List<Model> getModel(@PathVariable int segid,@PathVariable int mfgid){
		return modelManager.findBySeg_IdAndMfg_Id(segid,mfgid);
	}
	
	
	
	
	
}
