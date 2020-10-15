package com.in28minutes.rest.webservices.restfulwebservices.patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PatientJpaResource {


    //@Autowired
   // private TodoHardCodedService todoService;

    @Autowired
    private PatientJpaRepo patientJpaRepo;

    @GetMapping("/jpa/users/patients")
    public List<Patient> getAllPatients(){
       // return patientService.findAll();
        return patientJpaRepo.findAll();
    }

    @GetMapping("/jpa/users/patients/{patientName}")
    public List<Patient> findPatient(@PathVariable String patientName)
    {
        //return patientService.findById(id);
        return patientJpaRepo.findBypatientName(patientName);

    }
    
    @GetMapping("/jpa/users/getpatient/{patientID}")
    public Patient getPatient(@PathVariable Long patientID){
        //return patientService.findById(id);
        return patientJpaRepo.findById(patientID).get();

    }

    @DeleteMapping("/jpa/users/patientdelete/{patientID}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long patientID){

        //Patients patient = patientService.deleteById(id);
        patientJpaRepo.deleteById(patientID);

        return ResponseEntity.noContent().build();

        //return ResponseEntity.notFound().build();
    }

    @PutMapping("/jpa/users/patientupdate/{patientID}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long patientID,
                                           @RequestBody Patient patient){

        //Patient patientUpdated = patientService.save(patient);
        Patient patientUpdated = patientJpaRepo.save(patient);

        return new ResponseEntity<Patient>(patient, HttpStatus.OK);

    }

    @PostMapping("/jpa/users/insertpatient")
    public ResponseEntity<Void> createPatient(@RequestBody Patient patient){

        //Patient createdPatient = patientService.saveii(patient);
        Patient createdPatient = patientJpaRepo.save(patient);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{patientID}").buildAndExpand(createdPatient.getPatientID()).toUri();


        return ResponseEntity.created(uri).build();

    }
    
    @GetMapping("/jpa/users/searchpatient/{patientName}")
    public List<Patient> searchPatient(@PathVariable String patientName){
    	
        return patientJpaRepo.findBypatientNameContainingIgnoreCase(patientName);

    }
}