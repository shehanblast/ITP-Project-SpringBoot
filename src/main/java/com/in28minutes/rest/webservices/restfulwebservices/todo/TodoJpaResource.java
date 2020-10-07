package com.in28minutes.rest.webservices.restfulwebservices.todo;

import com.in28minutes.rest.webservices.restfulwebservices.Medicine.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoJpaResource {

    @Autowired
    private TodoHardCodedService todoService;

    @Autowired
    private TodoJpaRepo todoJpaRepo;

    @GetMapping("/jpa/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){
       // return todoService.findAll();
        return todoJpaRepo.findByUsername(username);
    }



    @GetMapping("/jpa/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username,
                        @PathVariable Long id){
        //return todoService.findById(id);
        return todoJpaRepo.findById(id).get();

    }



    @DeleteMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username,
                                           @PathVariable Long id){

        //Todo todo = todoService.deleteById(id);
        todoJpaRepo.deleteById(id);


        return ResponseEntity.noContent().build();


        //return ResponseEntity.notFound().build();
    }

    @PutMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username,
                                           @PathVariable Long id,
                                           @RequestBody Todo todo){

        //Todo todoUpdated = todoService.save(todo);
        Todo todoUpdated = todoJpaRepo.save(todo);

        return new ResponseEntity<Todo>(todo, HttpStatus.OK);

    }

    @PostMapping("/jpa/users/{username}/todos")
    public ResponseEntity<Void> createTodo(@PathVariable String username,
                                           @RequestBody Todo todo){

        //Todo createdTodo = todoService.saveii(todo);
        todo.setUsername(username);
        Todo createdTodo = todoJpaRepo.save(todo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdTodo.getId()).toUri();


        return ResponseEntity.created(uri).build();

    }




}
