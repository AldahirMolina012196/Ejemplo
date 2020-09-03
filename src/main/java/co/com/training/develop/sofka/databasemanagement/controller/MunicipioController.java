package co.com.training.develop.sofka.databasemanagement.controller;

import co.com.training.develop.sofka.databasemanagement.model.Municipio;
import co.com.training.develop.sofka.databasemanagement.services.IMunicipioService;
import co.com.training.develop.sofka.databasemanagement.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MunicipioController {
    @Autowired
    IMunicipioService serviceMunicipio;

    @GetMapping("/listMunicipios")
    public List<Municipio> getDataAllMunicipios(){
        return serviceMunicipio.getAllMunicipio();
    }

    @PostMapping("/addMunicipios")
    public Response addDataMunicipio(@RequestBody Municipio municipio){
        return serviceMunicipio.addMunicipio(municipio);
    }

    @GetMapping("/Municipio/{id}")
    public Response getDataMunicipio(@PathVariable(value="id")String id){
        return serviceMunicipio.getMunicipio(id);
    }
}
