package org.person.generator.app.entity.processing;

/**
 * Created by mac on 23.02.17.
 */
public class Transliteration {
        private final String[] charTable = new String[65536];
        {
            charTable['А'] = "A";  charTable['К'] = "K";  charTable['Х'] = "H";
            charTable['Б'] = "B";  charTable['Л'] = "L";  charTable['Ц'] = "C";
            charTable['В'] = "V";  charTable['М'] = "M";  charTable['Ч'] = "CH";
            charTable['Г'] = "G";  charTable['Н'] = "N";  charTable['Ш'] = "SH";
            charTable['Д'] = "D";  charTable['О'] = "O";  charTable['Щ'] = "SH";
            charTable['Е'] = "E";  charTable['П'] = "P";  charTable['Ъ'] = "'";
            charTable['Ё'] = "E";  charTable['Р'] = "R";  charTable['Ы'] = "Y";
            charTable['Ж'] = "ZH"; charTable['С'] = "S";  charTable['Ь'] = "'";
            charTable['З'] = "Z";  charTable['Т'] = "T";  charTable['Э'] = "E";
            charTable['И'] = "I";  charTable['У'] = "U";  charTable['Ю'] = "U";
            charTable['Й'] = "I";  charTable['Ф'] = "F";  charTable['Я'] = "YA";

            for (int i = 0; i < charTable.length; i++) {
                char idx = (char) i;
                char lower = new String(new char[] {idx}).toLowerCase().charAt(0);
                if (charTable[i] != null) {
                    charTable[lower] = charTable[i].toLowerCase();
                }
            }
        }

        public String translit(String text) {
            char charBuffer[] = text.toCharArray();
            StringBuffer sb = new StringBuffer(text.length());
            for (char symbolBuffer : charBuffer) {
                String replace = charTable[symbolBuffer];
                if (replace == null) {
                    sb.append(symbolBuffer);
                } else {
                    sb.append(replace);
                }
            }
            return sb.toString();
        }
    }
