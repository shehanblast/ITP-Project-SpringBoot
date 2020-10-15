package com.in28minutes.rest.webservices.restfulwebservices.shortTermIlnesses;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class STillnessJpaResource 
{
	
		@Autowired
		private STillnessJpaRepo STJpaRepo;
	
		@GetMapping("/jpa/users/STillness")
		public List<STillness> getAllSTillnesses(){
		// return patientService.findAll();
        return STJpaRepo.findAll();
		}
	
	 	@GetMapping("/jpa/users/getSTillness/{stID}")
	    public STillness getSTillness(@PathVariable Long stID){
	        //return patientService.findById(id);
	        return STJpaRepo.findById(stID).get();

	    }
	 	
	 	@GetMapping("/jpa/users/getSTillness/ByPatientID/{patientID}")
	    public List<STillness> getSTillnessBypatientID(@PathVariable Long patientID){
	        //return patientService.findById(id);
	        return STJpaRepo.findSTByPatientID(patientID);

	    }

		@DeleteMapping("/jpa/users/STillnessdelete/{stID}")
	    public ResponseEntity<Void> deleteSTillness(@PathVariable Long stID){

	        //Patients patient = patientService.deleteById(id);
			STJpaRepo.deleteById(stID);

	        return ResponseEntity.noContent().build();

	        //return ResponseEntity.notFound().build();
	    }

	    @PutMapping("/jpa/users/updateSTillness/{stID}")
	    public ResponseEntity<STillness> updateSTillness(@PathVariable Long stID,
	                                           @RequestBody STillness stillness){

	        //Patient patientUpdated = patientService.save(patient);
	    	STillness STillnessUpdated = STJpaRepo.save(stillness);

	        return new ResponseEntity<STillness>(stillness, HttpStatus.OK);

	    }

	    @PostMapping("/jpa/users/insertSTillness")
	    public ResponseEntity<Void> createSTillness(@RequestBody STillness stillness){

	        //Patient createdPatient = patientService.saveii(patient);
	    	STillness createdSTillness = STJpaRepo.save(stillness);

	        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{stID}").buildAndExpand(createdSTillness.getStID()).toUri();


	        return ResponseEntity.created(uri).build();

	    }

}
