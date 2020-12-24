package pet.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import pet.petshop.entity.Bill;
import pet.petshop.entity.Schedule;
import pet.petshop.entity.User;
import pet.petshop.repository.ScheduleRepository;
import pet.petshop.repository.ScheduleRepository2;

@Service
public class ScheduleService {
	@Autowired
	private ScheduleRepository sr;
	@Autowired
	private ScheduleRepository2 sr2;
	
	
	public List<Schedule> listAll() {
        return sr.findAll();
    }
	
	  public Page<Schedule> listAllPageAdminSchedule(int pageNumber, String sortField, String sortDir) {
	        Sort sort = Sort.by(sortField);
	        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
	        Pageable pageable = PageRequest.of(pageNumber - 1, 6, sort);
	        return sr2.findAll(pageable);
	    }

	
    public Schedule save(Schedule schedule) {
       return sr.save(schedule);
    }

    public Schedule get(Integer id) {
        return sr.findById(id).get();
    }

    public void delete(Integer id) {
        sr.deleteById(id);
    }
    public List<Schedule> ScheduleByUser(User user){
		return sr.findByUser(user);
	}
}
