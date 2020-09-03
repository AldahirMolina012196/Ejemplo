package co.com.training.develop.sofka.databasemanagement.services.impl;

import co.com.training.develop.sofka.databasemanagement.dao.IMunicipioDao;
import co.com.training.develop.sofka.databasemanagement.model.Municipio;
import co.com.training.develop.sofka.databasemanagement.services.IMunicipioService;
import co.com.training.develop.sofka.databasemanagement.util.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplMunicipioService  implements IMunicipioService {
    IMunicipioDao daoMunicipio;
    IMunicipioDao daoMunicipioCerca;

    public ImplMunicipioService(IMunicipioDao daoMunicipio, IMunicipioDao daoMunicipioCerca) {
        this.daoMunicipio = daoMunicipio;
        this.daoMunicipioCerca = daoMunicipioCerca;
    }

    @Override
    public List<Municipio> getAllMunicipio() {
        return (List<Municipio>)daoMunicipio.findAll();
    }

    @Override
    public Response addMunicipio(Municipio municipio) {
        Response response = new Response();
        if(daoMunicipio.existsById(municipio.getId())){
            response.setMessage("Not Found");
            response.setState(false);
            response.setCodeMessage(404);
            response.setMessageBody("El municipio que desea ingresar ya existe");
        }else{
            response.setState(true);
            response.setMessage("Ok");
            response.setCodeMessage(201);
            response.setMessageBody(daoMunicipio.save(municipio));
        }
        return response;
    }

    @Override
    public Response getMunicipio(String id) {
        Response response = new Response();
        if(daoMunicipio.existsById(id)){
            response.setState(true);
            response.setMessage("Ok");
            response.setCodeMessage(201);
            response.setMessageBody(daoMunicipio.findById(id));
        }else{
            response.setMessage("Not Found");
            response.setState(false);
            response.setCodeMessage(404);
            response.setMessageBody("No existe el municipio con id: " + id);
        }
        return response;
    }


}
