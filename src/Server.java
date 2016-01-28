/**
 * Created by m_bot on 28/01/2016.
 */
public class Server {

    int slots;
    int capacity;
    int poll;
    int row;

    Server(int slots, int capacity) {
        this.slots = slots;
        this.capacity = capacity;
    }

    public int getSlots() {
        return slots;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPoll() {
        return poll;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public void setPoll(int poll) {
        this.poll = poll;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
