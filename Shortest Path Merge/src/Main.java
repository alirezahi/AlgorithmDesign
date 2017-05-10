import com.sun.tools.doclint.HtmlTag;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    private static int Max_num = 10;
    private static int Exit_num = -1;
    public static ArrayList<City> make_city(){
        ArrayList<City> cities = new ArrayList<>();

        //Start First City
        ArrayList<Residence> residences = new ArrayList<>();
        Residence residence = new Residence("Time Square Hotel","Manhattan Time Squares",20000,10);
        Residence residence1 = new Residence("Wingate","Manhattan Midtown",10000,7);
        Residence residence2 = new Residence("Nyma","Center Place of Manhattan",5000,11);
        residences.add(residence);
        residences.add(residence1);
        residences.add(residence2);
        ArrayList<Attraction> attractions = new ArrayList<>();
        Attraction attraction = new Attraction("Empire State Building","350 5th Ave NY",10000,"landmark");
        Attraction attraction1 = new Attraction("Central Park","NY 10024",15000,"Park");
        attractions.add(attraction);
        attractions.add(attraction1);
        //End First City
        cities.add(new City("Manhattan",residences,attractions));

        //Start Second City
        ArrayList<Residence> residences_1 = new ArrayList<>();
        Residence residence_ = new Residence("InterContinental","Midtown of Washington",20000,30);
        Residence residence_1 = new Residence("Wingate","Manhattan Midtown",10000,7);
        residences_1.add(residence_);
        residences_1.add(residence_1);
        ArrayList<Attraction> attractions_1 = new ArrayList<>();
        Attraction attraction_ = new Attraction("National Mall","240 3th Ave NY",20000,"Mall");
        Attraction attraction_1 = new Attraction("United States Capitol","NY 9239",10000,"Capitol");
        attractions_1.add(attraction_);
        attractions_1.add(attraction_1);
        //End Second City
        cities.add(new City("Washington",residences_1,attractions_1));

        return cities;
    }
    public static void main(String[] args){
        ArrayList<City> cities = make_city();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the Primary Money(We Recommend a little more than 100000) : ");
        Client client = new Client(sc.nextInt());
        System.out.println("Hello to the Tourism System");
        System.out.println("Your current Cash is : " + client.money);
        System.out.println("1.To Choose a City");
        System.out.println("-1.Exit");
        int current_state = 0;
        int next_state = sc.nextInt();
        int city_chosen = 0;
        int place_chosen = 0;
        while(next_state != Exit_num){
            if(next_state == -2)
                current_state = 0;
            else if(current_state == 0 && next_state == 1){
                current_state = 1;
            }
            else if(current_state == 0){
                if(next_state == 2 || next_state == 3)
                    client.PrintOrdersd();
                if(next_state == 3){
                    System.out.print("Print number of your removing item : ");
                    int remove_num = sc.nextInt();
                    client.money += client.orders.get(remove_num-1).getPrice()*client.orders.get(remove_num-1).getCapacity()/2;
                    client.orders.remove(remove_num-1);
                    System.out.println("Removed successfully . Your current money is : "+client.money);
                }
            }
            else if(current_state == 1){
                if(next_state > 0 && next_state-1 < cities.size()){
                    city_chosen = next_state-1;
                    current_state = 2;
                }
            }
            else if(current_state == 2){
                if(next_state>0 && next_state<cities.get(city_chosen).getResidences().size()+cities.get(city_chosen).getAttractions().size()+1){
                    current_state =3;
                    place_chosen = next_state-1;
                }
            }
            else if(current_state == 3 && next_state ==1)
                current_state = 0;
            if(current_state == 0){
                System.out.println("Your current Cash is : " + client.money);
                System.out.println("1.To Choose a City");
                if(client.orders.size()>0) {
                    System.out.println("2.To list orders");
                    System.out.println("3.To Cancel orders");
                }
                System.out.println("-1.Exit");
            }
            else if(current_state == 1){
                for(int i=0;i<cities.size();i++){
                    System.out.println((i+1)+"."+cities.get(i).name);
                }
                System.out.println("-2.Return to Menu");
                System.out.println("-1.Exit");
            }
            else if(current_state == 2){
                int i=0;
                for(int j=0;j<cities.get(city_chosen).getResidences().size();j++){
                    Residence a = cities.get(city_chosen).getResidences().get(j);
                    System.out.println((i+1)+"." + a.getName() + " / Price (each person) : "+a.getPrice() +" / Capacity : " + a.getCapacity() + " / Address : " + a.getAddress());
                    i++;
                }
                for(int j=0;j<cities.get(city_chosen).getAttractions().size();j++){
                    Attraction a = cities.get(city_chosen).getAttractions().get(j);
                    System.out.println((i+1)+"." + a.getName() + " / Price : "+a.getPrice() +" / Category : " + a.getCategory() + " / Address : " + a.getAddress());
                    i++;
                }
                System.out.println("-2.Return to Menu");
                System.out.println("-1.Exit");
            }
            else if(current_state == 3){
                if(place_chosen<cities.get(city_chosen).getResidences().size()){
                    System.out.println("Enter the Ideal Capacity : ");
                    int mon = sc.nextInt();
                    if(mon <1 || mon > cities.get(city_chosen).getResidences().get(place_chosen).getCapacity())
                        System.out.println("You Entered invalid capacity");
                    else if(client.getMoney() >= cities.get(city_chosen).getResidences().get(place_chosen).getPrice()*mon) {
                        if (client.repetitive_order(cities.get(city_chosen).getName(), cities.get(city_chosen).getResidences().get(place_chosen).getName())){
                            client.spendMoney(cities.get(city_chosen).getResidences().get(place_chosen).getPrice() * mon);
                            client.setOrders(cities.get(city_chosen).getName(), cities.get(city_chosen).getResidences().get(place_chosen).getName(), cities.get(city_chosen).getResidences().get(place_chosen).getPrice(), mon);
                            System.out.println("You reserved. Your Current Money is : " + client.getMoney());
                        }
                        else
                            System.out.println("You have reserved here before");
                    }
                    else{
                        System.out.println("Your Money is not enough");
                    }
                }
                else{
                    if(client.getMoney() >= cities.get(city_chosen).getAttractions().get(place_chosen-cities.get(city_chosen).getResidences().size()).getPrice()) {
                        if(client.repetitive_order(cities.get(city_chosen).getName(),cities.get(city_chosen).getAttractions().get(place_chosen-cities.get(city_chosen).getResidences().size()).getName())) {
                            client.spendMoney(cities.get(city_chosen).getAttractions().get(place_chosen - cities.get(city_chosen).getResidences().size()).getPrice());
                            client.setOrders(cities.get(city_chosen).getName(), cities.get(city_chosen).getAttractions().get(place_chosen - cities.get(city_chosen).getResidences().size()).getName(), cities.get(city_chosen).getAttractions().get(place_chosen - cities.get(city_chosen).getResidences().size()).getPrice(), 1);
                            System.out.println("You reserved. Your Current Money is : " + client.getMoney());
                        }
                        else
                            System.out.println("You have reserved here before");

                    }
                    else{
                        System.out.println("Your Money is not enough");
                    }
                }
                System.out.println("1.To Continue");
                System.out.println("-2.Main Menu");
                System.out.println("-1.Exit");
                current_state = 0;
            }
            next_state = sc.nextInt();
        }
    }
}