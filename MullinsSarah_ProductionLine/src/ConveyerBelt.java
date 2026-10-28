/*
 * Name: Sarah Mullins
 * Programming Assignment: Production Line
 */

public class ConveyerBelt {
    private Widget[] belt;
    private int count;

    public ConveyerBelt() {
        belt = new Widget[3];
        count = 0;
    }
    public synchronized void put(Widget widget, String workerName)
        throws InterruptedException {

    while (count == 3) {
        System.out.println("WARNING: Worker " + workerName +
                " is waiting to put " + widget + " on conveyer.");
        wait();
    }
    belt[count++] = widget;
    notifyAll();
    }

    public synchronized Widget take(String workerName) throws InterruptedException {
        while (count == 0) {
            System.out.println("WARNING: Worker " + workerName + " is idle!");
            wait();
        }
        Widget widget = belt[0];

        for (int i = 0; i < count - 1; i++) {
            belt[i] = belt[i + 1];
        }
        belt[count - 1] = null;
        count--;
        notifyAll();
        return widget;
    }
}
