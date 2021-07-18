package com.nikita.springwebexample9.repository;

import com.nikita.springwebexample9.document.Doctor;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface DoctorRepository extends R2dbcRepository<Doctor,Integer>{
    // Find all doctors by Specs
    Flux<Doctor> findBySpecs(String specs);
    // Find all details of a doctor by Name (binding parameter not supported by webflux)
    @Query("SELECT * FROM doctor WHERE dname = :#{[0]}")
    Mono<Doctor> findByDName(String dname);
    // Update Specs of a doctor given Name
    @Query("UPDATE doctor SET specs = :specs where dname = :dname")
    Mono<Doctor> updateSpecs(String specs, String dname);

    @Query("SELECT * FROM doctor WHERE pid =: pid")
    Flux<Doctor> doctorbyId(int pid);
}
