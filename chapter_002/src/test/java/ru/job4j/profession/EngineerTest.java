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
    public void engineerBuilderTest() {
        Builder engineer = new Builder("Гюстав Эйфель", "Ктототамович", "Строитель", "20.01.1860");
        House construction = new House("Эйфелева башня");
        engineer.build(construction);

        boolean result = construction.isBuilt();
        assertThat(result, is(true));
    }

    @Test
    public void engineerProgrammerTest() {
        Programmer programmer = new Programmer("Билл", "Гейтс", "Программист", "20.01.1860");
        Program program = new Program("Операционная система");
        programmer.makeProgramm(program);

        boolean result = program.isMade();
        assertThat(result, is(true));
    }
}
