package pet.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pet.petshop.dto.BillDTO;

import pet.petshop.dto.BillStatusDTO;
import pet.petshop.service.BillService;

@RestController
@RequestMapping("/api/bill")
public class BillRestController {
	@Autowired
	private BillService billService;
	
	@ResponseBody
	@RequestMapping(value = "/findall",method = RequestMethod.GET, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<Iterable<BillDTO>> listallm()
	{
		try {
			billService.listBillDTO().forEach(e -> System.out.println(e.toString()));
			return new ResponseEntity<Iterable<BillDTO>>(billService.listBillDTO(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	@RequestMapping(value = "/countstatus",method = RequestMethod.GET, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<Iterable<BillStatusDTO>> countstatus()
	{
		try {
			return new ResponseEntity<Iterable<BillStatusDTO>>(billService.countstatus(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<BillStatusDTO>>(billService.countstatus(),HttpStatus.BAD_REQUEST);
		}
		
	}
}
