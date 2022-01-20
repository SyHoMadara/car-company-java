import libs.DoubleLinkList;
import libs.Node;

public class Main {

    public static void main(String args[]) {

        Node<Agency_properties> a = new Node<>();
        DoubleLinkList<Agency_properties> dll = new DoubleLinkList<>();
        Agency_properties agency_properties = new Agency_properties("kabol");
        dll.pushTail(agency_properties);
        System.out.print(dll.getAt(0).data.name());
    }
}
