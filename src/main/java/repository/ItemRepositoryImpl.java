package repository;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRepositoryImpl implements ItemRepository{
    public ResultSet getAll() throws SQLException {
        String SQL = "SELECT * FROM item";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement psTm = connection.prepareStatement(SQL);
        ResultSet resultSet = psTm.executeQuery();

        return resultSet;
    }

}

