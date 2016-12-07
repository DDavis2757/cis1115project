
package myproject;

/**
 *
 * @author Dillon Davis
 */
public class GameApp2 {
    public static void main(String[] args) {
        DAOGame data = new DAOGame();
        data.create(new Game(2, "PS4", "Action", 2016, "Battlefield 1", 59.99));
        data.create(new Game(3, "PC", "Card", 2014, "Hearthstone", 0.00));
        data.create(new Game(4, "XBOX 1", "RPG", 2014, "Final Fantasy XIV", 49.99));
        System.out.println(data);
        
        System.out.println(data.retrieve(3));
        System.out.println(data.retrieve(-1));
        
        data.update(new Game(2, "NES", "Adventure", 1985, "The Legend of Zelda", 4.99));
        System.out.println(data.retrieve(2));
        
        data.delete(2);
        System.out.println(data.retrieve(2));
    }
}
