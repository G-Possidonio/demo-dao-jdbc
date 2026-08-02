package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Department obj = new Department(1, "Teste");
		System.out.println(obj);
		
		Seller sel = new Seller(1,"Gs", "Gs@gmail.com", new Date(), 3000.0, obj);
		System.out.println(sel);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
	}

}
