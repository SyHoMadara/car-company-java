import libs.DListTraverseMethod;
import libs.DoubleLinkList;
import libs.Node;

public class allAgencies {

    public static DoubleLinkList<Agency> allAgencies = new DoubleLinkList<>();

    void addAgency(Agency agency) {
        allAgencies.pushBack(agency);
    }

    DoubleLinkList<Agency> getAllAgencies() {
        return allAgencies;
    }

    boolean canRemove(Agency agency) {
        Node<Agency> node = allAgencies.getTail();
        int count = 0;
        while (node != null) {
            if (node.data.getName().equals(agency.getName()))
                count++;
            node = node.pre;
        }
        if (count > 1) return false;
        else return true;
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
