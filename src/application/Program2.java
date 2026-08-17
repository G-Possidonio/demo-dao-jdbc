package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDeparmentDao();
		
		System.out.println("===== TEST 1: department findByID =====");
		Department dep = departmentDao.findById(2);
		System.out.println(dep);
		
		System.out.println();
		
		System.out.println("===== TEST 2: department findAll =====");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		sc.close();
	}

}
