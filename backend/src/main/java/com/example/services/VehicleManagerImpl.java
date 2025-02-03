package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Vehicle;
import com.example.repository.VehicleRepository;

@Service
public class VehicleManagerImpl implements VehicleManager  {
	
	@Autowired
	VehicleRepository vehiclerepository;

	@Override
	public Optional<List<Vehicle>> getByComp_idAndModel_id(int comp_id, int model_id) {
		// TODO Auto-generated method stub
		return vehiclerepository.getByComp_idAndModel_id(comp_id, model_id);
	}

}
