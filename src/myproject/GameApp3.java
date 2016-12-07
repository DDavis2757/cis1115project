
package myproject;

/**
 *
 * @author Dillon Davis
 */
public class GameApp3 {
    public static void main(String[] args) {
        DAOGame data = new DAOGame();
        System.out.println(data);
        
        data.create(new Game(2, "PS4", "Action", 2016, "Battlefield 1", 59.99));
        System.out.println(data);
            
    }
}
