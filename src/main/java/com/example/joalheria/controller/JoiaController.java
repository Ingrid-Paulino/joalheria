package com.example.joalheria.controller;

import com.example.joalheria.advisor.exception.NotFoundException;
import com.example.joalheria.model.JoiaBD;
import com.example.joalheria.service.JoiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/joia")
public class JoiaController {
    @Autowired
    private JoiaService service;

    //Usei Request Body
    @PostMapping("/inserir")
    public ResponseEntity<String> insert(@Valid @RequestBody JoiaBD joia) {
        JoiaBD newJoia = service.insert(joia);
        return new ResponseEntity<>("Joia " + newJoia.getIdentificationNumber() + " criada!", HttpStatus.CREATED);
    } // http://localhost:8081/api/testcases/new

    @GetMapping("joias")
    public ResponseEntity<List<JoiaBD>> findAllJoias() {
        List<JoiaBD> joias = service.findAll();
        return new ResponseEntity<>(joias, HttpStatus.CREATED);
    } // http://localhost:8081/api/testcases

    @GetMapping("/{id}")
    public ResponseEntity<Optional<JoiaBD>> findById(@PathVariable long id) throws NotFoundException {
        Optional<JoiaBD> optionalJoiaBD = service.findById(id);
        return new ResponseEntity<>(optionalJoiaBD, HttpStatus.OK);
    } // http://localhost:8081/joia/9

    //@PutMapping
    //public ResponseEntity<JoiaBD> update(@RequestBody JoiaBD joia) {
    //JoiaBD joiaUpdate = service.update(joia);
    //  return new ResponseEntity<>(joiaUpdate, HttpStatus.OK);
    //}

    //Ou
    //joia/atualizar?número identificacao={}
    @PutMapping("/atualizar")
    public ResponseEntity<JoiaBD> update(@RequestParam long numero_identificacao,
                                         @RequestBody JoiaBD joia)  throws NotFoundException {
        JoiaBD joiaUpdate = service.update(joia, numero_identificacao);
        return new ResponseEntity<>(joiaUpdate, HttpStatus.OK);
    } // http://localhost:8081/joia/atualizar?numero_identificacao=99

    // joia/excluir?numero_identificacao={id}
    // joia/excluir?numero_identificacao=1
    //Usei Request Param
    @DeleteMapping("/excluir")
    public ResponseEntity<Void> delete(@RequestParam long numero_identificacao) throws NotFoundException {
        service.delete(numero_identificacao);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } // http://localhost:8081/joia/excluir?numero_identificacao=99
}
