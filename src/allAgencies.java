import libs.DListTraverseMethod;
import libs.DoubleLinkList;
import libs.Node;

public class allAgencies {

    public static DoubleLinkList<Agency> allAgencies = new DoubleLinkList<>();

    void addAgency(Agency agency){
        allAgencies.pushBack(agency);
    }

    DoubleLinkList<Agency> getAllAgencies() {
        return allAgencies;
    }




    void listAgencies() {
        allAgencies.traverse(DLT);
    }

    DListTraverseMethod<Agency> DLT = new DListTraverseMethod<>() {
        @Override
        public void start(Node<Agency> node) {
            System.out.println(node.data.getName());
        }
    };
}
