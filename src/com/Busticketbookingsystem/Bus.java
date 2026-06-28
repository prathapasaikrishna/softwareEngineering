package com.Busticketbookingsystem;

import java.util.Arrays;

public class Bus {

    private int busId;
    private String busType;      // AC / Non-AC
    private String seatType;     // Seater / Sleeper
    private int totalSeats;
    private boolean[] seats;     // true = booked, false = available

    public Bus(int busId, String busType, String seatType, int totalSeats) {
        this.busId = busId;
        this.busType = busType;
        this.seatType = seatType;
        this.totalSeats = totalSeats;
        this.seats = new boolean[totalSeats]; // all false by default
    }

    public int getAvailableSeats() {
        int count = 0;
        for (boolean seat : seats) {
            if (!seat) {
                count++;
            }
        }
        return count;
    }

    public void showAvailableSeats() {
        System.out.println("Available seats for Bus " + busId + ":");
        for (int i = 0; i < totalSeats; i++) {
            if (!seats[i]) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }

    public boolean bookSeat(int seatNumber) {
        if (seatNumber < 0 || seatNumber >= totalSeats)
            return false;

        if (!seats[seatNumber]) {
            seats[seatNumber] = true;
            return true;
        }

        return false; // already booked
    }

    public boolean cancelSeat(int seatNumber) {
        if (seatNumber < 0 || seatNumber >= totalSeats)
            return false;

        if (seats[seatNumber]) {
            seats[seatNumber] = false;
            return true;
        }

        return false; // seat was not booked
    }

    public int getBusId() {
        return busId;
    }

    public String getBusType() {
        return busType;
    }

    public String getSeatType() {
        return seatType;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    @Override
    public String toString() {
        return "Bus [busId=" + busId +
                ", busType=" + busType +
                ", seatType=" + seatType +
                ", totalSeats=" + totalSeats +
                ", seats=" + Arrays.toString(seats) + "]";
    }
}