package hw7.entities;

import hw7.utils.Tuple;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public class MetalAndColorContent {

    static public MetalAndColorContent EXPECTED_METALS_AND_COLORS = new MetalAndColorContent(
            new Tuple<>(3, 8),
            "Red",
            "Selen",
            Arrays.asList("Water", "Fire"),
            Arrays.asList("Cucumber", "Tomato")
    );

    private Tuple<Integer, Integer> numbers;
    private String color;
    private String metal;
    private List<String> natureElements;
    private List<String> vegetables;
}
