package com.example.project.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.project.classes.PageCounter;
import com.example.project.models.ContactUsModel;
import com.example.project.models.FormDataModel;
import com.example.project.repository.ContactUsRepository;
import com.example.project.repository.SchoolDBRepository;

@Controller
public class MVCController {

	@Autowired
	SchoolDBRepository schoolDBRepository;
	@Autowired
	ContactUsRepository conatctUsRepository;
	@Autowired
	PageCounter pageCounter;

	public int pageHits = 0;

	@RequestMapping("/")
	public String indexPage(@ModelAttribute("formValidation") FormDataModel formValidation, Model model) {
		pageCounter.incrementPageCounter();
		model.addAttribute("pageCount", pageCounter.getCurrentPageCount());
		return "index";
	}
	
	@RequestMapping("/contact")
	public String contactPage(@ModelAttribute("contactUs") ContactUsModel contactUs, Model model) {
		pageCounter.incrementPageCounter();
		model.addAttribute("pageCount", pageCounter.getCurrentPageCount());
		return "contact";
	}
	
	
	@RequestMapping("/about")
	public String aboutPage(Model model) {
		pageCounter.incrementPageCounter();
		model.addAttribute("pageCount", pageCounter.getCurrentPageCount());
		return "about";
	}

	@PostMapping("/form_validation")
	public String formValidation(@Valid @ModelAttribute("formValidation") FormDataModel formValidation,
			BindingResult bindingResult) {

		System.out.println(formValidation.toString());
		if (bindingResult.hasErrors()) {
			System.out.println("Errors found");
			return "index";
		}

		FormDataModel fm = schoolDBRepository.save(formValidation);
		System.out.println("success db " + fm.getSchoolID());
		return "redirect:/schoolList";
	}

	@RequestMapping("/schoolList")
	public String schoolList(Model model) {

		pageCounter.incrementPageCounter();
		model.addAttribute("pageCount", pageCounter.getCurrentPageCount());
		List<FormDataModel> frmList = (List<FormDataModel>) schoolDBRepository.findAll();
		model.addAttribute("schoolList", frmList);
		System.out.println("Size is " + frmList.size());
		return "schoolList";
	}

	@PostMapping("/contact_us")
	public String contactUs(@Valid @ModelAttribute("contactUs") ContactUsModel contactUs, BindingResult bindingResult) {
		System.out.println(contactUs.toString());
		if (bindingResult.hasErrors()) {
			System.out.println("Errors found");
			return "index";
		}

		ContactUsModel cu = conatctUsRepository.save(contactUs);
		System.out.println("success db " + cu.getId());
		return "redirect:/";
	}
	
	@RequestMapping("/statics")
	public String statics(Model model) {

		pageCounter.incrementPageCounter();
		model.addAttribute("pageCount", pageCounter.getCurrentPageCount());
		HashMap<String, Integer> map = new HashMap<>();
		List<FormDataModel> frmList = (List<FormDataModel>) schoolDBRepository.findAll();
		for(FormDataModel form : frmList) {
			map.put(form.courseName, map.getOrDefault(map.get(form.getCourseName()), 0)+1);
		}
		model.addAttribute("map", map);
		System.out.println("Size is " + map.size());
		return "statics";
	}


}
