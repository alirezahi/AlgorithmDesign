import java.util.ArrayList;

public class City {
    public ArrayList<Residence> residences ;
    public ArrayList<Attraction> attractions ;
    public String name;
    public City(String name, ArrayList<Residence> residences,ArrayList<Attraction> attractions){
        this.residences = residences;
        this.attractions = attractions;
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public ArrayList<Residence> getResidences(){
        return this.residences;
    }
    public ArrayList<Attraction> getAttractions(){
        return this.attractions;
    }
}
