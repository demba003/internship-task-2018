package pl.codewise.internships;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SnapshotTest {

    @Test
    public void getMessages() {
        List<Message> list = new ArrayList<>();

        for(int i = 0; i < 100; i++)
            list.add(new Message("userAgent", i));

        Snapshot snapshot = new Snapshot(list);

        assertArrayEquals(list.toArray(), snapshot.getMessages().toArray());
    }
}