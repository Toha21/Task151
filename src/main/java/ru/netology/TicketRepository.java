package ru.netology;

public class TicketRepository {
    Ticket[] tickets = new Ticket[0];

    public Ticket[] add(Ticket ticket) throws AlreadyExistsException {
        for (Ticket thisTicket : tickets) {
            if (ticket.getId() == thisTicket.getId()) {
                throw new AlreadyExistsException("Ticket с таким id уже существует" + ticket.getId());
            }
        }
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0;i < tickets.length; i++){
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
        return tmp;
    }

    public void removeById(int id) throws NotFoundException {
        if (findById(id) == null){
            throw new NotFoundException("Ticket с таким id нет" + id);
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int index = 0;
        for (Ticket ticket : tickets){
            if (ticket.getId() != id){
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }
    public Ticket findById(int id){
        for (Ticket ticket : tickets){
            if (ticket.getId() ==  id){
                return ticket;
            }
        }
        return null;
    }
    public Ticket[] findAll(){
        return tickets;
    }
}
