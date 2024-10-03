package com.nagendra.order.bo;

import java.sql.SQLException;

import com.nagendra.order.bo.exception.BOException;
import com.nagendra.order.dao.OrderDAO;
import com.nagendra.order.dto.Order;

public class OrderBOImpl implements OrderBO {
	private OrderDAO dao;

	@Override
	public boolean placeorder(Order order) throws BOException {
		try {
			int result = dao.create(order);
			if (result == 0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	@Override
	public boolean cancelorder(int id) throws BOException {
		try {
			Order order = dao.read(id);
			order.setStatus("Cancelled");
			int result = dao.update(order);
			if (result == 0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	@Override
	public boolean deleteorder(int id) throws BOException {
		try {
			int result = dao.delete(id);
			if (result == 0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	public OrderDAO getDao() {
		return dao;
	}

	public void setDao(OrderDAO dao) {
		this.dao = dao;
	}
}
