package com;
 
import static org.junit.Assert.*;
 
import org.junit.Test;
 
public class CalculatorTest
{
    @Test
    public void testAdd()
    {
        Calculator c1 = new Calculator();
        assertEquals(30, c1.add(10, 20));
    }
    @Test
    public void testSub()
    {
        Calculator c1 = new Calculator();
        assertEquals(-10, c1.sub(10, 20));
    }
}