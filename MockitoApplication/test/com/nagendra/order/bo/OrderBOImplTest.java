package com.nagendra.order.bo;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.nagendra.order.bo.exception.BOException;
import com.nagendra.order.dao.OrderDAO;
import com.nagendra.order.dto.Order;

public class OrderBOImplTest {

	private static final int ORDER_ID = 123;

	@Mock
    OrderDAO dao;

    private OrderBOImpl bo;
    
    @Before
    public void setup()
    {
    	MockitoAnnotations.initMocks(this);
    	bo=new OrderBOImpl();
    	bo.setDao(dao);
    }
    
	@Test
	public void placeOrder_Should_Create_Order() throws SQLException,BOException
	{
		System.out.println("Order Created Successfully");
		
		Order order=new Order();
		
		when(dao.create(order)).thenReturn(new Integer(1));
		boolean result=bo.placeorder(order);
		
		assertTrue(result);
		verify(dao, atLeast(1)).create(order);
	}
	
	@Test
	public void placeOrder_Should_Not_Create_Order() throws SQLException,BOException
	{
		System.out.println("Order Not Created");
		
		Order order=new Order();
		
		// when(dao.create(order)).thenReturn(new Integer(0));
		boolean result=bo.placeorder(order);
		
		assertFalse(result);
		verify(dao).create(order);
	}
	
	@Test(expected = BOException.class)
	public void placeOrder_Should_Throw_Exception() throws SQLException,BOException
	{
		System.out.println("Throwing Exception of Place Order");
		
		Order order=new Order();
		
		when(dao.create(any(Order.class))).thenThrow(SQLException.class);
		boolean result=bo.placeorder(order);
	}
	
	@Test
	public void cancelOrder_Should_Cancel_Order() throws SQLException,BOException
	{
		System.out.println("Order Cancelled Successfully");
		
		Order order=new Order();
		
		when(dao.read(anyInt())).thenReturn(order);
		when(dao.update(order)).thenReturn(1);
		boolean result=bo.cancelorder(123);
		
		assertTrue(result);
		verify(dao).read(anyInt());
		verify(dao).update(order);
	}
	
	@Test
	public void cancelOrder_Should_Not_Cancel_Order() throws SQLException,BOException
	{
		System.out.println("Order Should not Cancelled Successfully");
		
		Order order=new Order();
		
		when(dao.read(ORDER_ID)).thenReturn(order);
		when(dao.update(order)).thenReturn(0);
		boolean result=bo.cancelorder(123);
		
		assertFalse(result);
		verify(dao).read(ORDER_ID);
		verify(dao).update(order);
	}
	
	@Test(expected = BOException.class)
	public void cancelOrder_Should_Throw_Exception_onRead() throws SQLException,BOException
	{
		System.out.println("Throwing Exception of cancel Order on read() method");
		
		when(dao.read(anyInt())).thenThrow(SQLException.class);
		bo.cancelorder(ORDER_ID);
	}
	
	@Test(expected = BOException.class)
	public void cancelOrder_Should_Throw_Exception_onUpdate() throws SQLException,BOException
	{
		System.out.println("Throwing Exception of cancel Order on update() method");
		
		Order order=new Order();
		when(dao.read(ORDER_ID)).thenReturn(order);
		when(dao.update(order)).thenThrow(SQLException.class);
		bo.cancelorder(ORDER_ID);
	}
	
	@Test
	public void deleteOrder_Should_Delete_Order() throws SQLException,BOException
	{
		System.out.println("Order Deleted Successfully");
		
		when(dao.delete(ORDER_ID)).thenReturn(1);
		boolean result=bo.deleteorder(ORDER_ID);
		
		assertTrue(result);
		verify(dao).delete(ORDER_ID);
	}
}
