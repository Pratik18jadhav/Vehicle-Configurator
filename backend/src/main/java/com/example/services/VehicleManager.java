package com.example.services;

import java.util.List;
import java.util.Optional;

import com.example.entities.Vehicle;

public interface VehicleManager {
	
	Optional<List<Vehicle>> getByComp_idAndModel_id(int comp_id , int model_id);

}
