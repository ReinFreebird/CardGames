package cardGame;

/**
 *
 * @author USER LENOVO
 */
public class Poker {
    Deck deck=new Deck();
    Hand h1,h2,h3,h4;
    Poker(){
        
    }
    public void start(){
        h1=new Hand();
        h1.drawCard(new Card(1,2));
        h1.drawCard(new Card(13,1));
        h1.drawCard(new Card(12,1));
        h1.drawCard(new Card(11,1));
        h1.drawCard(new Card(10,1));
        this.checkHandPower(h1);
    }
    public static void main(String[] args) {
        Poker p=new Poker();
        p.start();
    }
    public void checkHandPower(Hand x){
        /*
        Hand Power Rank:
        1.Royal Flush 11
        2.Royal Straight 10
        3.Straight Flush 9
        4.Four of a Kind 8
        5.Full House 7
        6.Flush 6
        7.Straight 5
        8.Three of a Kind 4
        9.Two Pairs 3
        10.One Pair 2
        11.Ace High 1
        */
        x.sortHandByValue();
        String cardPower="";//Pairs, Two pairs, etc.
        int cardPowerID=0;//Card power, lower ID lower Power
        int[]pairStartPos={-1,-1};//Position for Pairs
        int numberOfPairs=0;//Number of Pairs.
        boolean three=false,four=false,pairs=false;
        int straightFirstValue; //The value of the starting card of a straight. If ten then it's Royal
        boolean straight=false,flush=false,royal=false;
        
        //Check for Pairs,Three and Four
        for (int i = 0; i < x.getHandSize()-1;) {
            if(x.getHand(i).getPointID()==x.getHand(i+1).getPointID()){
                if(i<3){
                    if(x.getHand(i).getPointID()==x.getHand(i+2).getPointID()){
                        if(i<2){
                            if(x.getHand(i).getPointID()==x.getHand(i+3).getPointID()){
                                four=true;
                                i=i+4;
                            }else{
                                three=true;
                                i=i+3;}
                        }else{
                        three=true;
                        i=i+3;}
                    }else{
                        numberOfPairs++;
                        pairs=true;
                        i=i+2;}
                }else{
                pairs=true;
                i=i+2;}
            }else{
            i++;}
        }
        //Check for Straight
        //Ace can be valued as 1(true) or 14(false)
        int a,b,c,d;
        straightFirstValue=x.getHand(0).getPointID();
        if(x.getHand(0).getPointID()==2&x.getHand(4).getPointID()==14){
            a=x.getHand(0).getPointID()-(x.getHand(4).getPointID()-13);
            b=x.getHand(1).getPointID()-x.getHand(0).getPointID();
            c=x.getHand(2).getPointID()-x.getHand(1).getPointID();
            d=x.getHand(3).getPointID()-x.getHand(2).getPointID();
        }else{
            a=x.getHand(1).getPointID()-x.getHand(0).getPointID();
            b=x.getHand(2).getPointID()-x.getHand(1).getPointID();
            c=x.getHand(3).getPointID()-x.getHand(2).getPointID();
            d=x.getHand(4).getPointID()-x.getHand(3).getPointID();
        }
        if(a+b+c+d==4){
            straight=true;
            if(straightFirstValue==10){
                royal=true;
            }
        }
        //Check for Flush
        for (int i = 0; i < x.getHandSize()-1; i++) {
            flush=true;
            if(x.getHand(i+1).getSuitID()!=x.getHand(i).getSuitID()){
                flush=false;
                break;
                }
        }
        if(royal){
            if(flush){
                cardPower="Royal Flush";
                cardPowerID=11;
            }else{
                cardPower="Royal Straight";
                cardPowerID=10;
            }
        }else if(straight){
            if(flush){
                cardPower="Straight Flush";
                cardPowerID=9;
            }else{
                cardPower="Straight";
                cardPowerID=5;
            }
        }else if(four){
            cardPower="Four of a Kind";
                cardPowerID=8;
        }else if(flush){
            cardPower="Flush";
                cardPowerID=6;
        }else if(three){
            if(pairs){
                cardPower="Full House";
                cardPowerID=7;
            }else{
                cardPower="Three of a Kind";
                cardPowerID=4;
            }
        }else if(pairs){
            if(numberOfPairs==2){
                cardPower="Two Pairs";
                cardPowerID=3;
            }else{
                cardPower="One Pair";
                cardPowerID=2;
            }
        }else{
            cardPower="Ace High";
                cardPowerID=1;
        }
        x.checkHand();
        System.out.println(cardPower);
    }
}
