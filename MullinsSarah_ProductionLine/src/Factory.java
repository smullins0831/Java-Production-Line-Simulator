/*
 * Name: Sarah Mullins
 * Programming Assignment: Production Line
 */

public class Factory {
    public static void main(String[] args) {
        //Creates three conveyer belts
        ConveyerBelt beltAB = new ConveyerBelt();
        ConveyerBelt beltBC = new ConveyerBelt();
        ConveyerBelt beltCD = new ConveyerBelt();

        //Creates four workers
        Worker workerA = new Worker("A", null, beltAB);
        Worker workerB = new Worker("B", beltAB, beltBC);
        Worker workerC = new Worker("C", beltBC, beltCD);
        Worker workerD = new Worker("D", beltCD, null);

        //Creates thread for each worker
        Thread threadA = new Thread(workerA);
        Thread threadB = new Thread(workerB);
        Thread threadC = new Thread(workerC);
        Thread threadD = new Thread(workerD);

        //Starts workers
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        //Waits for workers to finish
        try {
            threadA.join();
            threadB.join();
            threadC.join();
            threadD.join();
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("All 24 widgets have been completed!");
    }
}
