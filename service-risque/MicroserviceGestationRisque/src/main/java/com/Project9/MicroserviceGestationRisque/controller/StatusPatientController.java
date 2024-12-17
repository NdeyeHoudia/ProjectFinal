package com.Project9.MicroserviceGestationRisque.controller;

import com.Project9.MicroserviceGestationRisque.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/risquePatient")
public class StatusPatientController {

    @Autowired
    private PatientService patientService;
    @GetMapping("/{id}/status")
    public String statusPatient(@PathVariable Integer id){
        return patientService.statusNotePatient(id);
    }
}
