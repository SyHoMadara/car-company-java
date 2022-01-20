import java.util.ArrayList;

public class Agency {

    static public ArrayList<Agency> allAgency = new ArrayList<>();

    private String name;

    Agency(String name){
        this.name = name;
    }

    String name(){
        return this.name;
    }
}
