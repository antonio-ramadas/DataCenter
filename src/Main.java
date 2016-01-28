import java.util.Vector;

/**
 * Created by m_bot on 28/01/2016.
 */
public class Main {

    static Parser p = new Parser();
    final int NAO_FOI_ENCONTRADO_BURACO = -1;

    public static void main(String[] args) {

        for(int j = 0; j < p.getRows(); j++){

        }


        System.out.println(p.getMap()[1][1]);
        System.out.println(p.getFreeSpace());
    }


    public int chooseRow() {
        //escolher menores buracos
        int minimun = Integer.MAX_VALUE;
        Vector<Integer> indexHoleMinimun = new Vector<Integer>();

        for (int i = 0; i < p.getFreeSpace().size(); i++) {
            for (int j = 0; i < p.getFreeSpace().get(i).size(); j++) {
                int elem = p.getFreeSpace().get(i).get(j);
                if (elem > 0 && elem <= minimun) {
                    if (elem == minimun) {
                        if (indexHoleMinimun.indexOf(i) == -1) {
                            indexHoleMinimun.add(i);
                        }
                    } else {
                        minimun = elem;
                        indexHoleMinimun = new Vector<Integer>();
                        indexHoleMinimun.add(i);
                    }
                }
            }
        }

        if (minimun == Integer.MAX_VALUE) {
            return NAO_FOI_ENCONTRADO_BURACO;
        }

        if (indexHoleMinimun.size() == 1) {
            return indexHoleMinimun.get(0);
        }

        //escolher menores capacidades
        minimun = Integer.MAX_VALUE;
        Vector<Integer> indexCapacityMinimun = new Vector<Integer>();

        for (int i= 0; i < indexHoleMinimun.size(); i++) {
            int tempCapacity = 0;
            for (int j = 0; j < p.getSlots(); j++) {
                if (p.getMap()[indexHoleMinimun.get(i)][j] != -2 && p.getMap()[indexHoleMinimun.get(i)][j] != -1) {
                    tempCapacity += p.getServers().get(p.getMap()[indexHoleMinimun.get(i)][j]).getCapacity();
                }
            }

            if (tempCapacity <= minimun) {
                if (tempCapacity == minimun) {
                    if (indexCapacityMinimun.indexOf(i) == -1) {
                        indexCapacityMinimun.add(i);
                    }
                } else {
                    minimun = tempCapacity;
                    indexCapacityMinimun = new Vector<Integer>();
                    indexCapacityMinimun.add(i);
                }
            }
        }

        if (indexCapacityMinimun.size() == 1) {
            return indexCapacityMinimun.get(0);
        }

        //numero de servers diferentes menor
        minimun = Integer.MAX_VALUE;
        int indexServersMinimun = -1;

        int nrServers = 0;
        int server = -666;

        for (int i = 0; i < indexCapacityMinimun.size(); i++) {
            nrServers = 0;
            server = -666;
            for (int j = 0; j < p.getSlots(); j++) {
                if (p.getMap()[indexCapacityMinimun.get(i)][j] != -2 && p.getMap()[indexCapacityMinimun.get(i)][j] != -1) {
                    if (server != p.getMap()[indexCapacityMinimun.get(i)][j]) {
                        server = p.getMap()[indexCapacityMinimun.get(i)][j];
                        nrServers++;
                    }
                }
            }

            if (nrServers < minimun) {
                minimun = nrServers;
                indexServersMinimun = i;
            }
        }

        return indexServersMinimun;

    }

    public int chooseServer() {

    }
}
