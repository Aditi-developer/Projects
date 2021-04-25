package com.example.project.restcontroller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.classes.PageCounter;
import com.example.project.models.FormDataModel;
import com.example.project.repository.SchoolDBRepository;

@RestController
public class MVCRestController {

	@Autowired
	SchoolDBRepository schoolDBRepository;
	
	@Autowired
	PageCounter pageCounter;
	
	@RequestMapping("/attr")
	public List<String> filterListByAttr(@RequestParam 
			Optional<String> attr) {
		List<String> arrList=new ArrayList<String>();
		arrList.add("Please enter valid attr.For example:"
				+ "http://localhost:8080/attr?attr=coursename"+"or http://localhost:8080/attr?attr=collegename"+
				"or http://localhost:8080/attr?attr=collegeid");
		
		System.out.println(""
				+ "Optional parmater is  "+attr.get());
		String attrValue = attr.get();
	if(attrValue!=null && !attrValue.isEmpty()) {
			
			  List<FormDataModel>frmList= (List<FormDataModel>)
					  schoolDBRepository.findAll();
			 
		
		if(attrValue.equalsIgnoreCase("schoolID")) {
			return frmList.stream().map(FormDataModel::getSchoolID).collect(Collectors.toList());

		}else if(attrValue.equalsIgnoreCase("schoolName")) {
			return frmList.stream().map(FormDataModel::getSchoolName).collect(Collectors.toList());

		}else if(attrValue.equalsIgnoreCase("courseName")) {
			return frmList.stream().map(FormDataModel::getCourseName).collect(Collectors.toList());
	
		}
	}
	return arrList;
	}
	

	@RequestMapping("/pageHits")
	public String pageHits() {
		return "Number of page hits are "+pageCounter.getCurrentPageCount();
	}
	
	@Scheduled(fixedRate = 3000)
	public void fixedRateSch() { 
		pageHits();
	      Calendar cal = Calendar.getInstance();
	      SimpleDateFormat simpleformat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");
	      //System.out.println("Executing after every three seconds "+simpleformat.format(cal.getTime()));
		
	}
}
