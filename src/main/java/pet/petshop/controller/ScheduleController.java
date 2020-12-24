package pet.petshop.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pet.petshop.entity.Bill;
import pet.petshop.entity.Blog;
import pet.petshop.entity.Schedule;
import pet.petshop.entity.Services;
import pet.petshop.entity.User;
import pet.petshop.service.ScheduleService;
import pet.petshop.service.ServiceServices;

@Controller
public class ScheduleController {
	@Autowired
	private ServiceServices ss;
	@Autowired
	private ScheduleService scs;
	
	
	@RequestMapping("/schedule")
	public String index(ModelMap model) {
		return listByPageAdminSchedule(model, 1, "idschedule", "desc");
	}
	
	 @GetMapping("/schedule-page/{pageNumber}")
		public String listByPageAdminSchedule(ModelMap model,
				@PathVariable("pageNumber") int currentpage,
				@Param("sortField") String sortField,
				@Param("sortDir") String sortDir) {
			
			Page<Schedule> page = scs.listAllPageAdminSchedule(currentpage, sortField, sortDir);
			long totalItems = page.getTotalElements();
			int totalPages = page.getTotalPages();
			int totalItemsInpage = page.getNumberOfElements();
			
			List<Schedule> list = page.getContent();
			model.addAttribute("currentpage", currentpage);
			model.addAttribute("schedulelist", list);
			model.addAttribute("sortField", sortField);
			model.addAttribute("sortDir", sortDir);
			model.addAttribute("totalItems",totalItems);
			model.addAttribute("totalPages",totalPages);
			model.addAttribute("totalItemsInpage",totalItemsInpage);
			
			String reverseSortDir = sortDir.equals("asc") ? "desc"  : "asc" ;
			model.addAttribute("reverseSortDir",reverseSortDir);
			return "admin/schedule/index";
			
		}
	
	@RequestMapping("/confirmservice/{id}")
	public String confirmservice(ModelMap model,HttpSession session,@PathVariable(name = "id") Integer id) {
		Services service= ss.get(id);
		Schedule sch = new Schedule();
		
		serid = id;
		model.addAttribute("schedule",sch);
		
		model.addAttribute("service",service);
		return "service/confirm";
	}
	int serid=0;
	@RequestMapping("/order")
	public String order(@ModelAttribute("schedule") Schedule sch,HttpSession session) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String now = format.format(date);
		String datecheckin = format.format(sch.getDatacheckin());
		User user = (User) session.getAttribute("user");
		if(user == null) {
			return "redirect:/login";
		}
		Schedule schedule = new Schedule(serid, user.getId(), format.parse(now), format.parse(datecheckin), sch.getNote());
		scs.save(schedule);
		return "redirect:/";
	}
	
	@RequestMapping("/schedulehistory")
	public String billhistory(ModelMap model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		model.addAttribute("history", scs.ScheduleByUser(user));
		return "index/lichsudichvu";
	}
}
