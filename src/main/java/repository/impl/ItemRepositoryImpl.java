package repository.impl;

import db.DBConnection;
import dto.Customer;
import dto.Item;
import repository.ItemRepository;

import java.sql.*;

public class ItemRepositoryImpl implements ItemRepository {



    @Override
    public void AddItem(Item item) throws SQLException {

        String sql =
                "INSERT INTO item ( ItemCode ,Description  , ItemSize   ,  ItemPrice , Discount , Quantity ) " +
                        "VALUES (?,?,?,?,?,?)";

        Connection con = DBConnection.getInstance().getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, item.getItemCode());
        ps.setString(2, item.getDescription());
        ps.setString(3, item.getItemSize());
        ps.setDouble(4, item.getItemPrice());
        ps.setDouble(5, item.getDiscount());
        ps.setInt(6, item.getQuantity());

        ps.executeUpdate();
    }

    @Override
    public ResultSet getAllItem() throws SQLException {
        String SQL = "SELECT * FROM item";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement psTm = connection.prepareStatement(SQL);
        ResultSet resultSet = psTm.executeQuery();
        return resultSet;
    }


    @Override
    public Customer getCustomer(String text) {
        return null;



    }


        @Override
        public boolean DeleteItemCode(String itemCode) throws SQLException {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "DELETE FROM item WHERE ItemCode = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, itemCode);

            int rowsAffected = ps.executeUpdate();  // IMPORTANT

            return rowsAffected > 0;   // true = deleted, false = not found


    }

}









