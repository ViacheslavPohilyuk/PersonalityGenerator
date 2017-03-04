package org.person.generator.app.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.person.generator.app.entity.Personality;
import org.person.generator.app.web.URLConnectionReader;

import java.io.IOException;

/**
 * Created by stephenvolf on 08/01/17.
 */
public class JsonConvert implements IJson {

    @Override
    public Personality jsonReadPersonality()  {
        URLConnectionReader ucr = new URLConnectionReader();

        Personality person = null;

        String json = ucr.randPersonData();

        try {
            ObjectMapper mapper = new ObjectMapper();
            person = mapper.readValue(json, Personality.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Could not deserialize json");
            System.exit(1);
        }

        return person;
    }
}
