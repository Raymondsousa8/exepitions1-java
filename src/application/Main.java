package application;

import model.entites.Reservation;
import model.exceptions.DomainExceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("check-IN date (dd/MM/yyyy)");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("check-Out date (dd/MM/yyyy)");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            checkIn = sdf.parse(sc.next());
            System.out.print("check-Out date (dd/MM/yyyy)");
            checkOut = sdf.parse(sc.next());

            reservation.updateDate(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        catch (ParseException e){
            System.out.println("Invalid date format ");
        }
        catch (DomainExceptions e){
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error ");
        }

    sc.close();
    }
}