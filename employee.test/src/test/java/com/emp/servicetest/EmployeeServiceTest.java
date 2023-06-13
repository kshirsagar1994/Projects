package com.emp.servicetest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setAllowComparingPrivateFields;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;

import com.emp.entity.Address;
import com.emp.entity.Employee;
import com.emp.exception.GlobalException;
import com.emp.service.EmployeeService;

@TestMethodOrder(value = OrderAnnotation.class)
class EmployeeServiceTest {
	
	static EmployeeService empService;

	@BeforeEach
	void setUp() throws Exception {
		empService = new EmployeeService();
	}

	@AfterEach
	void tearDown() throws Exception {
		empService = null;
		System.out.println("The Object is Garbage Collected.. ");
	}
	
	@Test
	@DisplayName("Testign add employee method")
	void testAddEmployee()
	{
		//WAY 1
		//empService.addEmployee(101, "Aishwary", 50000, "Pune", "india");
		//empService.addEmployee(107, "Ajay", 55000, "Banglore", "India");
		//assertEquals(2, empService.lengthofList());
		//assertNotNull(empService.lengthofList());
		
		//WAY 2
		Address add= Address.builder().city("Pune").country("India").build();
		Employee.builder().empId(101).empName("Aishwarya").empSal(50000).address(add).build();
		
		empService.addEmp(null);
		//assertThat(empService.lengthofList()>0).isTrue();
		assertThat(empService.lengthofList()).isEqualTo(1);
		
	}
	
	@Test
	void testDisplayEmpById() throws GlobalException 
	{
		Address add= Address.builder().city("Banglore").country("India").build();
		Employee  emp = Employee.builder().empId(109).empName("Ajay").empSal(70000).address(add).build();
		
		
		empService.addEmp(emp);
		//assertEquals("Ajay", empService.displayEmpById(109).getEmpName());
		Employee e= empService.displayEmpById(102);
		assertThat(e.getEmpSal()).isEqualByComparingTo(70000.0);
	}
	
	@Test
	void testDeleteEmpById() throws GlobalException
	{
		Address add= Address.builder().city("Channai").country("India").build();
		Employee emp= Employee.builder().empId(119).empName("Susmit").empSal(65000).address(add).build();
		
		empService.addEmp(emp);
		String s= empService.deleteEmpById(119);
		//Employee e= empService.displayEmpById(102);
			//assertThrows(GlobalException.class, () ->
		//empService.displayEmpById(119));
		
		assertEquals("Employee details deleted successfully", s);
	
	}
	/*
	@Test
	void testUpdateEmployee() throws GlobalException
	{
		Address add= Address.builder().city("LA").country("USA").build();
		Employee emp= Employee.builder().empId(111).empName("Rushikesh").empSal(1000).address(add).build();
		empService.updateEmployeeUsingId(111);
		assertEquals("Rishikesh",empService.displayEmpById(111).getEmpName());
		
	}
	*/
	
	@Test
	@Order(3)
	void testUpdateEmp() throws GlobalException
	{
		empService.addEmployee(120, "Priyanka", 1000, "Delhi", "India");
		Employee e = empService.displayEmpById(120);
		e.setEmpName("Priyanka Jadhav");
		
		Employee updEmp = empService.updateEmp(0, e);
		assertThat(updEmp.getEmpName()).isEqualTo("Priyanka Jadhav");
		
	}
	
	@Test
	@Order(5)
	void testDeleteAll()
	{
		empService.addEmployee(121,"Aditi" ,80000, "Banglore","india");
		empService.addEmployee(122,"Vinayak" ,90000, "Pune","india");
		
		assertEquals("All employee details deleted successfully", empService.deleteAllEmployees());
	}
	
	
	@Test
	@Order(6)
	@DisplayName("Negative Test Case")
	void testNegativeUpdateEmp() throws GlobalException
	{
		empService.addEmployee(120,"Priyanka" ,100000, "Delhi","india");
		Employee e=empService.displayEmpById(120);
		e.setEmpName("Priyaka jadhav");
		
		Employee updEmp= empService.updateEmp(0, e);
		assertThat(updEmp.getEmpName()).isEqualTo("Priyanka");
		
	}

   } 
