
public class Order {
    String city_name;
    String place_name;
    int price;
    int capacity;
    public Order(String city_name,String place_name,int Price , int capacity){
        this.city_name = city_name;
        this.place_name = place_name;
        this.price = Price;
        this.capacity = capacity;
    }
    public String getCity_name(){
        return city_name;
    }
    public String getPlace_name(){
        return place_name;
    }
    public int getPrice(){
        return price;
    }
    public int getCapacity(){
        return capacity;
    }
}
