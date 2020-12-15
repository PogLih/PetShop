package pet.petshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pet.petshop.entity.User;
import pet.petshop.repository.UserRepository;
import pet.petshop.repository.UserRepository2;

@Service
@Transactional
public class UsersService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRepository2 ur2;
    
 
  
  public Page<User> listAllPageAdminUser(int pageNumber, String sortField, String sortDir) {
    	Sort sort = Sort.by(sortField);
    	sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, 6,sort);
    	return ur2.findAll(pageable);
    }
    
    public List<User> listAll() {
        return userRepository.findAll();
    }

    public void save(User ur) {
        userRepository.save(ur);
    }

    public User get(int id) {
        return userRepository.findById(id).get();
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }

    public List<User> findAllByEmailContain(String email) {
        return userRepository.findAllByEmailContaining(email);
    }
    
}
