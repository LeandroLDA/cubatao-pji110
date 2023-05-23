package com.backendFrameworkWeb.gerenciadorDocumentos.controller;

import com.backendFrameworkWeb.gerenciadorDocumentos.manual.Manual;
import com.backendFrameworkWeb.gerenciadorDocumentos.manual.ManualRepository;
import com.backendFrameworkWeb.gerenciadorDocumentos.manual.ManualRequestDTO;
import com.backendFrameworkWeb.gerenciadorDocumentos.manual.ManualResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("manual")
public class ManualController{
    @Autowired
    private ManualRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveManual(@RequestBody ManualRequestDTO data){
       Manual manualData = new Manual(data);
        repository.save(manualData);
        return;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<ManualResponseDTO> getAll(){

            List<ManualResponseDTO> manualList = repository.findAll().stream().map(ManualResponseDTO::new).toList();
            return manualList;

    }
}