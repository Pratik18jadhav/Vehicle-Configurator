package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entities.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
	
	@Query(value= """
			select v.confi_id , v.comp_id, v.model_id, v.comp_type, v.is_configrable from vehicle v  where v.comp_id = ?1 and v.model_id =?2 
			""" , nativeQuery = true)
	Optional<List<Vehicle>> getByComp_idAndModel_id(int comp_id , int model_id);

}
