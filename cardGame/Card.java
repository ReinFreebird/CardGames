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
