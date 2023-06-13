package com.emp.service;

import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;

import com.emp.entity.Address;
import com.emp.entity.Employee;
import com.emp.exception.GlobalException;

public class EmployeeService {
	List<Employee> employee=new ArrayList<Employee>();
	Scanner sc=new Scanner(System.in);
	
	//method to add employee details in the array list
	public void addEmployee(int empId, String empName, double empSal, String city, String country)
	{
		Address add=new Address(city, country); 
		//Employee emp= new Employee(empId, empName, empSal, null);
		//employee.add(emp);
		employee.add(new Employee(empId, empName, empSal, add));	
	}	
	
	//for testing builder annotetion
	public void addEmp(Employee emp)
	{
		employee.add(emp);
		
	} 
	
	
	public int lengthofList()
	{
		return employee.size();
	}
	
	//method to display employee details using id 
	public Employee displayEmpById(int id) throws GlobalException
	{
		boolean flag = false;
		
		for(int i=0; i<employee.size(); i++)
		{
			if(id==employee.get(i).getEmpId())
			{
				System.out.println("Employee Name:"+employee.get(i).getEmpName());
				System.out.println("Employee ID:"+employee.get(i).getEmpId());
				System.out.println("Employee Salary:"+employee.get(i).getEmpSal());
				System.out.println("Employee Address:"+employee.get(i).getAddress().getCity()+" , " 
													+employee.get(i).getAddress().getCountry());
				flag =true;
				return employee.get(i);
				//break;
				
			}
				
		}
		if(flag!=true)
		{
			throw new GlobalException("Employee not found...");
			
		}
		return null;
	}
	
	//method to delete employee detaild through id 
	public String deleteEmpById(int id) throws GlobalException
	{
		boolean f=false;
		
		for(int i=0; i<employee.size(); i++)
		{
			if(id == employee.get(i).getEmpId())
			{
				employee.remove(i);
				f =true;
				return "Employee details deleted successfully";
				//break;	
			}
		}
		
		//method 1 to update employee using id
		public void updateEmployeeUsingId(int id) throws GlobalException
		{
			boolean flag = false;
			for(int i=0; i<employee.size(); i++)
			{
				if(id==employee.get(i).getEmpId())
				{
					System.out.println("Enter Employee Name:");
					String name=sc.nextLine();
					
					System.out.println("Enter the salary:");
					double sal=sc.nextDouble();
					
					System.out.println("Enter City:");
					String City=sc.nextLine();
					sc.nextLine();
					System.out.println("Enter Country:");
					String Country=sc.nextLine();
					
					Address add=new Address(City, Country);
					employee.set(i, new Employee(id, name, sal, add));
					flag =true;
					break;
				}
			}
			if(flag!=true)
			{
				throw new GlobalException("Employee not found...!");
			}
		}
			
		
		
		//method 2 to update employee using id
		public Employee updateEmp(int id, Employee emp)
		{
			return employee.set(id, emp);
		}
		
		/*
		public Employee updateEmp(int i, Employee e) {
			// TODO Auto-generated method stub
			return null;
			*/
		
		
		//method to delete all the employee details
		public String deleteAllEmployees()
		{
			employee.clear();
			return "All employee details deleted successfully";	
		}
		
		
		if(f==false)
		{
			throw new GlobalException("Employee details not found..!");	
		}
		return null;
			
		}
}
}
