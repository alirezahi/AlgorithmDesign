
public class Residence extends Place {
    private int capacity;
    public Residence(String name,String address,int price,int capacity){
        super(name,address,price);
        this.capacity = capacity;
    }
    public int getCapacity(){
        return this.capacity;
    }

}
