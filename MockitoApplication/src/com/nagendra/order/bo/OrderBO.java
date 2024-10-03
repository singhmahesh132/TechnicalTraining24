package com.nagendra.order.bo;
import com.nagendra.order.bo.exception.BOException;
import com.nagendra.order.dto.Order;

public interface OrderBO 
{
    boolean placeorder(Order order) throws BOException;
    boolean cancelorder(int id) throws BOException;
    boolean deleteorder(int id) throws BOException;
}
