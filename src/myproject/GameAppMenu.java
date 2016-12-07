package myproject;

import java.util.Scanner;
import utilities.Prompt;

/**
 * Menu based application for a games database.
 *
 * @author Dillon Davis
 */
public class GameAppMenu {

    Scanner sc = new Scanner(System.in);
    DAOGame data = new DAOGame();

    public GameAppMenu() {
        menuLoop();
    }

    private void menuLoop() {
        int choice = 1;
        int id;
        String console;
        String genre;
        int yearRelease;
        String name;

        double price;

        while (choice != 0) {
            System.out.println("\nGame App");
            System.out.println("0 = Quit");
            System.out.println("1 = Retrieve All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Single Record");
            System.out.println("4 = Update");
            System.out.println("5 = Delete");
            System.out.println("6 = Retrieval All: Order by ID");
            System.out.println("7 = Retrieval All: Order by game console");
            System.out.println("8 = Retrieval All: Order by game genre");
            System.out.println("9 = Retrieval All: Order by year game released");
            System.out.println("10 = Retrieval All: Order by game name");
            System.out.println("11 = Retrieval All: Order by price of game");
            System.out.println("12 = Retrieval All: Order by console and year released.");
            System.out.println("13 = View Statistics of the price");
                    

            choice = Prompt.getInt("Number of choice: ", 0, 13);

            if (choice == 1) {
                System.out.println(data.toString());
            } else if (choice == 2) {

                id = Prompt.getInt("Enter game id: ");

                console = Prompt.getLine("Enter console: ");

                genre = Prompt.getLine("Enter genre: ");

                yearRelease = Prompt.getInt("Enter year game released: ");

                name = Prompt.getLine("Enter name of game: ");

                price = Prompt.getDouble("Enter price: ");

                Game game = new Game(id, console, genre, yearRelease, name, price);
                data.create(game);
            } else if (choice == 3) {

                id = Prompt.getInt("Enter game id: ");
                System.out.println(data.retrieve(id));
            } else if (choice == 4) {
                ;
            } else if (choice == 5) {

                id = Prompt.getInt("Enter game id: ");
                data.delete(id);
            } else if (choice == 6) {
                System.out.println(data.orderById());
            } else if (choice == 7) {
                System.out.println(data.orderByConsole());
            } else if (choice == 8) {
                System.out.println(data.orderByGenre());
            } else if (choice == 9) {
                System.out.println(data.orderByyearRelease());
            } else if (choice == 10) {
                System.out.println(data.orderByName());
            } else if (choice == 11) {
                System.out.println(data.orderByPrice());
            } else if (choice == 12) {
                System.out.println(data.orderByConsoleYearRelease());
            } else if (choice == 13) {
                data.Statistics();
            } else if (choice == 0){
                ;
            }
        }
    }

    public static void main(String[] args) {
        new GameAppMenu();
    }
}
