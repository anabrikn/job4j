package ru.job4j.profession;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * @author anna brik
 * @version 1
 * @since 02.02.19
 */
public class EngineerTest {
    @Test
    public void engineerTest() {
        Engineer engineer = new Engineer("Гюстав Эйфель", "Ктототамович", "хирург", "20.01.1860");
        House construction = new House("Эйфелева башня");
        engineer.build(construction);

        boolean result = construction.isBuilt();
        boolean expect = true;
        assertThat(result, is(expect));
    }
}
