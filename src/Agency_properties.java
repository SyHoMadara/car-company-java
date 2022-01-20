import java.util.ArrayList;

public class Agency_properties {

    private ArrayList<Integer> name;

    Agency_properties(ArrayList<Integer> list){
        for (int a : list) {
            name.add(a);
        }
    }

    ArrayList<Integer> name(){
        return name;
    }
}
