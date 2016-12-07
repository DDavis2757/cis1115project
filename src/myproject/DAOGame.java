package myproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import static java.lang.Double.MAX_VALUE;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Data Access Object to a collection of games.
 *
 * @author Dillon Davis
 */
public class DAOGame {

    private String fileName = "gameData.txt";
    private List<Game> myList;

    public DAOGame() {
        myList = new ArrayList<>();
        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
            ;
        } catch (IOException ex) {
            Logger.getLogger(DAOGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        readList();
    }

    public void create(Game game) {
        myList.add(game);
        writeList();
    }

    public Game retrieve(int id) {
        for (Game game : myList) {
            if (game.getID() == id) {
                return game;
            }
        }
        return null;
    }

    public void update(Game game) {
        for (Game g : myList) {
            if (g.getID() == game.getID()) {
                g.setName(game.getName());
                g.setConsole(game.getConsole());
                g.setGenre(game.getGenre());
                g.setyearRelease(game.getyearRelease());
                g.setPrice(game.getPrice());
            }
        }
    }

    public void delete(int id) {
        Game myGame = null;
        for (Game game : myList) {
            if (game.getID() == id) {
                myGame = game;

            }
        }
        myList.remove(myGame);
    }

    private void readList() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String console = data[1];
                String genre = data[2];
                int yearRelease = Integer.parseInt(data[3]);
                String name = data[4];
                double price = Double.parseDouble(data[5]);
                Game myGame = new Game(id, console, genre, yearRelease, name, price);
                myList.add(myGame);
            }
        } catch (IOException ex) {
            Logger.getLogger(DAOGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Game game : myList) {
                writer.write(String.format("%d,%s,%s,%d,%s,%.2f\n",
                        game.getID(),
                        game.getConsole(),
                        game.getGenre(),
                        game.getyearRelease(),
                        game.getName(),
                        game.getPrice()));
            }
        } catch (IOException ex) {
            Logger.getLogger(DAOGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String orderById() {
        myList.sort(Comparator.comparing(Game::getID));
        return this.toString();
    }

    public String orderByGenre() {
        myList.sort(Comparator.comparing(Game::getGenre));
        return this.toString();
    }

    public String orderByConsole() {
        myList.sort(Comparator.comparing(Game::getConsole));
        return this.toString();
    }

    public String orderByyearRelease() {
        myList.sort(Comparator.comparing(Game::getyearRelease));
        return this.toString();
    }

    public String orderByName() {
        myList.sort(Comparator.comparing(Game::getName));
        return this.toString();
    }

    public String orderByPrice() {
        myList.sort(Comparator.comparing(Game::getPrice).reversed());
        return this.toString();
    }

    public String orderByConsoleYearRelease() {
        myList.sort(Comparator.comparing(Game::getConsole).thenComparing(Game::getyearRelease));
        return this.toString();
    }

    
    public void Statistics() {
        double[] stats = new double[15];
        int counter = 0;
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                double price = Double.parseDouble(data[5]);
                stats[counter] = price;
                counter++;
            }
        } catch (IOException ex) {
            Logger.getLogger(DAOGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(counter);
        double sum = 0;
        double maximum = 0;
        double minimum = MAX_VALUE;
        for (int i = 0; i < counter; i++) {
            if (stats[i] >= maximum) {
                maximum = stats[i];
            }
            if (stats[i] <= minimum) {
                minimum = stats[i];
            }
            sum = stats[i] + sum;
        }
        double average = sum/(counter);
        System.out.println("The maximum price is: " + maximum);
        System.out.println("The minimum price is " + minimum);
        System.out.println("The sum of the prices is " + sum);
        System.out.println("The average of the prices is " + average);
        
        double total=0;
        double SD;
        for (int i=0; i<counter; i++){
            total=total+Math.pow((stats[i]-average),2);
        }
        SD = Math.sqrt(total/counter);
        System.out.println("The standard deviation is: "  + SD);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (Game game : myList) {
            sb.append(game).append("\n");
        }
        return sb.toString();
    }
}
