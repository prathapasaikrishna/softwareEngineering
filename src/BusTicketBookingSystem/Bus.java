package BusTicketBookingSystem;

public class Bus {
    private int busId;
    private String busType;
    private String seatType;
    private int totalSeats;
    private boolean[] seats;


    public Bus(int busId,String busType,String seatType,int totalSeats){
        super();
        this.busId=busId;
        this.busType=busType;
        this.seatType=seatType;
        this.totalSeats=totalSeats;
        this.seats=new boolean[totalSeats];
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public String getSeatType() {
        return seatType;
    }

    public String getBusType() {
        return busType;
    }

    public int getBusId() {
        return busId;
    }
}
