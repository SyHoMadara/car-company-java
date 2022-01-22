import libs.DListTraverseMethod;
import libs.DoubleLinkList;
import libs.Node;

public class Agency {

    public static DoubleLinkList<Agency> allAgencies = new DoubleLinkList<>();

    private String name;
    private DoubleLinkList<Service> AgencyServices = new DoubleLinkList<>();


    Agency(String name){
        this.name = name;
    }

    String getName(){
        return this.name;
    }

    void addService(Service service) {
        AgencyServices.pushBack(service);
    }

    void removeService(Service service) {
        Node<Service> node = search(service);
        if (node != null)
            AgencyServices.remove(node);
    }

    Node<Service> search(Service service) {
        Node<Service> node = AgencyServices.getTail();
        while (node != null) {
            if (node.data.getName().equals(service.getName()))
                return node;
            else {
                node = node.pre;
            }
        }
        return null;

    }

    void listAgencyServices() {
        AgencyServices.traverse(DLT);
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
