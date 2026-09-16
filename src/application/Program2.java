package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		DepartmentDAO departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TEST 1: findById ====");
		Department dep = departmentDao.findbyId(1);
		System.out.println(dep);
		
		System.out.println("=== TEST 2: findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}

		System.out.println("=== TEST 3: insert ===");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
	

		System.out.println("=== TEST 4: update ===");
		Department dep2 = departmentDao.findbyId(1);
		dep2.setName("Adm");
		departmentDao.update(dep2);
	
		
		System.out.println("=== TEST 5: delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		

		sc.close();
	}
}