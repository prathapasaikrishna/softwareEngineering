package com.Busticketbookingsystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BookingSystem bookingSystem = new BookingSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n========== BUS BOOKING SYSTEM ==========");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Display Buses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    bookingSystem.registerCustomer();
                    break;

                case 2:

                    Customer customer = bookingSystem.loginCustomer();

                    if (customer != null) {

                        boolean logout = false;

                        while (!logout) {

                            System.out.println("\n========== CUSTOMER MENU ==========");
                            System.out.println("1. Book Ticket");
                            System.out.println("2. View Tickets");
                            System.out.println("3. Cancel Ticket");
                            System.out.println("4. Display Buses");
                            System.out.println("5. Logout");
                            System.out.print("Enter your choice : ");

                            int option = sc.nextInt();

                            switch (option) {

                                case 1:
                                    bookingSystem.bookTicket(customer);
                                    break;

                                case 2:
                                    bookingSystem.viewTickets(customer);
                                    break;

                                case 3:
                                    bookingSystem.cancelTicket(customer);
                                    break;

                                case 4:
                                    bookingSystem.displayBuses();
                                    break;

                                case 5:
                                    logout = true;
                                    System.out.println("Logged Out Successfully.");
                                    break;

                                default:
                                    System.out.println("Invalid Choice.");
                            }
                        }
                    }

                    break;

                case 3:
                    bookingSystem.displayBuses();
                    break;

                case 4:
                    System.out.println("Thank You for Using Bus Booking System.");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}