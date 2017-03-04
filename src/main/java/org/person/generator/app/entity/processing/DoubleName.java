package org.person.generator.app.entity.processing;

/**
 * Created by mac on 24.02.17.
 */


public class DoubleName {
     /** Truncate a double name
     * For example: "Danil i Daniil" -> "Danil"
     * */
    public String nameProcess(String fname) {
        String firstPartName;
        if(fname.contains(" ")) {
            fname = fname.trim();
            int spaceIndex = fname.indexOf(" ");
            firstPartName = fname.substring(0, spaceIndex);
        }
        else {
            firstPartName = fname;
        }
        return firstPartName;
    }
}
