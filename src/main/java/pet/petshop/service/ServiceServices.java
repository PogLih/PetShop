package pet.petshop.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.petshop.entity.Services;
import pet.petshop.repository.ServiceRespository;
@Service
public class ServiceServices {
	@Autowired
	private ServiceRespository sepo;
	
	public List<Services> listALl(){
		return sepo.findAll();
	}
	public void save(Services services) {
		sepo.save(services);
	}
	public Services get(Integer id) {
		return sepo.findById(id).get();
	}
	public void delete(Integer id) {
		sepo.deleteById(id);
	}
}

