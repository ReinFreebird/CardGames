package cardGame;
class Card{
    private String value;
    private String suit;
    private int pointID,suitID;
    Card(int v,int s){
        this.pointID=v;
        if (v==1)
            pointID=14;
        switch (v){
            case 1:this.value="Ace";break;
            case 2:this.value="2";break;
            case 3:this.value="3";break;
            case 4:this.value="4";break;
            case 5:this.value="5";break;
            case 6:this.value="6";break;
            case 7:this.value="7";break;
            case 8:this.value="8";break;
            case 9:this.value="9";break;
            case 10:this.value="10";break;
            case 11:this.value="Jack";break;
            case 12:this.value="Queen";break;
            case 13:this.value="King";break;
                
        }
        suitID=s;
        switch (s){
            case 1:suit="Club";break;
            case 2:suit="Spade";break;
            case 3:suit="Heart";break;
            case 4:suit="Diamond";break;
            default:
        }
    }
    public int getPointID(){
        return pointID;
    }
    public int getSuitID(){
        return suitID;
    }
    public void printCard(){
        System.out.println(value+" of "+suit);
    }
    public String getValue(){
        return value;
    }
    public String getSuit(){
        return suit;
    }
    public boolean isSame(Card x){
        if(x==null){
            return false;
        }
        if(this.value.equalsIgnoreCase(x.value)){
            if(this.suit.equalsIgnoreCase(x.suit)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
class Hand{
    private Card[] hand= new Card[5];
    private Card highestCard=null;
    private int handSize=0;
    public Card getHand(int x){
        return hand[x];
    }
    public int getHandSize(){
        return handSize;
    }
    public void drawCard(Card x){
        hand[handSize++]=x;
        if(highestCard==null){
            highestCard=x;
        }else{
            for (int i = 0; i < handSize; i++) {
                if(x.getPointID()>highestCard.getPointID()){
                    highestCard=x;
                    break;
                }
            }
        }
    }
    public void checkHand(){
        System.out.println("Hand");
        for (int i = 0; i < handSize; i++) {
            hand[i].printCard();
            System.out.println("");
        }
    }
    public Card getHighestCard(){
        return highestCard;
    }
    
    public void printHighestCard(){
        highestCard.printCard();
    }
    public void sortHandByValue(){
        //Sort using Bubble Sort
        Card temp=new Card(2,2);
        for (int i=handSize-1;i>0;i--){
            for (int j = 0; j <handSize-1 ; j++) {
                if(hand[j].getPointID()>=hand[j+1].getPointID()){
                    temp=hand[j];
                    hand[j]=hand[j+1];
                    hand[j+1]=temp;
                }
            }
        }
    }
}
class Deck{
    private Card[] deck=new Card [52];
    private int deckSize=0;
    Deck(){
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 13; j++) {
                deck[deckSize++]=new Card(j,i);
            }
        }
    }
    public void checkDeck(){
        for (int i = 0; i < deckSize; i++) {
            deck[i].printCard();
        }
    }
    public void shuffleDeck(){
        Card[]shuffledDeck=new Card[52];
        int select;
        boolean con=false;
        for (int i = 0; i < deckSize; i++) {
            do{
                select=(int)(Math.random()*deckSize);
                for (int j = 0; j <= i; j++) {
                    if(deck[select].isSame(shuffledDeck[j])){
                        break;
                    }else if(j==i){
                        con=true;
                    }
                }
            }while(con==false);
            con=false;
            shuffledDeck[i]=deck[select];
        }
        deck=shuffledDeck;
    }
    public Card removeCard(){
        Card removedCard=deck[--deckSize];
        deck[deckSize]=null;
        return removedCard;
    }
    public int getDeckSize(){
        return deckSize;
    }
}
public class CardGameComponents {
    public static void main(String[] args) {
        Deck d=new Deck();
        
    }
}
