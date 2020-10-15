package com.in28minutes.rest.webservices.restfulwebservices.longTermIlnesses;

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
public class LTillnessJpaResource 
{
	
		@Autowired
		private LTillnessJpaRepo LTJpaRepo;
	
		@GetMapping("/jpa/users/LTillness")
		public List<LTillness> getAllLTillnesses(){
		// return patientService.findAll();
        return LTJpaRepo.findAll();
		}

	 	@GetMapping("/jpa/users/getLTillness/{ltID}")
	    public LTillness getLTillness(@PathVariable Long ltID){
	        //return patientService.findById(id);
	        return LTJpaRepo.findById(ltID).get();

	    }
	 	
	 	@GetMapping("/jpa/users/getLTillness/ByPatientID/{patientID}")
	    public List<LTillness> getLTillnessByPatientID(@PathVariable Long patientID){
	        //return patientService.findById(id);
	        return LTJpaRepo.findLTByPatientID(patientID);

	    }

		@DeleteMapping("/jpa/users/LTillnessdelete/{ltID}")
	    public ResponseEntity<Void> deleteLTillness(@PathVariable Long ltID){

	        //Patients patient = patientService.deleteById(id);
	    	LTJpaRepo.deleteById(ltID);;

	        return ResponseEntity.noContent().build();

	        //return ResponseEntity.notFound().build();
	    }

	    @PutMapping("/jpa/users/updateLTillness/{ltID}")
	    public ResponseEntity<LTillness> updateLTillness(@PathVariable Long ltID,
	                                           @RequestBody LTillness ltillness){

	        //Patient patientUpdated = patientService.save(patient);
	    	LTillness LTillnessUpdated = LTJpaRepo.save(ltillness);

	        return new ResponseEntity<LTillness>(ltillness, HttpStatus.OK);

	    }

	    @PostMapping("/jpa/users/insertLTillness")
	    public ResponseEntity<Void> createLTillness(@RequestBody LTillness ltillness){

	        //Patient createdPatient = patientService.saveii(patient);
	    	LTillness createdLTillness = LTJpaRepo.save(ltillness);

	        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{ltID}").buildAndExpand(createdLTillness.getLtID()).toUri();


	        return ResponseEntity.created(uri).build();

	    }
	    
	 
}
