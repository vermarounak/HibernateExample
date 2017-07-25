package com.tcs.HibernateExample.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.tcs.HibernateExample.Controller.HibernateExampleController;
import com.tcs.HibernateExample.DTO.UsersDTO;
import com.tcs.HibernateExample.Service.HibernateExampleService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HibernateExampleController.class, secure = false)
public class HibernateExampleControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private HibernateExampleService hibernateExampleService;

	@Test
	public void readAllOperation() {

		/* --------------- Test Data -------------------- */
		List<UsersDTO> usersList = new ArrayList<>();
		usersList.add(new UsersDTO(104, "Rounak Verma TCS", "669517", LocalDate
				.now()));
		usersList.add(new UsersDTO(109, "updateduser23rdJuly", "Admin",
				LocalDate.now()));

		String expectedResult = "[{userId:104,userName:Rounak Verma TCS,createdBy:669517},{userId:109,userName:updateduser23rdJuly,createdBy:Admin}]";
		/* --------------- Test Data -------------------- */

		try {
			Mockito.when(hibernateExampleService.readAllOperation())
					.thenReturn(usersList);

			RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					"/springplushibernate/readAll").accept(
					MediaType.APPLICATION_JSON_VALUE);
			MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

			System.out.println("Call response ---->>>>> "
					+ mvcResult.getResponse());

			JSONAssert.assertEquals(expectedResult, mvcResult.getResponse()
					.getContentAsString(), false);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void readSpecificOperation() {
		/* --------------- Test Data -------------------- */
		UsersDTO usersDTO = new UsersDTO(104, "Rounak Verma TCS", "669517",
				LocalDate.now());

		String inputString = "{\"userId\":104}";

		String expectedResult = "{userId:104,userName:Rounak Verma TCS,createdBy:669517}";
		/* --------------- Test Data -------------------- */

		try {

			Mockito.when(
					hibernateExampleService.readSpecificOperation(Mockito
							.anyInt())).thenReturn(usersDTO);

			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post("/springplushibernate/read")
					.accept(MediaType.APPLICATION_JSON).content(inputString)
					.contentType(MediaType.APPLICATION_JSON);

			MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

			JSONAssert.assertEquals(expectedResult, mvcResult.getResponse()
					.getContentAsString(), false);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
