package org.person.generator.app.entity.processing;

/**
 * Created by mac on 24.02.17.
 */
public class DoubleName {
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
