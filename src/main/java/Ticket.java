public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String fromAirport;
    private String toAirport;

    public Ticket() {
    }

    public Ticket(int id, int price, String fromAirport, String toAirport, int travelTime) {
        this.id = id;
        this.price = price;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
    }

    public boolean matches(String from, String to) {
        return fromAirport.contains(from) && toAirport.contains(to);
    }

    public int getId() {
        return id;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    @Override
    public int compareTo(Ticket o) {
        return this.price - o.price;
    }

    public int getPrice() {
        return price;
    }

}