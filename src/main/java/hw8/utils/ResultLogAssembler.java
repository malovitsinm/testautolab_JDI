package hw8.utils;

import hw8.entities.MetalsAndColorsContent;

import java.util.Arrays;
import java.util.List;

import static hw8.enums.MetalsAndColorsDefaultValues.*;

public class ResultLogAssembler {
    public static List<String> assembleMetalsAndColorsResult(MetalsAndColorsContent entity) {
        return Arrays.asList(
                entity.getSummary().isEmpty() ?
                        SUMMARY.value :
                        Integer.toString(entity.getSummary().get(0) + entity.getSummary().get(1)),
                entity.getElements().isEmpty() ?
                        ELEMENTS.value :
                        entity.getElements().toString().replaceAll("\\[|\\]", ""),
                entity.getColor().isEmpty() ?
                        COLOR.value :
                        entity.getColor(),
                entity.getMetals().isEmpty() ?
                        METAL.value :
                        entity.getMetals(),
                entity.getVegetables().isEmpty() ?
                        VEGETABLES.value :
                        entity.getVegetables().toString().replaceAll("\\[|\\]", "")
        );
    }
}
