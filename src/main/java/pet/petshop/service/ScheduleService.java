package pet.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.petshop.entity.Bill;
import pet.petshop.entity.Schedule;
import pet.petshop.entity.User;
import pet.petshop.repository.ScheduleRepository;

@Service
public class ScheduleService {
	@Autowired
	private ScheduleRepository sr;
	
	public List<Schedule> listAll() {
        return sr.findAll();
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
