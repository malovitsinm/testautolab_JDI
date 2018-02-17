package hw8.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MetalsAndColorsDefaultValues {
    SUMMARY("3"),
    METAL("Col"),
    COLOR("Colors"),
    ELEMENTS(null),
    VEGETABLES("Salad");

    private final String value;

    @Override
    public String toString() {
        return this.value;
    }
}
