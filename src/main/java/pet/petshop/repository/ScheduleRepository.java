package pet.petshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import pet.petshop.entity.Schedule;
import pet.petshop.entity.User;

public interface ScheduleRepository extends JpaRepository<Schedule,Integer>{
	List<Schedule> findByUser(User user);
}
