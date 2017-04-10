public class Main {

    public static void main(String[] args) {

        Telematics telematics = new TelematicsImpl();

        VehicleInfo vi = new VehicleInfo();
        vi.setVin("1234");
        vi.setOdometer(2334.45);
        vi.setConsumption(4354.4566);
        vi.setEngineSize(2.5);
        vi.setOdometerLastOilChange(0.0);
        telematics.report(vi);

        vi = new VehicleInfo();
        vi.setVin("2345");
        vi.setOdometer(12334.45);
        vi.setConsumption(34354.4566);
        vi.setEngineSize(4.0);
        vi.setOdometerLastOilChange(10_001.55);
        telematics.report(vi);

    }
}
