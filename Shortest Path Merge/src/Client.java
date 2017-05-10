
import java.util.ArrayList;

public class Client {
    public int money ;
    ArrayList<Order> orders  = new ArrayList<>();
    public Client (int money){
        this.money = money;
    }
    public void spendMoney(int spendM){
        this.money -=spendM;
    }
    public int getMoney(){
        return money;
    }
    public void setOrders(String city_name,String place_name,int Price , int capacity){
        orders.add(new Order(city_name,place_name,Price,capacity));
    }
    public boolean repetitive_order(String city_name,String place_name){
        for(Order i : orders){
            if(i.getCity_name() == city_name && i.getPlace_name() == place_name){
                return false;
            }
        }
        return true;
    }
    public void PrintOrdersd(){
        for (int i=0;i<orders.size();i++)
            System.out.println((i+1)+"." + orders.get(i).getCity_name() + " " + orders.get(i).getPlace_name() + " " + orders.get(i).price*orders.get(i).getCapacity());
    }
}
