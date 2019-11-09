package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5)); //5 low - низкий
        queue.put(new Task("urgent", 1)); //1 urgent - срочный
        queue.put(new Task("middle", 3)); //3 middle - средний
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }
}
