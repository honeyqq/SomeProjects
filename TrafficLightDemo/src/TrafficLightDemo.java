public class TrafficLightDemo {
    public static void main(String[] args) {
        TrafficLightSimulator t1 = new TrafficLightSimulator(TrafficLightColour.GREEN);

        for (int i = 0; i < 9; i++) {
            System.out.println(t1.getCOlour());
            t1.waitForChange();
        }

        t1.cancel();
    }
}
