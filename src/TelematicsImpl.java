import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by gilpratte on 4/10/17.
 */
public class TelematicsImpl implements Telematics {

    private ObjectMapper mapper =  new ObjectMapper();
    private VehicleInfo[] vehicles = new VehicleInfo[10];

    @Override
    public void report(VehicleInfo vehicleInfo) {
        System.out.println("vehicle " + vehicleInfo.getVin() + " reporting");

        try (PrintWriter pw = new PrintWriter(new FileWriter(vehicleInfo.getVin() + ".json"))) {
            String json = mapper.writeValueAsString(vehicleInfo);
            pw.println(json);
            pw.flush();
        } catch (IOException e) {
            System.out.println("Could not write " + vehicleInfo.getVin() + " file");
        }

        int count = 0;
        double odometerTotal = 0.0;
        StringBuilder rows = new StringBuilder();
        File file = new File(".");
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".json")) {
                try (BufferedReader bf = new BufferedReader(new FileReader(f.getName()))) {
                    String json = bf.readLine();
                    VehicleInfo vi = mapper.readValue(json, VehicleInfo.class);
                    vehicles[count] = vi;
                    ++count;
                    odometerTotal += vi.getOdometer();

                    StringBuilder row = new StringBuilder("<tr><td align=\"center\">");
                    row.append(vi.getVin());
                    row.append(Telematics.HTML_MIDDLE);
                    row.append(vi.getOdometer());
                    row.append(Telematics.HTML_MIDDLE);
                    row.append(vi.getConsumption());
                    row.append(Telematics.HTML_MIDDLE);
                    row.append(vi.getOdometerLastOilChange());
                    row.append(Telematics.HTML_MIDDLE);
                    row.append(vi.getEngineSize());
                    row.append("</td></tr>");

                    rows.append(row.toString());

                } catch (IOException e) {
                    System.out.println("had trouble reading " + f.getName());
                }
            }
        }

        System.out.println("the array is " + Arrays.toString(vehicles));

        String top = Telematics.HTML_TOP.replace("num_vehicles", "" + count);

        double odoAverage = odometerTotal / count;
        String odoAsDecimal = String.format("%.2f", odoAverage);

        top = top.replace("average_odometer", "" + odoAsDecimal);
        // ...

        StringBuilder htmlPage = new StringBuilder();
        htmlPage.append(top);
        htmlPage.append(rows);
        htmlPage.append(Telematics.HTML_BOTTOM);

        try (PrintWriter pw = new PrintWriter(new FileWriter("dashboard.html"))) {
            pw.println(htmlPage);
            pw.flush();
        } catch (IOException e) {
            System.out.println("problem writing the html page");
        }
    }

}
