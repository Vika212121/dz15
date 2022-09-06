import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    Ticket ticket1 = new Ticket(1, 1500, "LED", "VKO", 60);
    Ticket ticket2 = new Ticket(2, 20000, "LED", "SCO", 6230);
    Ticket ticket3 = new Ticket(3, 150, "LED", "VKO", 6);
    Ticket ticket4 = new Ticket(4, 21000, "LED", "SCO", 6230);
    Ticket ticket5 = new Ticket(5, 110, "LED", "VKO", 70);
    Ticket ticket6 = new Ticket(6, 19500, "LED", "SCO", 6230);
    Ticket ticket7 = new Ticket(7, 2000, "LED", "VKO", 60);
    Ticket ticket8 = new Ticket(8, 1500, "VKO", "LED", 60);
    Ticket ticket9 = new Ticket(9, 20000, "SCO", "LED", 6230);


    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    @BeforeEach
    public void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
    }

    @Test
    void shouldAddTicket() {
        Ticket[] actual = repository.findAll();
        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8,
                ticket9};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindTicket() {
        Ticket[] actual = manager.searchBy("LED", "VKO");
        Ticket[] expected = new Ticket[]{ticket5, ticket3, ticket1, ticket7};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindTicket() {
        Ticket[] actual = manager.searchBy("LED", "AAQ");
        Ticket[] expected = new Ticket[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchById() {
        Ticket actual = repository.findById(2);
        Ticket expected = ticket2;
        assertEquals(expected, actual);
    }

    @Test
    void shouldSearchByNotExistId() {
        Ticket actual = repository.findById(10);
        assertNull(actual);
    }

    @Test
    void shouldRemoveById() {
        repository.removeById(2);
        Ticket[] actual = repository.findAll();
        Ticket[] expected = new Ticket[]{ticket1, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdNotExist() {
        assertThrows(NotFoundException.class, () -> repository.removeById(10));
    }

    @Test
    void shouldSearchById1() {
        Ticket actual = repository.findById(5);
        Ticket expected = ticket5;
        assertEquals(expected, actual);
    }
}
