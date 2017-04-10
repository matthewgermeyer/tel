/**
 * Created by gilpratte on 4/10/17.
 */
public class VehicleInfo {
    private String vin;
    private double odometer;
    private double consumption;
    private double odometerLastOilChange;
    private double engineSize;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public double getOdometer() {
        return odometer;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public double getOdometerLastOilChange() {
        return odometerLastOilChange;
    }

    public void setOdometerLastOilChange(double odometerLastOilChange) {
        this.odometerLastOilChange = odometerLastOilChange;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }

    @Override
    public String toString() {
        return "VehicleInfo{" +
          "vin=" + vin +
          ", odometer=" + odometer +
          ", consumption=" + consumption +
          ", odometerLastOilChange=" + odometerLastOilChange +
          ", engineSize=" + engineSize +
          '}';
    }
}
