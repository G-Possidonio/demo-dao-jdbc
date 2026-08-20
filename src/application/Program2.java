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

		System.out.println();
		
		System.out.println("===== TEST 3: department insert =====");
		dep = new Department(null, "Agronomy");
		departmentDao.insert(dep);
		System.out.println("Inserted! New id = " + dep.getId());
		
		System.out.println();
		
		System.out.println("===== TEST 4: department update =====");
		dep = departmentDao.findById(8);
		dep.setName("Tecnology");
		departmentDao.update(dep);
		System.out.println("Update completed");
		
		System.out.println();
		
		System.out.println("===== TEST 5: department delete =====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");		

        System.out.println();

        System.out.println("===== TEST 6: department delete - integrity test =====");
        System.out.println("Enter id for integrity test: ");
        id = sc.nextInt();
  	  	try {
            departmentDao.deleteById(id);
            System.out.println("Delete completed");
        }
        catch (DbIntegrityException e) {
			System.out.println("Integrity error! The department cannot be deleted.");
		}
		catch (DbException e) {
    		System.out.println("Database error: " + e.getMessage());
	        sc.close();
		}
}
