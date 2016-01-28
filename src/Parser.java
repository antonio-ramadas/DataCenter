import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by m_bot on 28/01/2016.
 */
public class Parser {
    int rows;
    int slots;
    int unavailableSlots;
    int pools;
    int nrServers;

    int[][] map;
    HashMap<Integer, Server> servers = new HashMap<>();

    public Parser() {
        int index = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("data/dc.in"))) {
            String line = reader.readLine();
            String[] parts = line.split(" ");
            rows = Integer.parseInt(parts[0]);
            slots = Integer.parseInt(parts[1]);
            unavailableSlots = Integer.parseInt(parts[2]);
            pools = Integer.parseInt(parts[3]);
            nrServers = Integer.parseInt(parts[4]);

            map = new int[rows][slots];

            for (int i = 0; i < unavailableSlots; i++) {
                String temp = reader.readLine();
                String[] temp1 = temp.split(" ");
                int coordX = Integer.parseInt(temp1[0]);
                int coordY = Integer.parseInt(temp1[1]);

                map[coordX][coordY] = -1;
            }

            for (int i = 0; i < nrServers; i++) {
                String temp = reader.readLine();
                String[] temp1 = line.split(" ");
                Server server = new Server(Integer.parseInt(temp1[0]), Integer.parseInt(temp1[1]));
                servers.put(index, server);
                index++;
            }

        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getUnavailableSlots() {
        return unavailableSlots;
    }

    public void setUnavailableSlots(int unavailableSlots) {
        this.unavailableSlots = unavailableSlots;
    }

    public int getPools() {
        return pools;
    }

    public void setPools(int pools) {
        this.pools = pools;
    }

    public int[][] getMap() {
        return map;
    }

    public HashMap<Integer, Server> getServers() {
        return servers;
    }
}
