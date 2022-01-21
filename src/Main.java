import libs.DListTraverseMethod;
import libs.DoubleLinkList;
import libs.Node;

public class Main {

    public static void main(String args[]) {

        DoubleLinkList<Agency> dll = new DoubleLinkList<>();
        Node<Agency> a = new Node<>();

        allAgencies allAgency = new allAgencies();
        Agency agency = new Agency("kabol");
        Agency agency2 = new Agency("tehran");
        Agency agency3 = new Agency("qazvin");

        allAgency.addAgency(agency);
        allAgency.addAgency(agency2);
        allAgency.addAgency(agency3);

        allAgency.listAgencies();

    }
}
