public class TrafficLightSimulator implements Runnable {
    private Thread thrd;
    private TrafficLightColour tlc;
    boolean stop = false;
    boolean changed = false;

    TrafficLightSimulator (TrafficLightColour init) {
        tlc = init;

        thrd = new Thread(this);
        thrd.start();
    }

    public void run () {
        while (!stop) {
            try {
                Thread.sleep(tlc.getDelay());
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
            changeColour();
        }
    }

    synchronized void changeColour() {
        switch (tlc) {
            case RED:
                tlc = TrafficLightColour.GREEN;
                break;
            case YELLOW:
                tlc = TrafficLightColour.RED;
                break;
            case GREEN:
                tlc = TrafficLightColour.YELLOW;
        }
        changed = true;
        notify();
    }

    synchronized void waitForChange() {
        try {
            while (!changed) wait();
            changed = false;
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }

    TrafficLightColour getColour() {
        return tlc;
    }

    void cancel() {
        stop = true;
    }
}
