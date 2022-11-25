package harkka.EstateManagement.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import harkka.EstateManagement.domain.Management;
import harkka.EstateManagement.domain.ManagementRepository;

@Controller
public class ManagementController {
	
	@Autowired
	ManagementRepository mRepository;
	
	@GetMapping("managementlist")
	public String getManagements(Model model) {
		model.addAttribute("managements", mRepository.findAll());
		return "managementlist";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("addManagement")
	public String addManagement(Model model) {
		model.addAttribute("addManagement", new Management());
		return "addmanagement";
	}

	@PostMapping("saveManagement")
	public String saveManagement(@Valid Management management, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("some error happened");
			return "addmanagement";
		}
		mRepository.save(management);
		return "redirect:managementlist";
	}
	
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/deleteManagement/{id}", method = RequestMethod.GET)
    public String deleteManagement(@PathVariable("id") Long management_id, Model model) {
    	mRepository.deleteById(management_id);
        return "redirect:../managementlist";
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/editManagement/{id}")
    public String editManagement(@PathVariable("id") Long management_id, Model model){
    	model.addAttribute("editManagement", mRepository.findById(management_id));
        return "editmanagement";
    }
}
