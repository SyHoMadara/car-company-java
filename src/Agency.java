import libs.DListTraverseMethod;
import libs.DoubleLinkList;
import libs.Node;

public class Agency {

    private String name;
    private DoubleLinkList<Service> AgencyServices = new DoubleLinkList<>();


    Agency(String name){
        this.name = name;
    }

    String getName(){
        return this.name;
    }

    void addService(Service service) {
        AgencyServices.pushTail(service);
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
