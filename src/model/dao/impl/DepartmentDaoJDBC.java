package model.dao.impl;

import db.DB;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "INSERT INTO department " +
                            "(Name) " +
                            "VALUES " +
                            "(?)");
            st.setString(1, obj.getName());

            int rows = st.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }
    @Override
    public void update(Department obj) {

        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                        "UPDATE department " +
                        "SET Name = ? " +
                        "WHERE Id = ? ");
            st.setString(1, obj.getName());
            st.setInt(2, obj.getId());

            st.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "DELETE FROM department WHERE Id = ?");
            st.setInt(1, id);

            st.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Department findById(Integer id) {

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT Id, Name FROM department WHERE Id = ? ");
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()) {
                Department dep = new Department(id, rs.getString("Name"));
                return dep;
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        return null;
    }

    @Override
    public List<Department> findAll() {

        try {
            PreparedStatement st = null;
            ResultSet rs = null;
            List<Department> list = new ArrayList<>();

            st = conn.prepareStatement("SELECT Id, Name FROM department");

            rs = st.executeQuery();

            while(rs.next()){
                list.add(new Department(rs.getInt("Id"), rs.getString("Name")));
            }
            DB.closeStatement(st);
            DB.closeResultSet(rs);
            return list;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return null;
    }
}
