package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class FactTest {

    @Test (expected = IllegalArgumentException.class)
    public void whenFactNegative3() {
        new Fact().calc(-2);
    }

}