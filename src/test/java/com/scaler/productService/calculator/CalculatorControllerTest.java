package com.scaler.productService.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
@SpringBootTest
public class CalculatorControllerTest {
//    //created a mock of CalculatorService bcz we want to test CalculatorController in isolation
//    private CalculatorService cs= Mockito.mock(CalculatorService.class);//dummy CalculatorService object
//                                or use   @MockBean
//    private CalculatorController calculatorController = new CalculatorController(cs);
    @MockBean
    private CalculatorService cs;
    @Autowired
    private CalculatorController calculatorController;
    @Test
    public void testAddWhenTwoIntegersArePassed(){
        /* If you won't provide "when" and "then"
            actual logic will not be called.
            it will return the default value of that data type
         */

        when(cs.sumFromService(5,10))
                .thenReturn(15);
        //Arrange the data for test case
        int a = 5;
        int b = 10;
        int expectedResult = 15;
        //call the method to test
        int result = calculatorController.add(a, b);
        //assert
        Assertions.assertEquals(expectedResult, result);
    }
    @Test
    public void testAddWhenTwoIntegersArePassed2(){
        when(cs.sumFromService(anyInt(), anyInt()))
                .thenReturn(20);
        int a =10;
        int b =10;
        int expectedResult = 20;
        int result = calculatorController.add(a,b);
        Assertions.assertEquals(expectedResult, result);
    }
}
