package model.services;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentService {
	
	DepartmentDao dao = DaoFactory.createDepartmentDao(); 

	public List<Department> findAll() {
//		List<Department> list = new ArrayList<>();
//		
//		list.add(new Department(1, "Tech"));
//		list.add(new Department(2, "Fruits"));
//		list.add(new Department(3, "Home Sweet Home"));
//		System.out.println("Hey!!!");
//		dao.findAll().forEach(e -> System.out.println(e.getName()));
		return dao.findAll();
	}
	
	public void saveOrUpdate(Department department) {
		if (department.getId() == null) {
			dao.insert(department);
		} else {
			dao.update(department);
		}
	}
}
