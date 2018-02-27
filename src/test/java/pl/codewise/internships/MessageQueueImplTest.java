package pl.codewise.internships;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageQueueImplTest {

    @Test
    public void testNumberOfElementsInSnapshot50() {
        MessageQueue messageQueue = new MessageQueueImpl();

        for(int i = 0; i < 50; i++)
            messageQueue.add(new Message("userAgent", i));

        Snapshot snapshot = messageQueue.snapshot();
        assertEquals(50, snapshot.getMessages().size());
    }

    @Test
    public void testNumberOfElementsInSnapshot100() {
        MessageQueue messageQueue = new MessageQueueImpl();

        for(int i = 0; i < 100; i++)
            messageQueue.add(new Message("userAgent", i));

        Snapshot snapshot = messageQueue.snapshot();
        assertEquals(100, snapshot.getMessages().size());
    }

    @Test
    public void testNumberOfElementsInSnapshot200() {
        MessageQueue messageQueue = new MessageQueueImpl();

        for(int i = 0; i < 200; i++)
            messageQueue.add(new Message("userAgent", i));

        Snapshot snapshot = messageQueue.snapshot();
        assertEquals(100, snapshot.getMessages().size());
    }

    @Test
    public void testNumberOfErrorMessages50() {
        MessageQueue messageQueue = new MessageQueueImpl();

        for(int i = 0; i < 50; i++)
            messageQueue.add(new Message("userAgent", 400));

        for(int i = 0; i < 50; i++)
            messageQueue.add(new Message("userAgent", 200));

        assertEquals(50, messageQueue.numberOfErrorMessages());
    }

    @Test
    public void testNumberOfErrorMessages200() {
        MessageQueue messageQueue = new MessageQueueImpl();

        for(int i = 0; i < 20; i++)
            messageQueue.add(new Message("userAgent", 500));

        for(int i = 0; i < 100; i++)
            messageQueue.add(new Message("userAgent", 300));

        assertEquals(0, messageQueue.numberOfErrorMessages());
    }

}