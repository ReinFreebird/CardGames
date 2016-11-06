package cardGame;
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
