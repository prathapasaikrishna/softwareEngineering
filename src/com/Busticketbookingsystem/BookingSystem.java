package com.Busticketbookingsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingSystem {

    private List<Bus> buses;
    private List<Customer> customers;
    private List<Ticket> tickets;
    private Scanner sc;

    public BookingSystem() {
        buses = new ArrayList<>();
        customers = new ArrayList<>();
        tickets = new ArrayList<>();
        sc = new Scanner(System.in);

        addSampleBuses();
    }

    private void addSampleBuses() {
        buses.add(new Bus(101, "AC", "Sleeper", 30));
        buses.add(new Bus(102, "Non-AC", "Seater", 40));
        buses.add(new Bus(103, "AC", "Seater", 35));
    }

    public void displayBuses() {
        System.out.println("\n========== AVAILABLE BUSES ==========");

        for (Bus bus : buses) {
            System.out.println(bus);
            System.out.println("Available Seats : " + bus.getAvailableSeats());
            System.out.println("-------------------------------------");
        }
    }

    public void registerCustomer() {

        System.out.print("Enter Customer ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Password : ");
        String password = sc.nextLine();

        System.out.print("Enter Age : ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Gender : ");
        String gender = sc.nextLine();

        customers.add(new Customer(id, name, password, age, gender));

        System.out.println("Registration Successful.");
    }

    public Customer loginCustomer() {

        System.out.print("Enter Customer ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Password : ");
        String password = sc.nextLine();

        for (Customer c : customers) {

            if (c.getCustomerId() == id &&
                    c.getPassword().equals(password)) {

                System.out.println("Login Successful.");
                return c;
            }
        }

        System.out.println("Invalid Customer ID or Password.");
        return null;
    }

    private Bus findBus(int busId) {

        for (Bus bus : buses) {

            if (bus.getBusId() == busId) {
                return bus;
            }
        }

        return null;
    }

    public void bookTicket(Customer customer) {

        displayBuses();

        System.out.print("Enter Bus ID : ");
        int busId = sc.nextInt();

        Bus bus = findBus(busId);

        if (bus == null) {
            System.out.println("Bus Not Found.");
            return;
        }

        bus.showAvailableSeats();

        System.out.print("How many seats do you want? : ");
        int count = sc.nextInt();

        if (count > bus.getAvailableSeats()) {
            System.out.println("Required seats not available.");
            return;
        }

        Ticket ticket = new Ticket(
                tickets.size() + 1,
                bus,
                count,
                count * 500,
                customer.getCustomerId());

        for (int i = 0; i < count; i++) {

            System.out.print("Enter Seat Number " + (i + 1) + " : ");
            int seat = sc.nextInt();

            if (bus.bookSeat(seat - 1)) {

                ticket.addBookedSeat(seat);

            } else {

                System.out.println("Seat " + seat + " already booked.");

                i--;
            }
        }

        tickets.add(ticket);

        System.out.println("\nTicket Booked Successfully.");
        System.out.println(ticket);
    }

    public void viewTickets(Customer customer) {

        boolean found = false;

        for (Ticket ticket : tickets) {

            if (ticket.getCustomerId() == customer.getCustomerId()) {

                System.out.println(ticket);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Tickets Found.");
        }
    }

    public void cancelTicket(Customer customer) {

        System.out.print("Enter Ticket ID : ");
        int ticketId = sc.nextInt();

        for (int i = 0; i < tickets.size(); i++) {

            Ticket ticket = tickets.get(i);

            if (ticket.getTicketId() == ticketId &&
                    ticket.getCustomerId() == customer.getCustomerId()) {

                for (int seat : ticket.getBookedSeats()) {
                    ticket.getBus().cancelSeat(seat - 1);
                }

                tickets.remove(i);

                System.out.println("Ticket Cancelled Successfully.");
                return;
            }
        }

        System.out.println("Ticket Not Found.");
    }
}