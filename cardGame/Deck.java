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

            }while(deck[select]==null);
            shuffledDeck[i]=deck[select];
            deck[select]=null;
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
