package org.mahesh;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//By default, it is method i.e. instance of CalculatorTest will be created for every method.
@DisplayName("Calculator Test for Arithmetic operations")
//Used to display the name for this test class, can be seen on run terminal
class CalculatorTest {

    static Calculator c1;
    static boolean condition;

    public CalculatorTest() {
        System.out.println("Calculator Test instance is created");
    }

    @BeforeAll      //Will be executed only once in the beginning after constructor, used to initiate objects
    static void onlyOnceInBeginning(){
        c1 = new Calculator();
        condition = true;
        System.out.println("Executed only once in start");
    }

    @AfterAll      //Will be executed only once in the end used to free the objects
    static void onlyOnceInEnd(){
        c1 = null;
        System.out.println("Executed only once in end");
    }

    @BeforeEach     //Executed before every @Test methods
    void initializeBeforeEach(){
        System.out.println("Executed before each test");
    }

    @AfterEach      //Executed after every @Test methods
    void afterEach(){
        System.out.println("Executed after each test");
    }

    @Test
    @DisplayName(" test")
    @Tag("General")
    //Tags can be used to execute only specific set of tags for testing scenarios
    // by passing tag name in configuration while running the test class.
    void test(){
        System.out.println("test() is called");
        assertTrue(true);
    }

    @Test
    @DisplayName("Add test")
    @Tag("Math")
    void testAdd(){
        System.out.println("testAdd() is called");
        int actual = c1.add(100, 200);
        int expected = 300;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Sub test")
    @Tag("Math")
    void testSub(){
        System.out.println("testSub() is called");
        assertEquals(200, c1.sub(400,200));
        assertEquals(-100, c1.sub(100,200));
    }

    @Test
    @DisplayName("Div test")
    @Tag("Math")
    void testDiv(){
        System.out.println("testDiv() is called");
        assertThrows(ArithmeticException.class, ()->c1.div(100,0)); //Used when if you do not want yor asserEquals to throw exception
        assertThrows(ArithmeticException.class, ()->c1.div(40,0));
        assertThrows(ArithmeticException.class, ()->c1.div(0,0));
        assertEquals(2, c1.div(200,100));
    }

    @Test
    @DisplayName("Mul test")
    @Tag("Math")
    void testMul(){
        System.out.println("testMul() is called");
        assertEquals(2, c1.mul(2,1));
        assertEquals(10, c1.mul(2,5));
    }

    @Test
    @Tag("OS")
    @EnabledOnOs(OS.WINDOWS)  //Used when you want certain Test() to run based on OS
    void onlyOnWindows(){
        System.out.println("onlyOnWindows() will be executed only on Windows");
    }

    @Test
    @Tag("OS")
    @EnabledOnOs(OS.LINUX)
    void onlyOnLinux(){
        System.out.println("onlyOnLinux() will be executed only on Linux");
    }

    @Test
    @Tag("JAVA_VERSION")
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_11) //Used when you want to run Test() on specific java Version.
    void testLambdaExpression(){
        //write lambda
        System.out.println("testLambdaExpression() called");
    }
}