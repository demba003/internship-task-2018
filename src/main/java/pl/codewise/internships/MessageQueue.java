package pl.codewise.internships;

public interface MessageQueue {

    void add(Message message);

    Snapshot snapshot();

    long numberOfErrorMessages();
}
