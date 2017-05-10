
public class Attraction extends Place {
    public String category ;
    public Attraction(String name, String address,int price,String category){
        super(name,address,price);
        this.category = category;
    }
    public String getCategory(){
        return this.category;
    }
}
