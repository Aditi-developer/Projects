package com.example.project;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.project.classes.PageCounter;
import com.example.project.controller.MVCController;
import com.example.project.models.FormDataModel;
import com.example.project.repository.SchoolDBRepository

@WebMvcTest(MVCController.class)
class TestClass {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	SSchoolDBRepositoryollegeDB;

	@MockBean
	PageCounter pageCounter;

	@Test
	void indexPageTest() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(view().name("index"))
				.andExpect(model().attribute("pageCount", 0));
	}

	@Test
	void collegeListPageTest() throws Exception {
		this.mockMvc.perform(get("/collegeList")).andDo(print()).andExpect(status().isOk())
				.andExpect(view().name("collegelist"));
	}

	@Test
	void pageHitsTest() throws Exception {
		this.mockMvc.perform(get("/pageHits")).andDo(print()).andExpect(status().isOk())
				.andExpect((ResultMatcher) content().string("PageHits count is"));
	}

	@Test
	void DBTest() throws Exception {
		FormDataModel formDataModel = new FormDataModel(5464646l, "C075984545", "Windsor university",
				"Database management");
		this.mockMvc.perform(post("/form_validation", formDataModel)).andDo(print()).andExpect(status().isOk())
				.andExpect(view().name("collegeList"));

		Mockito.verify(collegeDB).save(formDataModel);
	}

}
