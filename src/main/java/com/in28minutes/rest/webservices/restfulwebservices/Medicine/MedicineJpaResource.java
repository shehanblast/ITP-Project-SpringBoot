package com.in28minutes.rest.webservices.restfulwebservices.Medicine;

import com.in28minutes.rest.webservices.restfulwebservices.todo.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MedicineJpaResource {

    @Autowired
    private MedicineJpaRepo medicineJpaRepo;

    @GetMapping("/jpa/users/{username}/to")
    public List<Medicine> getAllMedicines(@PathVariable String username){
        return medicineJpaRepo.findByUsername(username);
    }

    @GetMapping("/jpa/users/{username}/to/{id}")
    public Medicine getMedicine(@PathVariable String username,
                            @PathVariable Long id){
        return medicineJpaRepo.findById(id).get();

    }

    @DeleteMapping("/jpa/users/{username}/to/{id}")
    public ResponseEntity<Void> deleteMedicine(@PathVariable String username,
                                           @PathVariable Long id){


        medicineJpaRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/jpa/users/{username}/to/{id}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable String username,
                                               @PathVariable Long id,
                                               @RequestBody Medicine medicine){

        Medicine medUpdated = medicineJpaRepo.save(medicine);
        return new ResponseEntity<Medicine>(medicine, HttpStatus.OK);


    }

    @PostMapping("/jpa/users/{username}/to")
    public ResponseEntity<Void> createMedicine(@PathVariable String username,
                                           @RequestBody Medicine medicine){

        medicine.setUsername(username);
        Medicine createdMed = medicineJpaRepo.save(medicine);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdMed.getId()).toUri();


        return ResponseEntity.created(uri).build();


    }



}
