package com.in28minutes.rest.webservices.restfulwebservices.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SupplierJpaResource {

    @Autowired
    private SupplierJpaRepo supplierJpaRepo;

    @GetMapping("/jpa/users/{username}/suppliers")
    public List<Supplier> getAllSupplier(@PathVariable String username){
        // return todoService.findAll();
        return supplierJpaRepo.findByUsername(username);
    }

    @GetMapping("/jpa/users/{username}/suppliers/{id}")
    public Supplier getSupplier(@PathVariable String username,
                                @PathVariable Long id){
        //return todoService.findById(id);
        return supplierJpaRepo.findById(id).get();

    }

    @DeleteMapping("/jpa/users/{username}/suppliers/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable String username,
                                               @PathVariable Long id){

        //Todo todo = todoService.deleteById(id);
        supplierJpaRepo.deleteById(id);


        return ResponseEntity.noContent().build();


        //return ResponseEntity.notFound().build();
    }

    @PutMapping("/jpa/users/{username}/suppliers/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable String username,
                                                   @PathVariable Long id,
                                                   @RequestBody Supplier supplier){

        //Todo todoUpdated = todoService.save(todo);
        Supplier supplierUpdated = supplierJpaRepo.save(supplier);

        return new ResponseEntity<Supplier>(supplier, HttpStatus.OK);

    }

    @PostMapping("/jpa/users/{username}/suppliers")
    public ResponseEntity<Void> createSupplier(@PathVariable String username,
                                               @RequestBody Supplier supplier){

        //Todo createdTodo = todoService.saveii(todo);
        supplier.setUsername(username);
        Supplier createdSupplier = supplierJpaRepo.save(supplier);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdSupplier.getId()).toUri();


        return ResponseEntity.created(uri).build();

    }
}
