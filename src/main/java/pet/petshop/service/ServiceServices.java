package pet.petshop.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import pet.petshop.entity.Services;
import pet.petshop.repository.ServiceRespository;
import pet.petshop.repository.ServiceRespository2;
@Service
public class ServiceServices {
	@Autowired
	private ServiceRespository sepo;
	@Autowired
	private ServiceRespository2 sepo2;
	
	  public Page<Services> listAllPageService(int pageNumber) {
	    	Sort sort = Sort.by("id").descending();
	        Pageable pageable = PageRequest.of(pageNumber - 1, 4,sort);
	    	return sepo2.findAll(pageable);
	    }
	  
	  public Page<Services> listAllPageAdminService(int pageNumber, String sortField, String sortDir) {
	    	Sort sort = Sort.by(sortField);
	    	sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
	        Pageable pageable = PageRequest.of(pageNumber - 1, 6,sort);
	    	return sepo2.findAll(pageable);
	    }
	public List<Services> listALl(){
		return sepo.findAll();
	}
	public Services save(Services services) {
		return sepo.save(services);
	}
	public Services get(Integer id) {
		return sepo.findById(id).get();
	}
	public void delete(Integer id) {
		sepo.deleteById(id);
	}
	public List<Services> name (String name) {
		return
		sepo.findAllByNameContaining(name);

	}
}

