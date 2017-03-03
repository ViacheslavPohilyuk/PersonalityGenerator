package org.person.generator.app;

import org.person.generator.app.entity.Personality;
import org.person.generator.app.json.JsonConvert;
import org.person.generator.app.sql.DBConnection;
import org.person.generator.app.sql.PersonUpdate;

import java.sql.Connection;
import java.util.Scanner;

/**
 * Created by mac on 24.02.17.
 */
public class App {
    private JsonConvert jsonEntity;
    private DBConnection dbc;

    public App () {
        jsonEntity = new JsonConvert();
        dbc = new DBConnection();
    }

    public void entry() {
        int personCount = 0;
        boolean entry = false;
        while (!entry) {
            try {
                System.out.println("Enter the count of personalities that you want generated: ");

                Scanner sc = new Scanner(System.in);
                personCount = Integer.parseInt(sc.next());
                entry = true;
            } catch (NumberFormatException e) {
                System.err.println("Only the integer numbers accepted!");
            }
        }
        System.out.println("Accepted!\nGenerating...");
        generating(personCount);
    }

    private void generating (int accCount)  {
        int k = 1;
        Personality person;
        Connection connection = dbc.getConnection();

        for(int i = 1; i <= accCount; i++) {
            person = jsonEntity.personality();
            PersonUpdate pu = new PersonUpdate(connection, person);
            pu.doUpdate();

            if( (i != 0) & ((i % (accCount / 5)) == 0) ) {
                System.out.println("(" + k + "/5)");
                k++;
            }
        }
        System.out.println("Ready!");
    }
}
