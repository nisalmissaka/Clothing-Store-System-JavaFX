package service;

import dto.Order;

import java.sql.Connection;

public interface OrderService {
    boolean addOrder(Connection connection, Order order);

}
