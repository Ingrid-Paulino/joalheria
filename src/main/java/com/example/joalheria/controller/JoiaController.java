package com.example.joalheria.controller;

import com.example.joalheria.model.JoiaBD;
import com.example.joalheria.service.JoiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joia")
public class JoiaController {
    @Autowired
    private JoiaService service;

    @PostMapping("/inserir")
    public ResponseEntity<String> insert(@RequestBody JoiaBD joia) {
        JoiaBD newJoia = service.insert(joia);
        return new ResponseEntity<>("Joia " + newJoia.getIdentificationNumber() + " criada!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<JoiaBD>> findAllJoias() {
        List<JoiaBD> joias = service.findAllJoias();
        return new ResponseEntity<>(joias, HttpStatus.CREATED);
    }
}
