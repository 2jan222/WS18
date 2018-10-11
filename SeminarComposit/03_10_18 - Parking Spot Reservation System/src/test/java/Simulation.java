import com.github._2jan222.Client;
import com.github._2jan222.ManagementServer;
import com.github._2jan222.ParkingSpot;

import java.util.LinkedList;

/**
 * Simulation for parking system
 * @author Janik Mayr on 05.10.2018
 */
public class Simulation {
    public static void main(String... args) {
        ManagementServer managementServer = new ManagementServer();
        new Thread(managementServer);
        managementServer.start(8080);

        Client client = new Client();

        client.connect("localhost",8080);
        LinkedList<ParkingSpot> spotList = client.getSpotList();
        for (ParkingSpot p : spotList) {
            System.out.println("ID:" +  p.getId() + "Occupied:" + p.isOccupied());
        }
    }
}
