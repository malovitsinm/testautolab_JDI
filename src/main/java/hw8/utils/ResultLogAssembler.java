package hw8.utils;

import hw8.entities.MetalsAndColorsContent;

import java.util.Arrays;
import java.util.List;

import static hw8.enums.MetalsAndColorsDefaultValues.*;

public class ResultLogAssembler {
    public static List<String> assembleMetalsAndColorsResult(MetalsAndColorsContent entity) {
        return Arrays.asList(
                entity.getSummary().isEmpty() ?
                        SUMMARY.toString() :
                        Integer.toString(entity.getSummary().get(0) + entity.getSummary().get(1)),
                entity.getElements().isEmpty() ?
                        ELEMENTS.toString() :
                        entity.getElements().toString().replaceAll("\\[|\\]", ""),
                entity.getColor().isEmpty() ?
                        COLOR.toString() :
                        entity.getColor(),
                entity.getMetals().isEmpty() ?
                        METAL.toString() :
                        entity.getMetals(),
                entity.getVegetables().isEmpty() ?
                        VEGETABLES.toString() :
                        entity.getVegetables().toString().replaceAll("\\[|\\]", "")
        );
    }
}
