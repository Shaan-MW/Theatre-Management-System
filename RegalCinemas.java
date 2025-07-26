import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RegalCinemas {

    //colors;
    static String textColorGreen = "\u001B[32m";
    static String textColorRed = "\u001B[31m";

    static String textColorBlue = "\u001B[30m";
    static String reset = "\u001B[0m";
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Customer> customers = new ArrayList<>();

    static ArrayList<Movie> movies = new ArrayList<>(5);
    static ArrayList<char[][]> seating = new ArrayList<>(5);

    public static void main(String[] args)
    {

        System.out.println("-- Welcome to my Theatre Project--");
        System.out.println(textColorGreen + " Hello" + reset);
        char[][] tempSeat1 = new char[15][13];
        char[][] tempSeat2 = new char[15][13];
        char[][] tempSeat3 = new char[15][13];
        char[][] tempSeat4 = new char[15][13];
        char[][] tempSeat5 = new char[15][13];

        for (char[] chars : tempSeat1) {
            Arrays.fill(chars, 'O');
        }
        seating.add(tempSeat1);
        for (char[] chars : tempSeat2) {
            Arrays.fill(chars, 'O');
        }
        seating.add(tempSeat2);
        for (char[] chars : tempSeat3) {
            Arrays.fill(chars, 'O');
        }
        seating.add(tempSeat3);
        for (char[] chars : tempSeat4) {
            Arrays.fill(chars, 'O');
        }
        seating.add(tempSeat4);
        for (char[] chars : tempSeat5) {
            Arrays.fill(chars, 'O');
        }
        seating.add(tempSeat5);

        movies.add(new Movie("Sarkar", "2h 30min", "Lyca Production", "Vijay", tempSeat1));
        movies.add(new Movie("KGF", "2h 43min" , "VVV", "Yash", tempSeat2));
        movies.add(new Movie("Lucky Bashkar", "3h 12min", "Velkumar Production", "Dulquer Salmaan", tempSeat3));

        firstMenu();
    }

    public static void firstMenu()
    {
        System.out.println("------------------------------------");
        System.out.println("----------- Regal Cinemas ----------");
        System.out.println("------------------------------------");
        System.out.println(" 1) Customer Login");
        System.out.println(" 2) Customer Signup");
        System.out.println(" 3) Admin Login");
        System.out.println(" 4) View Movies");
        System.out.println(" 5) Exit");
        System.out.println("------------ Thank you -------------");
        System.out.print("Enter Choice : ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        firstMenuSelector(choice);
    }

    public static void firstMenuSelector(int choice)
    {
        switch(choice)
        {
            case 1:
                login();
                break;
            case 2:
               signup();
                break;
            case 3:
                adminLogin();
                break;
            case 4:
                viewMovies();
                firstMenu();
                break;
            case 5:
                System.out.println("Program Exited.");
                break;
            default:
                System.out.println("Invalid Choice, Please re-enter.");
                firstMenu();
        }
    }

    public static void adminLogin()
    {
        System.out.print("Enter Username : ");
        String username = scanner.nextLine();

        System.out.print("Enter Password : ");
        String password = scanner.nextLine();
        System.out.println();

        if(username.equalsIgnoreCase("Admin") && password.equalsIgnoreCase("password"))
        {
            System.out.println("Admin Login Successful.");
            adminMenu();
        }else{
            System.out.println("Wrong Credentials Entered. Try again");
            adminLogin();
        }
    }

    public static void adminMenu()
    {
        System.out.println("------------------------------------");
        System.out.println("----------- Regal Cinemas ----------");
        System.out.println("------------------------------------");
        System.out.println(" 1) Add Movies.");
        System.out.println(" 2) Remove Movies.");
        System.out.println(" 3) Show Theatre Booking.");
        System.out.println(" 4) Reset Booking.");
        System.out.println(" 5) Block / Unblock Booking.");
        System.out.println(" 6) View Customer Details.");
        System.out.println(" 7) Back.");
        System.out.println(" 8) Exit.");

        System.out.print("Enter Choice : ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        adminMenuSelection(choice);

    }

    public static void adminMenuSelection(int choice)
    {
        switch (choice)
        {
            case 1:
                addMovies();
                break;
            case 2:
                removeMovies();
                break;
            case 3:
                showTheatreBooking();
                break;
            case 4:
                resetBooking();
                break;
            case 5:
                blockUnblockSeat();
                break;
            case 6:
                viewCustomerDetails();
                break;
            case 7:
                firstMenu();
            case 8:
                System.out.println("Program Exited.");
                break;
            default:
                System.out.println("Invalid Choice. Please try again.");
                adminMenu();
        }
    }

    public static void addMovies()
    {
        System.out.print("Enter Movie Title : ");
        String movTitle = scanner.nextLine();

        System.out.print("Enter Movie Duration : ");
        String movDuration = scanner.nextLine();

        System.out.print("Enter Movie Production Name : ");
        String movProduction = scanner.nextLine();

        System.out.print("Enter Movie Hero in : ");
        String movHeroIn = scanner.nextLine();

        if(movies.size()<5)
        {
            movies.add(new Movie(movTitle,movDuration,movProduction,movHeroIn,seating.get(movies.size())));
            System.out.println("Movie Added Successfully.");
            adminMenu();
        }else{
            System.out.println("Shows are full. Cannot add movies.");
            adminMenu();
        }

    }

    public static void removeMovies()
    {
        viewMovies();
        System.out.println("Select a movie to remove : ");
        int movieRemoveChoice = scanner.nextInt();
        scanner.nextLine();
        showMovieDetails(movieRemoveChoice);

        System.out.print("Are you sure to remove the selected movie.(y/n) : ");
        String adminChoice = scanner.nextLine();
        if(adminChoice.equalsIgnoreCase("y"))
        {
            movies.remove(movieRemoveChoice-1);
            System.out.println("Movie Remove Successful.");
        }
        viewMovies();
        adminMenu();


    }

    public static void showTheatreBooking()
    {
        for(int i=1;i<=movies.size();i++)
        {
            showMovieDetails(i);
        }
        adminMenu();
    }

    public static void resetBooking()
    {
        for (char[][] value : seating) {
            for (char[] chars : value) {
                Arrays.fill(chars, 'O');
            }
        }
        adminMenu();
    }


    public static void blockUnblockSeat()
    {
        viewMovies();
        System.out.print("Choose Movie : ");
        int movieChoice = scanner.nextInt();
        scanner.nextLine();
        showMovieDetails(movieChoice);
        System.out.println("------------------------------------");
        System.out.println("----------- Regal Cinemas ----------");
        System.out.println("------------------------------------");
        System.out.println(" 1) Block.");
        System.out.println(" 2) Unblock.");
        System.out.println(" 3) Back to main menu.");
        System.out.println("------------------------------------");
        System.out.print(" Enter Choice : ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        blockMenu(choice,movieChoice-1);

    }

    public static void blockMenu(int choice, int movieChoice)
    {
        switch (choice)
        {
            case 1:
                movies.get(movieChoice).blockSeat(scanner);
                break;
            case 2:
                movies.get(movieChoice).unblockSeat(scanner);
                break;
            case 3:
                adminMenu();
                break;
            default:
                System.out.println("Invalid Choice. Please try again.");
                blockUnblockSeat();
                break;
        }
    }

    public static void viewCustomerDetails()
    {}

    public static void signup()
    {
        System.out.print("Enter Username : ");
        String username = scanner.nextLine();
        for(Customer temp:customers)
        {
            if(temp.getUsername().equalsIgnoreCase(username))
            {
                System.out.println("Username is take. Please Try again.");
                signup();
            }
        }

        System.out.print("Enter Firstname : ");
        String firstname = scanner.nextLine();

        System.out.print("Enter Password : ");
        String password = scanner.nextLine();


        customers.add(new Customer(username,firstname,password));
        System.out.println("Welcome "+firstname+". Thank you for Registering.");
        firstMenu();
    }

    public static void login()
    {
        System.out.print("Enter Username : ");
        String username = scanner.nextLine();

        System.out.print("Enter Password : ");
        String password = scanner.nextLine();
        boolean isFound = false;
        if(!customers.isEmpty())
        {
            for(Customer temp:customers)
            {
                if(temp.getUsername().equalsIgnoreCase(username) && temp.getPassword().equals(password)) {
                    System.out.println("Welcome "+temp.getUsername()+"Login Successful.");
                    secondMenu();
                    isFound=true;
                    break;

                }
            }

                if(!isFound)
                {
                    System.out.println("Wrong Credentials");
                    login();
                }

        }else{
            System.out.println("No registered users exist. Please try signup.");
            firstMenu();
        }
    }

    public static void viewMovies()
    {
        int i=1;
        System.out.println("------------------------------------");
        System.out.println("----------- Regal Cinemas ----------");
        System.out.println("------------------------------------");
        for(Movie tempMovie:movies)
        {
            System.out.println(i+") "+tempMovie.toString());
            i++;
        }
        System.out.println("------------ Thank you -------------");
    }

    public static void secondMenu()
    {
        System.out.println("------------------------------------");
        System.out.println("----------- Regal Cinemas ----------");
        System.out.println("------------------------------------");
        System.out.println(" 1) Show Movies.");
        System.out.println(" 2) Book Seats.");
        System.out.println(" 3) Go to main menu.");
        System.out.println(" 4) Exit.");
        System.out.println("------------------------------------");
        System.out.print("Enter Choice : ");
        int choice  = scanner.nextInt();
        secondMenuSelector(choice);

    }

    public static void bookSeats()
    {
        viewMovies();
        System.out.print("Choose Movie : ");
        int movieChoice = scanner.nextInt();
        scanner.nextLine();
        showMovieDetails(movieChoice);

        System.out.print("Enter 1 to book seat : ");
        int bookChoice = scanner.nextInt();
        if(bookChoice==1)
            bookingProcess(movieChoice);
        secondMenu();
    }

    public static void showMovieDetails(int movieChoice)
    {
        System.out.println("--------------------------------------------");
        System.out.println("--------------- Regal Cinemas --------------");
        System.out.println("--------------------------------------------");
        System.out.println(" \t\tMovie      : "+ movies.get(movieChoice-1).getTitle());
        System.out.println(" \t\tDuration   : "+ movies.get(movieChoice-1).getDuration());
        System.out.println(" \t\tHero in    : "+ movies.get(movieChoice-1).getHero());
        System.out.println(" \t\tProduction : "+ movies.get(movieChoice-1).getProduction());
        System.out.println("--------------------------------------------");
        System.out.println("------------ Displaying Seats --------------");
        int i=1;
        System.out.print("    ");
        for(int j=1;j<=13;j++)
        {
            System.out.printf("%2d ",j);
        }
        System.out.println();
        for(char[] rows : movies.get(movieChoice-1).getSeats())
        {
            System.out.print(" ");
            System.out.printf("%2d",i);
            for(char seat: rows){
                if(seat=='O') {
                    System.out.print(textColorGreen+"  "+seat+reset);
                } else if (seat=='B') {
                    System.out.print(textColorBlue+"  "+seat+reset);
                } else{
                    System.out.print(textColorRed+"  "+seat+reset);
                }
            }
            System.out.println();i++;
        }
        System.out.println("--------------------------------------------");

    }

    public static void bookingProcess(int movieChoice)
    {
        int seatCount=getSeatCount();
        while (seatCount>0)
        {
            System.out.print("Enter row number : ");
            int rowNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter seat number : ");
            int seatNumber = scanner.nextInt();
            scanner.nextLine();
            movies.get(movieChoice-1).booking(rowNumber,seatNumber,scanner);
            seatCount--;
        }
    }

    public static int getSeatCount()
    {
        System.out.print("Enter Seat count : ");
        int seatCount = scanner.nextInt();
        scanner.nextLine();

        return seatCount;
    }

    public static void secondMenuSelector(int choice)
    {
        switch(choice)
        {
            case 1:
                viewMovies();
                secondMenu();
                break;
            case 2:
                bookSeats();
                break;
            case 3:
                firstMenu();
                break;
            case 4:
                System.out.println("Program Exited.");
                break;
            default:
                System.out.println("Invalid Choice. Please try again.");
                secondMenu();
                break;
        }
    }


}
