import libs.DoubleLinkList;

public class Service {

    private String name;
    private DoubleLinkList<Service> subServices = new DoubleLinkList<>();

    Service(String name) {
        this.name = name;
    }

    String getName(){
        return this.name;
    }

    void addSubService(Service service) {
        this.subServices.pushTail(service);
    }

    DoubleLinkList<Service> getSubServices() {
        return subServices;
    }

}
