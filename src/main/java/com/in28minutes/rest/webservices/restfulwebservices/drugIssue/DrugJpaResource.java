package com.in28minutes.rest.webservices.restfulwebservices.drugIssue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController


public class DrugJpaResource {

    @Autowired
    private DrugJpaRepo drugJpaRepo;

    @GetMapping("/jpa/users/{username}/drugs")
    public List<Drug> getAllDrugs(@PathVariable String username){
        // return drugService.findAll();
        return drugJpaRepo.findByUsername(username);
    }

    @GetMapping("/jpa/users/{username}/drugs/{id}")
    public Drug getDrug(@PathVariable String username,
                        @PathVariable Long id){
        //return drugService.findById(id);
        return drugJpaRepo.findById(id).get();

    }

    @DeleteMapping("/jpa/users/{username}/drugs/{id}")
    public ResponseEntity<Void> deleteDrug(@PathVariable String username,
                                           @PathVariable Long id){

        //Drug drug = drugService.deleteById(id);
        drugJpaRepo.deleteById(id);


        return ResponseEntity.noContent().build();


        //return ResponseEntity.notFound().build();
    }

    @PutMapping("/jpa/users/{username}/drugs/{id}")
    public ResponseEntity<Drug> updateDrug(@PathVariable String username,
                                           @PathVariable Long id,
                                           @RequestBody Drug drug){

        //Drug drugUpdated = drugService.save(drug);
        Drug drugUpdated = drugJpaRepo.save(drug);

        return new ResponseEntity<Drug>(drug, HttpStatus.OK);

    }

    @PostMapping("/jpa/users/{username}/drugs")
    public ResponseEntity<Void> createDrug(@PathVariable String username,
                                           @RequestBody Drug drug){

        //Drug createdDrug = drugService.saveii(drug);
        drug.setUsername(username);
        Drug createdDrug = drugJpaRepo.save(drug);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdDrug.getId()).toUri();


        return ResponseEntity.created(uri).build();

    }


}
