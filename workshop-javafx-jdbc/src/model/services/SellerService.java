package model.services;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerService {
	
	SellerDao dao = DaoFactory.createSellerDao(); 

	public List<Seller> findAll() {
//		List<Department> list = new ArrayList<>();
//		
//		list.add(new Department(1, "Tech"));
//		list.add(new Department(2, "Fruits"));
//		list.add(new Department(3, "Home Sweet Home"));
//		System.out.println("Hey!!!");
//		dao.findAll().forEach(e -> System.out.println(e.getName()));
		return dao.findAll();
	}
}
