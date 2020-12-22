package pet.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pet.petshop.dto.BillinfoDTO;
import pet.petshop.service.BillInfoService;

@RestController
@RequestMapping("/api/billinfo")
public class BillInfoRestcontroller {

	@Autowired
	private BillInfoService bs;
	
	@RequestMapping(value = "/getall", method = RequestMethod.GET, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<Iterable<BillinfoDTO>> CountItembyid(){
		try {
			return new ResponseEntity<Iterable<BillinfoDTO>>(bs.listBillDTO(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<BillinfoDTO>>(bs.listBillDTO(),HttpStatus.BAD_REQUEST);
		}
	}
}
