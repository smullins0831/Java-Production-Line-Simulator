/*
* Name: Sarah Mullins
* Programming Assignment: Production Line
*/

public class Widget {
    private int widgetNum;
    private int handledCount;

    public Widget(int widgetNum) {
        this.widgetNum = widgetNum;
        handledCount = 0;
    }

    public void workUpon(){
        handledCount++;
    }

    public String toString(){
        String handledBy = "";

        if (handledCount >= 1)
            handledBy += "A";
        if (handledCount >= 2)
            handledBy += ",B";
        if (handledCount >= 3)
            handledBy += ",C";
        if (handledCount >= 4)
            handledBy += ",D";
        return "widget " + widgetNum + " <handled by " + handledBy + ">";
    }
}
