package example.converter.cli;

import example.converter.core.UnitConverter;

/** CLI module that uses the converter-core module. */
public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
            return;
        }

        double value;
        try {
            value = Double.parseDouble(args[1]);
        } catch (NumberFormatException exception) {
            System.err.println("Invalid number: " + args[1]);
            printUsage();
            return;
        }

        double result;
        String unit;
        switch (args[0]) {
            case "c-to-f":
                result = UnitConverter.celsiusToFahrenheit(value);
                unit = "°F";
                break;
            case "f-to-c":
                result = UnitConverter.fahrenheitToCelsius(value);
                unit = "°C";
                break;
            case "km-to-mi":
                result = UnitConverter.kilometersToMiles(value);
                unit = "mi";
                break;
            case "mi-to-km":
                result = UnitConverter.milesToKilometers(value);
                unit = "km";
                break;
            default:
                System.err.println("Unknown conversion: " + args[0]);
                printUsage();
                return;
        }

        System.out.printf("%.2f %s%n", result, unit);
    }

    private static void printUsage() {
        System.out.println("Usage: <conversion> <number>");
        System.out.println("Conversions: c-to-f, f-to-c, km-to-mi, mi-to-km");
        System.out.println("Example: c-to-f 25");
    }
}
