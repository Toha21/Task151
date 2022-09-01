package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketTest {

    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(1, 2300, "LED", "VKO", 2);
    Ticket ticket2 = new Ticket(2, 4500, "OVB", "SVO", 5);
    Ticket ticket3 = new Ticket(3, 4000, "SVX", "LED", 5);
    Ticket ticket4 = new Ticket(4, 15000, "DME", "LED", 3);
    Ticket ticket5 = new Ticket(5, 1000, "LED", "VKO", 1);

    @Test
    public void shouldSearchWhenOneTicketMatches() throws AlreadyExistsException {
        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);

        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.findAll("LED", "VKO");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWhenNoMatches() {
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("LED", "VKO");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWhenTwoElementsMatchAndPriceDescending() throws AlreadyExistsException {
        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);


        Ticket[] expected = {ticket1, ticket5};
        Ticket[] actual = manager.findAll("LED", "VKO");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldBeSearchedByOneParameter() throws AlreadyExistsException {
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("LED", "XXX");

        Assertions.assertArrayEquals(expected, actual);
    }

}