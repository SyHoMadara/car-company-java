import libs.DListTraverseMethod;
import libs.DoubleLinkList;
import libs.Node;

public class allServices {

    private DoubleLinkList<Service> allServices = new DoubleLinkList<>();

    void addService(Service service) {
        allServices.pushBack(service);
    }

    DoubleLinkList<Service> getAllServices() {
        return allServices;
    }

    void listServices() {
        allServices.traverse(DLT);
    }

    DListTraverseMethod<Service> DLT = new DListTraverseMethod<Service>() {
        @Override
        public void start(Node<Service> node) {
            System.out.println(node.data.getName());
            if (node.data.getSubServices().getLength() > 0) {
                node.data.getSubServices().traverse(DLT);
            }
        }
    };

}
