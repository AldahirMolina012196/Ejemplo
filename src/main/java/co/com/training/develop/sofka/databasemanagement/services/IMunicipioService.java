package co.com.training.develop.sofka.databasemanagement.services;

import co.com.training.develop.sofka.databasemanagement.model.Municipio;
import co.com.training.develop.sofka.databasemanagement.util.Response;

import java.util.List;

public interface IMunicipioService {
    List<Municipio> getAllMunicipio();
    Response addMunicipio(Municipio municipio);
    Response getMunicipio(String id);

}
