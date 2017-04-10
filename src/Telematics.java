/**
 * Created by gilpratte on 4/10/17.
 */
public interface Telematics {
    void report(VehicleInfo vehicleInfo);

    String HTML_TOP = "<html>\n" +
      "  <title>Vehicle Telematics Dashboard</title>\n" +
      "  <body>\n" +
      "    <h1 align=\"center\">Averages for num_vehicles vehicles</h1>\n" +
      "    <table align=\"center\">\n" +
      "        <tr>\n" +
      "            <th>Odometer (miles) |</th><th>Consumption (gallons) |</th><th>Last Oil Change |</th><th>Engine Size (liters)</th>\n" +
      "        </tr>\n" +
      "        <tr>\n" +
      "            <td align=\"center\">average_odometer</td><td align=\"center\">average_consumption</td><td align=\"center\">average_last_oil_change</td align=\"center\"><td align=\"center\">average_engine_size</td>\n" +
      "        </tr>\n" +
      "    </table>\n" +
      "    <h1 align=\"center\">History</h1>\n" +
      "    <table align=\"center\" border=\"1\">\n" +
      "        <tr>\n" +
      "            <th>VIN</th><th>Odometer (miles)</th><th>Consumption (gallons)</th><th>Last Oil Change</th><th>Engine Size (liters)</th>\n" +
      "        </tr>\n";

    String HTML_MIDDLE = "</td><td align=\"center\">";

    String HTML_BOTTOM = "</table>\n" +
      "  </body>\n" +
      "</html>";
}
