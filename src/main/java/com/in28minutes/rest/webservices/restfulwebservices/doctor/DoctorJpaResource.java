package com.in28minutes.rest.webservices.restfulwebservices.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DoctorJpaResource {

    @Autowired
    private DoctorJpaRepo doctorJpaRepo;

    @GetMapping("/jpa/users/{username}/doctors")
    public List<Doctor> getAllDoctors(@PathVariable String username){
       // return doctorService.findAll();
        return doctorJpaRepo.findByUsername(username);
    }

    @GetMapping("/jpa/users/{username}/doctors/{id}")
    public Doctor getDoctor(@PathVariable String username,
                        @PathVariable Long id){
        //return doctorService.findById(id);
        return doctorJpaRepo.findById(id).get();

    }

    @DeleteMapping("/jpa/users/{username}/doctors/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable String username,
                                           @PathVariable Long id){

        //Doctor doctor = doctorService.deleteById(id);
    	doctorJpaRepo.deleteById(id);


        return ResponseEntity.noContent().build();


        //return ResponseEntity.notFound().build();
    }

    @PutMapping("/jpa/users/{username}/doctors/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable String username,
                                           @PathVariable Long id,
                                           @RequestBody Doctor doctor){

        //Doctor doctorUpdated = doctorService.save(doctor);
        Doctor doctorUpdated = doctorJpaRepo.save(doctor);

        return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);

    }

    @PostMapping("/jpa/users/{username}/doctors")
    public ResponseEntity<Void> createDoctor(@PathVariable String username,
                                           @RequestBody Doctor doctor){

        //Doctor createdDoctor = doctorService.saveii(doctor);
    	doctor.setUsername(username);
        Doctor createdDoctor = doctorJpaRepo.save(doctor);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdDoctor.getId()).toUri();


        return ResponseEntity.created(uri).build();

    }


}
