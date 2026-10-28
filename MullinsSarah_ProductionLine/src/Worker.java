/*
 * Name: Sarah Mullins
 * Programming Assignment: Production Line
 */


public class Worker implements Runnable {
    private String name;
    private ConveyerBelt inputBelt;
    private ConveyerBelt outputBelt;

    public Worker(String name, ConveyerBelt inputBelt, ConveyerBelt output) {
        this.name = name;
        this.inputBelt = inputBelt;
        this.outputBelt = output;
    }

    @Override
    public void run() {
        try{
            //Worker A creates all 24 widgets
            if (name.equals("A")) {
                for (int i = 1; i <=24; i++) {
                    //Create new widget
                    Widget widget = new Widget(i);

                    //Worker A handles widget
                    widget.workUpon();

                    System.out.println("Worker A is working on " +widget);

                    //Random amount of time for worker A to work
                    Thread.sleep((long) (Math.random() * 1000));
                    System.out.println("Worker A is placing " + widget + " on the belt");

                    //Put widget onto the A-B belt
                    outputBelt.put(widget, name);
                }
                //Workers B and C take widgets from belt
                //place on next belt
            } else if (name.equals("B") || name.equals("C")) {
                for (int i = 1; i <=24; i++) {
                    //Take widget from incoming belt
                    Widget widget = inputBelt.take(name);

                    System.out.println("Worker " + name + " is retrieving "  +
                            widget + " from the belt");

                    //Handles widget
                    widget.workUpon();

                    System.out.println("Worker " + name + " is working on " +widget);

                    //Random work time
                    Thread.sleep((long) (Math.random() * 1000));

                    System.out.println("Worker " + name + " is placing " + widget + " on the belt");
                    //Put widget on next belt
                    outputBelt.put(widget, name);
                }
                //Worker D final worker
            } else if (name.equals("D")) {
                for (int i = 1; i <=24; i++) {
                    //Take widget from C-D
                    Widget widget = inputBelt.take(name);
                    System.out.println("Worker D is retrieving " + widget + " from the belt");
                    widget.workUpon();
                    System.out.println("Worker D is working on " +widget);
                    Thread.sleep((long) (Math.random() * 1000));
                }
            }
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

}
