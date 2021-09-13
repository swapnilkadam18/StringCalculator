package com.swapnil.stringcalculator.model;

import junit.framework.TestCase;

import org.junit.Assert;

import static org.junit.Assert.assertThrows;

public class CalcRepoTest extends TestCase {
    CalcRepo repo;

    public void setUp() throws Exception {
        super.setUp();
        repo = new CalcRepo();
    }

    public void tearDown() throws Exception {
    }

    public void testAdd() throws Exception {
        String input = "//***\\n1***2***3";
        int num = repo.add(input);
        Assert.assertEquals(6,num);

        input = "//$,@\\n1$2@3";
        num = repo.add(input);
        Assert.assertEquals(6,num);

        input = "";
        num = repo.add(input);
        Assert.assertEquals(0,num);

        String finalInput = "//@\\n-2@3@8";
        Exception exception = assertThrows(Exception.class, () -> {
            repo.add(finalInput);
        });
        String expectedMessage = "Negatives not allowed. : -2";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));



    }

    public void testIsNumNegative() {
        String input = "absb,-123,.teqkljk";
        int num = repo.isNumNegative(input);
        Assert.assertEquals(-123,num);

        input = "12345-123";
        num = repo.isNumNegative(input);
        Assert.assertEquals(-123,num);

        input = "//$,@\\n-1120$2@3";
        num = repo.isNumNegative(input);
        Assert.assertEquals(-1120,num);

        input = "12345";
        num = repo.isNumNegative(input);
        Assert.assertEquals(0,num);
    }

    public void testAddNumbers(){
        String input = "1,2,5";
        int total = repo.addNumbers(input);
        Assert.assertEquals(8,total);

        input = "1\\n,2,3";
        total = repo.addNumbers(input);
        Assert.assertEquals(6,total);

        input = "1,\\n2,4";
        total = repo.addNumbers(input);
        Assert.assertEquals(7,total);

        input = "//;\\n1;3;4";
        total = repo.addNumbers(input);
        Assert.assertEquals(8,total);

        input = "//$\\n1$2$3";
        total = repo.addNumbers(input);
        Assert.assertEquals(6,total);

        input = "//@\\n2@3@8";
        total = repo.addNumbers(input);
        Assert.assertEquals(13,total);

        input = "2,1001";
        total = repo.addNumbers(input);
        Assert.assertEquals(2,total);
    }
}