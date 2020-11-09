package pet.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.petshop.entity.Servicecategories;
import pet.petshop.repository.ServiceCategoriesRespository;

@Service
public class ServiceCategoriesService {

  @Autowired
  private ServiceCategoriesRespository spo;

  public List<Servicecategories> listAll() {
    return spo.findAll();
  }

  public void save(Servicecategories servicecategories) {
    spo.save(servicecategories);
  }

  public Servicecategories get(Integer id) {
    return spo.findById(id).get();
  }

  public void delete(Integer id) {
    spo.deleteById(id);
  }
}
