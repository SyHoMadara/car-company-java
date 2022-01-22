import libs.DoubleLinkList;
import libs.Node;

public class Main {

    public static void main(String args[]) {

        allAgencies allAgencies = new allAgencies();

        Agency agency = new Agency("kabol");
        Agency agency2 = new Agency("tehran");
        Agency agency3 = new Agency("qazvin");

        allAgencies.addAgency(agency);
        allAgencies.addAgency(agency2);
        allAgencies.addAgency(agency3);

        allAgencies.listAgencies();

        System.out.println("--------------");


        allServices allServices = new allServices();
        Service service1 = new Service("lastik");
        Service service2 = new Service("rang");
        Service service1_1 = new Service("panchar");
        Service service1_1_1 = new Service("panchar aqab");
        Service service1_1_2 = new Service("panchar jolo");
        Service service2_1 = new Service("rang baraq");


        service1.addSubService(service1_1);
        service1_1.addSubService(service1_1_1);
        service2.addSubService(service2_1);
        service1_1.addSubService(service1_1_2);


        allServices.addService(service1);
        allServices.addService(service2);

        allServices.listServices();

        agency2.addService(service1);
        agency2.addService(service2);

        System.out.println("--------------");

        agency2.listAgencyServices();
        System.out.println("--------------");

        agency2.removeService(service2);
        agency2.listAgencyServices();


    }
}
