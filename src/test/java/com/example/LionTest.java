package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void lionConstructorException() {
        Exception exception = assertThrows(Exception.class, () -> new Lion(new Feline(), "Другое"));
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    public void getKittensNoParams() throws Exception {
        when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion(feline, "Самка");
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void doesHaveManeFalse() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        Assert.assertFalse(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeTrue() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Assert.assertTrue(lion.doesHaveMane());
    }

    @Test
    public void getFoodSuccess() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

}
