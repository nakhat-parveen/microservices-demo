package com.citizenservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citizenservice.entity.Vaccination;

public interface VaccinationRepo extends JpaRepository<Vaccination, Integer> {

}
