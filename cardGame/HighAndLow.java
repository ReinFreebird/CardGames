package cardGame;
import java.util.Scanner;
public class HighAndLow {
        Deck deck =new Deck();
        Card card1,card2;
        int round=0;
        HighAndLow(){
            
        }
        public void start(){
            this.deck.shuffleDeck();
        deck.shuffleDeck();
        deck.shuffleDeck();
        Scanner input= new Scanner(System.in);
        boolean correct=false,con=false;
        int round=0;
        System.out.println("============\nWELCOME TO\nHIGH & LOW\n"
                + "ver 0.0.1\nby ReinFreebird\n============");
        System.out.print("Press any key to continue...");
        try{
            System.in.read();
        }  
        catch(Exception e)
        {}  
        card1=deck.removeCard();
        do{
            card2=deck.removeCard();
            this.printRound(con);
            do{
                System.out.print("\n\n1.Higher\n2.Lower\nYour Choice: ");
                switch(input.nextInt()){
                    case 1:
                        correct=(card2.getPointID()>=card1.getPointID());
                        con=true;
                        break;
                    case 2:
                        correct=(card2.getPointID()<=card1.getPointID());
                        con=true;
                        break;
                }
            }while(con!=true);
            System.out.println("");
            this.printRound(con);
            if(correct&deck.getDeckSize()>0){
                System.out.print("\n\nWIN\n\n Play again?\n1.Yes\n2.No\n\nYour Choice: ");
            }else if(!correct){
                System.out.println("\n\nLOSE:(");
                break;
            }else{
                System.out.println("\n\nWIN\nYOU BEAT THE GAME\nCONGRATULATION :)");
                break;
            }
            card1=card2;
            con=false;
        }while(input.nextInt()!=2&deck.getDeckSize()>0);
        System.out.println("Thank you for playing ^.^)/");
    }
    public void printRound(boolean b){
        if(!b){
            //Round Start
            System.out.println("Round-"+(++round));
            System.out.println("Card 1\t\t\tCard 2");
            card1.printCard();
            System.out.print("\t???????");
        }else{
            //Round End
            System.out.println("Card 1\t\t\tCard 2");
            card1.printCard();
            System.out.print("\t");
            card2.printCard();
        }
    }    
    public static void main(String[] args) {
        HighAndLow game=new HighAndLow();
        game.start();
    }
}