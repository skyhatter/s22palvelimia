package harkka.EstateManagement.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import harkka.EstateManagement.domain.Estate;
import harkka.EstateManagement.domain.EstateRepository;

@RestController
public class EstateRestController {
	
	@Autowired
	EstateRepository eRepository;
	
	@GetMapping("/estates")
	public Iterable<Estate> getEstates() {
		return eRepository.findAll();
	}
	
	@GetMapping("/estates/{id}")
	public @ResponseBody Optional<Estate> findEstateRest(@PathVariable("id") Long estate_id) {	
	    return eRepository.findById(estate_id);
	}
	
	@PostMapping("estates")
	Estate addestate(@RequestBody Estate addestate) {
		return eRepository.save(addestate);
	}
	
	@PutMapping("/estates/{id}")
	Estate editestate(@RequestBody Estate editestate, @PathVariable Long estate_id) {
		editestate.setEstate_id(estate_id);
		return eRepository.save(editestate);
	}
	
	@DeleteMapping("/estates/{id}")
	void deleteestate(@PathVariable Long estate_id) {
		eRepository.deleteById(estate_id);
	}
	
}
