package com.sample.controller;

import com.sample.model.ListEmployeesResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sample.model.Employee;
import com.sample.model.Status;
import com.sample.services.DataServices;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class AppController {
	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(AppController.class);

	/* Submit form in Spring Restful Services */
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status addEmployee(@RequestBody Employee employee) {
		try {
			dataServices.addEntity(employee);
			return new Status(1, "Employee added Successfully !","SUCCESS");
		} catch (Exception e) {
			e.getMessage();
			return new Status(0, "Error occurred while creating !","FAILURE");
		}

	}

	/* Ger a single objct in Json form in Spring Rest Services */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ListEmployeesResponse getEmployee(@PathVariable("id") Long id) {
		List employeeList = new ArrayList();
		Employee employee = null;
		try {
			employee = dataServices.getEntityById(id);
			employeeList.add(employee);
			return new ListEmployeesResponse(1, "Employee fetched Successfully !","SUCCESS",employeeList);

		} catch (Exception e) {
			e.getMessage();
			return new ListEmployeesResponse(0, "No data found !","SUCCESS",null);
		}
	}

	/* Getting List of objects in Json format in Spring Restful Services */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody ListEmployeesResponse getEmployee() {

		List employeeList = null;
		try {
			employeeList = dataServices.getEntityList();
			return new ListEmployeesResponse(1, "Employee fetched Successfully !","SUCCESS",employeeList);

		} catch (Exception e) {
			e.getMessage();
			return new ListEmployeesResponse(0, "No data found !","SUCCESS",null);
		}
	}

	/* Delete an object from DB in Spring Restful Services */
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Status deleteEmployee(@PathVariable("id") long id) {

		try {
			dataServices.deleteEntity(id);
			return new Status(1, "Employee deleted Successfully !","SUCCESS");
		} catch (Exception e) {
			return new Status(0, "Employee not found !","FAILURE");
		}

	}
}
