package co.com.training.develop.sofka.databasemanagement.dao;

import co.com.training.develop.sofka.databasemanagement.model.Municipio;
import org.springframework.data.repository.CrudRepository;

public interface IMunicipioDao extends CrudRepository<Municipio, String> {
}
