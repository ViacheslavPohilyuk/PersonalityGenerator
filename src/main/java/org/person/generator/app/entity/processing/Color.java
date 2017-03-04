package org.person.generator.app.entity.processing;

/**
 * Created by mac on 24.02.17.
 */
public class Color {
    private String rusColor;

    public Color(String rusColor) {
        this.rusColor = rusColor;
    }

    /** Translate name of color from russian to english */
    public String colorSwap () {
        String[] russianColors = {"Фиолетовый", "Синий", "Оранжевый",
                                  "Голубой", "Белый", "Красный",
                                  "Жёлтый", "Зелёный", "Чёрный"};

        String[] englishColors = {"Purple", "Blue", "Orange",
                                  "Blue", "White", "Red",
                                  "Yellow", "Green", "Black"};
        int i = 0;
        for (String m : russianColors) {
            if (rusColor.equals(m))
                break;
            i++;
        }
        return englishColors[i];
    }
}
