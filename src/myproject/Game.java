package myproject;

/**
 * 
 *
 * @author Dillon Davis
 */
public class Game {

    private int id;
    private String console;
    private String genre;
    private int yearRelease;
    private String name;
    private double price;

    public Game(int id, String console, String genre, int yearRelease, String name, double price) {
        this.id = id;
        this.console = console;
        this.genre = genre;
        this.yearRelease = yearRelease;
        this.name = name;
        this.price = price;
    }

    public int getID() {
        return id;
    }

    public String getConsole() {
        return console;
    }

    public String getGenre() {
        return genre;
    }

    public int getyearRelease() {
        return yearRelease;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setyearRelease(int yearRelease) {
        this.yearRelease = yearRelease;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        //return "Game{" + "id=" + id + ", console=" + console + ", genre=" + genre + ", yearRelease=" + yearRelease + ", name=" + name + ", price=" + price + '}';
        return String.format("%-10d %-10s %-10s %-10d %-20s %.2f", id, console, genre, yearRelease, name, price);
    }

}
