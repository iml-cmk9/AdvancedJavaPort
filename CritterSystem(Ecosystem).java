import java.util.Scanner;
import java.util.Random;

public class Ecosystem {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        
        int size = 5;
       
        Critter[][] world = new Critter[size][size];
        
        int born = 0;
        int dead = 0;
        
        world[0][0] = new Critter("Rabbit", "M", "Male");
        world[0][1] = new Critter("Rabbit", "F", "Female");
        world[1][0] = new Critter("Rabbit", "M", "Male");
        world[1][1] = new Critter("Rabbit", "F", "Female");
        
        world[3][3] = new Critter("Wolf", "W", "None");
        world[4][4] = new Critter("Wolf", "W", "None");
        world[2][4] = new Critter("Wolf", "W", "None");
        world[4][2] = new Critter("Wolf", "W", "None");
        
        System.out.print("How many cycles to run? ");
        int cycles = input.nextInt();
        
        

        for (int c = 1; c <= cycles; c++) {
            
            Critter[][] newWorld = new Critter[size][size];
        
            for (int r = 0; r < size; r++){
                for(int col = 0; col < size; col++){
                    if (world[r][col] != null){
                    Critter current = world[r][col];
                    
                    //move code that's new cuz it wasn't working
                    int[] move = current.move();
                    int newRow = r + move[0];
                    int newCol = col + move[1];
                    
                    if (newRow < 0 || newRow >= size){
                        newRow = r;
                    }
                    
                    if (newCol < 0 || newCol >= size){
                        newCol = col;
                    }
                    
                    if (newWorld[newRow][newCol] == null){
                        newWorld[newRow][newCol] = current;
                    } else {
                        Critter other = newWorld[newRow][newCol];
                        
                        if(current.getType().equals("Wolf") && other.getType().equals("Rabbit")){
                            dead++;
                            newWorld[newRow][newCol] = current;
                        } else if (current.getType().equals("Rabbit") && other.getType().equals("Wolf")){
                            dead++;
                        } else if (current.getType().equals("Rabbit") && other.getType().equals("Rabbit")){
                            if (!current.getGender().equals(other.getGender())){
                                born++;
                                
                                int babyRow = rand.nextInt(size);
                                int babyCol = rand.nextInt(size);
                                
                                if (newWorld[babyRow][babyCol] == null){
                                    newWorld[babyRow][babyCol] = new Critter("Rabbit", "B", "Male");
                                }
                            }
                        }
                        
                    }
                }
            }
        }
        
        world = newWorld;
        
        System.out.println("\n--- Cycle " + c + " ---");
        
        for (int r = 0; r < size; r++){
            for (int col = 0; col < size; col++){
                if(world[r][col] == null){
                    System.out.print(". ");
                } else {
                    System.out.print(world[r][col].getSymbol() + " ");
                }
                }
                System.out.println();
            }
        }
        System.out.println("\nSimulation Over!");
        System.out.println("Bunnies born: " + born);
        System.out.println("Bunnies eaten: " + dead);
        System.out.println("I'm so tuff and I am sastified with my care");
        input.close();
    }
}



//Plan: I'm gonna make it unique by making a male bunny mate with a
//      female bunny and if a bunny lands on a spot with a 
//      wolf then it immediately dies. By the end of however many cyles
//      player wants, it well tell you how many bunnies were made
//      and how many died from wolves. There is 4 males, 4 females, 
//      and 4 wolves. Also it well it's tuff asl.
