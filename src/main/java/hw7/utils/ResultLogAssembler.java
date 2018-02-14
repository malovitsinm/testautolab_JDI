package hw7.utils;

import hw7.entities.MetalAndColorContent;

import java.util.Arrays;
import java.util.List;

public class ResultLogAssembler {
    public static List<String> assembleMetalsAndColorsResult(MetalAndColorContent entity) {
        return Arrays.asList(
                Integer.toString(entity.getNumbers().x + entity.getNumbers().y),
                entity.getNatureElements().toString().replaceAll("\\[|\\]", ""),
                entity.getColor(),
                entity.getMetal(),
                entity.getVegetables().toString().replaceAll("\\[|\\]", "")
        );
    }
}
