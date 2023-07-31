package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class Program2 {
    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("\n===TEST 1: Department Insert ===");
        Department department = new Department(null, "tablets");
        departmentDao.insert(department);
        System.out.println("Inserted");

        System.out.println("\n===TEST 3: Department findById ===");
        Department departmentId = departmentDao.findById(2);
        System.out.println(departmentId);
        System.out.println("Found");

        System.out.println("\n===TEST 2: Department Update ===");
        Department depUpdade = departmentDao.findById(2);
        depUpdade.setName("Mouses");
        departmentDao.update(depUpdade);
        System.out.println("Updated");

        System.out.println("\n===TEST 4: Department Delete ===");
        departmentDao.deleteById(12);
        System.out.println("Deleted");

        System.out.println("\n===TEST 5: Department findAll ===");

        List<Department> listDepartment = departmentDao.findAll();

        for(Department l: listDepartment){
            System.out.println(l);
        }





    }

}
