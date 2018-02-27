package pl.codewise.internships;

import java.util.*;
import java.util.stream.Collectors;

public class MessageQueueImpl implements MessageQueue {
    private final Map<Long, Message> queue = new TreeMap<>();

    public synchronized void add(Message message) {
        queue.put(System.currentTimeMillis()*1000000 + System.nanoTime(), message);
    }

    public synchronized Snapshot snapshot() {
        Map<Long, Message> collect = queue.entrySet().stream()
                .filter(map -> map.getKey() > System.currentTimeMillis() - 300000)
                .skip(Math.max(0, queue.size() - 100))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        List <Message> msgs = new ArrayList<>(collect.values());
        return new Snapshot(msgs);
    }

    public synchronized long numberOfErrorMessages() {
        long errors;

        errors = queue.entrySet().stream()
                .filter(map -> map.getKey() > System.currentTimeMillis()-300000)
                .filter(map -> map.getValue().getErrorCode() >= 400)
                .skip(Math.max(0, queue.size() - 100))
                .count();

        return errors;
    }
}
