
public class Place {
    private String name ;
    public String address ;
    public int price ;
    public Place(String name,String address,int price){
        this.name = name;
        this.address = address;
        this.price = price;
    }
    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return address;
    }
    public int getPrice(){
        return price;
    }
}
