package parsing_json;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.IOException;



public class ElementCollectionInitializer {
    public static ElementCollection generate() throws IOException{
        Gson parser = new Gson();
        JsonReader reader;
        ElementCollection collection = new ElementCollection();
        reader = new JsonReader(new FileReader("/Users/anthonyjordan/Dev/JavaAssessment3/src/main/resources/periodic_table.json"));
        //Element[] elements = parser.fromJson(reader, Element[].class);

        collection = parser.fromJson(reader, ElementCollection.class);
//        for (Element element: elements) {
//            collection.add(element);
//        }
        return collection;
    }
}
