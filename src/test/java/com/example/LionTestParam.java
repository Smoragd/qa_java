package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionTestParam {

    private String sex;
    private Boolean isMane;

    public LionTestParam (String sex, Boolean isMane){
        this.sex = sex;
        this.isMane = isMane;
    }

    @Parameterized.Parameters
    public static Object[][] LionTestParamParameters(){
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;

    @Test
    public void testLionConstructor() throws Exception {
        Lion lion = new Lion(feline, sex);
        Assert.assertEquals(isMane, lion.doesHaveMane());
    }





}
