package dice;
import java.util.ArrayList;
import java.util.Scanner;
public class dice {
    //Class Attribute
    private int diceValue[] = new int[4];
    private int sumDiceValue;

    //Constructor Method
    dice() {
    }

    dice(int diceValue[] , int sumDiceValue) {
        this.diceValue[0] = diceValue[0];
        this.diceValue[1] = diceValue[1];
        this.diceValue[2] = diceValue[2];
        this.diceValue[3] = diceValue[3];
        this.sumDiceValue = sumDiceValue;
    }
    
    public static void main(String[] args) {
        //Local Attribute
        int choice , money , guess[];

        while(true) {
            dice dice = new dice();
            person person = new person();
            Scanner scan = new Scanner(System.in);

            //Random Dice Point 1 - 6
            dice.diceValue[0] = 1 + (int) (Math.random() * 6);
            dice.diceValue[1] = 1 + (int) (Math.random() * 6);
            dice.diceValue[2] = 1 + (int) (Math.random() * 6);
            dice.setDiceValue(dice.diceValue);
            dice.getDiceValue();
            dice.sumDiceValue = dice.calSumDiceValue(dice.diceValue);

            //Choice
            System.out.println("1 . Guess Sum");
            System.out.println("2 . Guess 3 Time");
            System.out.print("-------------> ");
            person.setChoice(scan.nextInt());
            choice = person.getChoice();
            guess = person.getGuess();

            //Wrong Choose
            while(choice != 1 && choice != 2){
                System.out.print("Please Try Again : ");
                person.setChoice(scan.nextInt());
                choice = person.getChoice();
                // System.exit(0);
            }

            //Input Money
            System.out.print("Money(-1 For Program Exit) : ");
            person.setMoney(scan.nextInt());
            money = person.getMoney();
            if(money == -1) {                
                System.out.println("===============");
                System.out.println("Program Exit");                
                System.out.println("===============");
                System.exit(1);
            }

            //Choice 1(Money * 2)
            if(choice == 1) {
                //Set Guess
                System.out.print("Enter Sum of Dice : ");
                guess[0] = scan.nextInt();
                person.setGuess(guess);

                if(guess[0] == dice.sumDiceValue) {  //
                    money *= 2;
                    System.out.println("-----------------------------");
                    System.out.println("========== You Win ==========");        
                    //Show Point of Dice
                    System.out.println(dice.showDicePoint(dice.diceValue));   
                    System.out.println("Sum of Dice : " + dice.sumDiceValue);
                    System.out.println("Money : " + money);
                    System.out.println("-----------------------------");
                }else {
                    System.out.println("-----------------------------");
                    System.out.println("========= You Lose =========");                
                    //Show Point of Dice
                    System.out.println(dice.showDicePoint(dice.diceValue));   
                    System.out.println("Sum of Dice : " + dice.sumDiceValue);
                    System.out.println("-----------------------------");
                }
            }

            //Choice 2(Money * 6)
            else if(choice == 2) {
                //Set Guess
                System.out.print("Enter Dice 1 : ");
                guess[1] = scan.nextInt();
                System.out.print("Enter Dice 2 : ");
                guess[2] = scan.nextInt();
                System.out.print("Enter Dice 3 : ");
                guess[3] = scan.nextInt();
                person.setGuess(guess);

                //Right or Wrong
                if(dice.rightOrWrong(guess , dice.diceValue) == true) {
                    money *= 6;                
                    System.out.println("-----------------------------");
                    System.out.println("========== You Win ==========");        
                    //Show Point of Dice
                    System.out.println(dice.showDicePoint(dice.diceValue));   
                    System.out.println("Sum of Dice : " + dice.sumDiceValue);
                    System.out.println("Money : " + money);
                    System.out.println("-----------------------------");
                }else {
                    System.out.println("-----------------------------");
                    //Show Point of Dice
                    System.out.println("========= You Lose =========");                
                    System.out.println(dice.showDicePoint(dice.diceValue));   
                    System.out.println("Sum of Dice : " + dice.sumDiceValue);
                    System.out.println("-----------------------------");
                }
            }
        }
    }

    //Setter Method
    public void setDiceValue(int diceValue[]) {
        this.diceValue[0] = diceValue[0];
        this.diceValue[1] = diceValue[1];
        this.diceValue[2] = diceValue[2];
    }
    
    //Getter Method
    public int[] getDiceValue() {
        return this.diceValue;
    }

    //Facility Method
    //Sum of Dice Value
    public int calSumDiceValue(int diceValue[]) {
        getDiceValue();
        return this.diceValue[0] + this.diceValue[1] + this.diceValue[2];
    }

    //Right or Wrong
    public boolean rightOrWrong(int guess[] , int diceValue[]) {
        if((guess[1] == this.diceValue[0]) && (guess[2] == this.diceValue[1]) && (guess[3] == this.diceValue[2])) {
            return true;
        }else {
            return false;
        }
    }

    //Show Dice Point
    public String showDicePoint(int diceValue[]) {
        //Point of Dice
        return "Point of Dice : " + this.diceValue[0] + " " + this.diceValue[1] + " " + this.diceValue[2];   
    }
}

//New Class
class person {
    private int money , choice;
    private int guess[] = new int[4];

    //Setter Method
    public void setMoney(int money) {  
        this.money = money;
    }
    
    public void setGuess(int guess[]) {
        this.guess[0] = guess[0];
        this.guess[1] = guess[1];
        this.guess[2] = guess[2];
        this.guess[3] = guess[3];
    }

    public void setChoice(int choice) { 
        this.choice = choice;
    }

    //Getter Method
    public int getChoice() {
        return this.choice;
    }
    
    public int getMoney() {
        return this.money;
    }

    public int[] getGuess() {
        return this.guess;
    }

    
}