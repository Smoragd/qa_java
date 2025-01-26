package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    Feline feline = new Feline();

    @Test
    public void eatMeatSuccess() throws Exception {
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getFamilySuccess() throws Exception {
        when(feline.getFamily()).thenReturn("Кошачьи");
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensNoParams() throws Exception {
        when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithParams() throws Exception {
        when(feline.getKittens(5)).thenReturn(5);
        Assert.assertEquals(5, feline.getKittens(5));
    }


}
