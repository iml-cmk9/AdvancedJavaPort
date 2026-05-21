import java.util.Random;

public class Critter {
    private String type;
    private String symbol;
    private String gender;

    public Critter(String type, String symbol, String gender ) {
        this.type = type;
        this.symbol = symbol;
        this.gender = gender;
    }
    // Task for Students: Define how the critter moves
    // YOUR CODE HERE
    
    
    public int[] move() {
        Random rand = new Random();
        int direction = rand.nextInt(4);
        
        if (direction == 0){
            return new int[]{-1,0};
        } else if (direction == 1){
            return new int[]{1,0};
        } else if (direction == 2){
            return new int[]{0,-1};
        } else {
            return new int[]{0, 1};
        }
    }
    
    public int moveCol(){
        Random rand = new Random();
        return rand.nextInt(3) - 1;
    }
    
    public String getType(){
        return type;
    }
    
    public String getSymbol(){
        return symbol;
    }
    
    public String getGender(){
        return gender;
    }
    
    
}
