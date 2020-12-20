package pet.petshop.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pet.petshop.entity.Blog;
import pet.petshop.entity.Schedule;
import pet.petshop.entity.Services;
import pet.petshop.service.ScheduleService;
import pet.petshop.service.ServiceServices;

@Controller
public class ScheduleController {
	@Autowired
	private ServiceServices ss;
	@Autowired
	private ScheduleService scs;
	@RequestMapping("/confirmservice/{id}")
	public String confirmservice(ModelMap model,@PathVariable(name = "id") Integer id) {
		Services service= ss.get(id);
		Schedule sch = new Schedule();
		model.addAttribute("schedule",sch);
		model.addAttribute("service",service);
		return "service/confirm";
	}
	
	@RequestMapping("/order")
	public String order(@ModelAttribute("schedule") Schedule sch) throws ParseException {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date date = new Date();
		String now = format.format(date);
		String datecheckin = format.format(sch.getDatacheckin());
		
	//	Schedule schedule = new Schedule(sch.getIdservice(), sch.getIduser(), format.parse(now), format.parse(source), sch.getNote());
	//	scs.save(schedule);
		return "index";
	}
}
