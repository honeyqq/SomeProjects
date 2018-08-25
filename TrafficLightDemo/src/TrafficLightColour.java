public enum TrafficLightColour {
    RED(12000), GREEN(10000), YELLOW(2000);

    private int delay;

    TrafficLightColour(int d) {
        delay = d;
    }

    int getDelay(){
        return delay;
    }
}
