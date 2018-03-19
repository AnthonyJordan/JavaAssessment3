package user_management;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import parsing_json.Element;
import parsing_json.ElementCollection;

import java.io.FileReader;
import java.io.IOException;

public class UserCollectionInitializer {
    public static UserCollection generate() throws IOException{
        Gson parser = new Gson();
        JsonReader reader;
        UserCollection collection = new UserCollection();
        reader = new JsonReader(new FileReader("/Users/anthonyjordan/Dev/JavaAssessment3/src/main/resources/users.json"));
        User[] users = parser.fromJson(reader, User[].class);

        for (User user: users) {
            collection.add(user);
        }
        return collection;
    }
}
