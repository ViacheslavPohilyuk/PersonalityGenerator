package org.person.generator.app.json;

import org.person.generator.app.entity.Personality;

/**
 * Created by mac on 28.01.17.
 */
public interface IJson {
    /** Converting json-string to a java object Personality */
    Personality jsonReadPersonality() throws Exception;

}
