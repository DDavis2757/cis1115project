
package myproject;

/**
 *
 * @author Dillon Davis
 */
public class GameApp {
    
    public static void main(String[] args) {
        
        Game game1= new Game(2, "PS4", "Action", 2016, "Battlefield 1", 59.99);
        Game game2= new Game(3, "PC", "Card", 2014, "Hearthstone", 0.00);
        Game game3 = new Game(4, "XBOX 1", "RPG", 2014, "Final Fantasy XIV", 49.99);
        System.out.println(game1);
        System.out.println(game2);
        System.out.println(game3);
    }

    
}
