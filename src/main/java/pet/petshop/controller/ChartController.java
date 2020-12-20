package pet.petshop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pet.petshop.entity.Bill;
import pet.petshop.entity.BillInfo;
import pet.petshop.entity.Item;
import pet.petshop.repository.BillRepository;
import pet.petshop.service.BillInfoService;

@Controller
public class ChartController {

	@Autowired
	private BillInfoService bis;
	
	
	
	/*
	 * //for high chart
	 * 
	 * @GetMapping("/getHighChartDetailsDepartMentWise") public String
	 * getDepartmentWiseDetails(ModelMap modelMap) { List<BillInfo> bif =
	 * bis.listAll(); //List<EmployeeModel> emp =
	 * employeerepositery.findCityCount(); //List<EmployeeModel> emp1=
	 * employeerepositery.findStateCount(); modelMap.addAttribute("name", bif);
	 * modelMap.addAttribute("state", emp1); modelMap.addAttribute("barchart",
	 * deptDetails); return "highChart"; }
	 */
	
}
