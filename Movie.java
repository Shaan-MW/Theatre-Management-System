
import java.util.Arrays;
import java.util.Scanner;

public class Movie {
    private String title;
    private String Duration;
    private String Production;
    private String Hero;
    private char[][] Seats;

    public Movie(String title, String duration, String production, String hero, char[][] seats) {
        this.title = title;
        Duration = duration;
        Production = production;
        Hero = hero;
        Seats = seats;
    }

    public char[][] getSeats() {
        return Seats;
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return Duration;
    }

    public String getProduction() {
        return Production;
    }

    public String getHero() {
        return Hero;
    }

    public String toString()
    {
        return getTitle();
    }

    public void booking(int row, int column, Scanner scanner)
    {
        if(Seats[row-1][column-1]=='O')
        {
            this.Seats[row-1][column-1]='X';
        }else{
            if(this.Seats[row-1][column-1]=='B')
            {
                System.out.println("Seat Blocked.");
                actualBooking(scanner);
            }else{
                System.out.println("Seat already booked.");
                actualBooking(scanner);
            }
        }
    }

    public void actualBooking(Scanner scanner)
    {
        System.out.print("Enter row number : ");
        int rowNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter seat number : ");
        int seatNumber = scanner.nextInt();
        scanner.nextLine();
        booking(rowNumber,seatNumber,scanner);
    }

    public void blockSeat(Scanner scanner)
    {
        blockMenu(scanner);
    }

    public void blockMenu(Scanner scanner)
    {
        System.out.println("------------------------------------");
        System.out.println("----------- Regal Cinemas ----------");
        System.out.println("------------------------------------");
        System.out.println(" 1) Block rows.");
        System.out.println(" 2) Block seat(s).");
        System.out.println(" 3) Back. ");
        System.out.println("------------------------------------");
        System.out.print("Enter Choice : ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        blockMenuSelector(choice, scanner);
    }

    public void blockMenuSelector(int choice, Scanner scanner)
    {
        switch (choice)
        {
            case 1:
                blockRow(scanner);
                break;
            case 2:
                blockSeats(scanner);
                break;
            case 3:
                RegalCinemas.adminMenu();
            default:
                System.out.println("Invalid Choice. Please try again.");
                blockMenu(scanner);
        }
    }

    public void blockRow(Scanner scanner)
    {
        int i=0;
        System.out.print("Enter Row Number : ");
        int rowNumber = scanner.nextInt();
        scanner.nextLine();
        for(char[] seatRow : Seats)
        {
            if(rowNumber-1==i)
            {
                Arrays.fill(seatRow, 'B');
                break;
            }
            i++;
        }
        blockMenu(scanner);

    }

    public void blockSeats(Scanner scanner)
    {
        System.out.print("Enter Seat Count to Block Booking : "); int seatCount = scanner.nextInt(); scanner.nextLine();
        while (seatCount>0)
        {
        System.out.print("Enter row number : ");
        int rowNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter seat number : ");
        int seatNumber = scanner.nextInt();
        scanner.nextLine();
        this.Seats[rowNumber-1][seatNumber-1]='B';
        seatCount--;
        }
        blockMenu(scanner);
    }

    public void unblockSeat(Scanner scanner)
    {

    }
}
