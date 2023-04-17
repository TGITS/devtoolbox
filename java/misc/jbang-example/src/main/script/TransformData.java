//JAVA 17+
//DEPS com.google.code.gson:gson:2.10.1

/**
 * A exécuter avec JBang : jbang TransformData.java
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class TransformData {
    public static void main(String[] args) {
        Type listOfHousesObject = new TypeToken<ArrayList<House>>() {}.getType();

        try {
            FileReader reader = new FileReader("./input/westeros_houses.json");
            Gson gson = new Gson();

            final List<House> houses = gson.fromJson(reader, listOfHousesObject);

            final String content = houses.stream().map(house -> house.name() + "," + house.ancestralSeat() + "," + house.familyWords()).collect(Collectors.joining("\n"));
            final FileWriter fw = new FileWriter("./output/westeros_houses.csv", StandardCharsets.UTF_8);
            final PrintWriter writer = new PrintWriter(fw);
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

record House(String name, String mainSeat, String ancestralSeat, String sigil, String familyWords, String region) {
}

