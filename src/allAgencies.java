import libs.DListTraverseMethod;
import libs.DoubleLinkList;
import libs.Node;

public class allAgencies {

    private DoubleLinkList<Agency> allAgencies = new DoubleLinkList<>();

    void addAgency(Agency agency){
        allAgencies.pushTail(agency);
    }

    DoubleLinkList<Agency> getAllAgencies() {
        return allAgencies;
    }

    boolean checkService(Service service) {
        int count = 0;
        for (Agency a : this.allAgencies) {
            a.
        }
        return false;
    }

    void listAgencies() {
        allAgencies.traverse(DLT);
    }

    DListTraverseMethod<Agency> DLT = new DListTraverseMethod<Agency>() {
        @Override
        public void start(Node<Agency> node) {
            System.out.println(node.data.getName());
        }
    };
}
