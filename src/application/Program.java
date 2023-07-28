package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Date;

public class Program {
    public static void main(String[] args) {

        Department obj = new Department(1, "BOOKS");

        Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println(seller);
    }
}
