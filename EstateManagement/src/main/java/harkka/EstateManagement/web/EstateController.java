package harkka.EstateManagement.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import harkka.EstateManagement.domain.Estate;
import harkka.EstateManagement.domain.EstateRepository;
import harkka.EstateManagement.domain.ManagementRepository;

@Controller
public class EstateController {
	
	@Autowired
	private EstateRepository eRepository;
	
	@Autowired
	private ManagementRepository mRepository;
	
	@RequestMapping(value= {"/", "/estatelist"})
	public String estatelist(Model model) {
		model.addAttribute("estates", eRepository.findAll());
		return "estatelist";
	}
		 
    @PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/addEstate")
    public String addEstate(Model model){
    	model.addAttribute("addEstate", new Estate());
    	model.addAttribute("managements", mRepository.findAll());
        return "addestate";
    }

    @RequestMapping(value = "/saveEstate", method = RequestMethod.POST)
    public String save(Estate estate){
        eRepository.save(estate);
        return "redirect:estatelist";
    } 
	
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/deleteEstate/{id}", method = RequestMethod.GET)
    public String deleteEstate(@PathVariable("id") Long estate_id, Model model) {
    	eRepository.deleteById(estate_id);
        return "redirect:../estatelist";
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/editEstate/{id}")
    public String editEstate(@PathVariable("id") Long estate_id, Model model){
    	model.addAttribute("editEstate", eRepository.findById(estate_id));
    	model.addAttribute("managements", mRepository.findAll());
        return "editestate";
    }
    
}
