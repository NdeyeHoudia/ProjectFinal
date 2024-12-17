package com.Project9.MicroserviceGestationRisque.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="backend-patient", url="http://localhost:8084/patients")



public interface PatientClient {

    @GetMapping("/{id}/agePatient")
    public int agePatient(@PathVariable Integer id);


    @GetMapping("/{id}/genre")
    public String genrePatient(@PathVariable Integer id);

}
