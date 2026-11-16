package example.converter.core;

/** Simple conversions with no external dependencies. */
public final class UnitConverter {
    private static final double MILES_PER_KILOMETER = 0.621371;

    private UnitConverter() {
        // Utility class
    }

    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 9.0 / 5.0 + 32.0;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }

    public static double kilometersToMiles(double kilometers) {
        return kilometers * MILES_PER_KILOMETER;
    }

    public static double milesToKilometers(double miles) {
        return miles / MILES_PER_KILOMETER;
    }
}
