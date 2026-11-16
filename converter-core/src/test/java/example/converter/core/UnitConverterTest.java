package example.converter.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnitConverterTest {
    @Test
    void convertsCelsiusToFahrenheit() {
        assertEquals(77.0, UnitConverter.celsiusToFahrenheit(25.0), 0.000001);
    }

    @Test
    void convertsFahrenheitToCelsius() {
        assertEquals(0.0, UnitConverter.fahrenheitToCelsius(32.0), 0.000001);
    }

    @Test
    void convertsKilometersToMiles() {
        assertEquals(6.21371, UnitConverter.kilometersToMiles(10.0), 0.000001);
    }

    @Test
    void convertsMilesToKilometers() {
        assertEquals(10.0, UnitConverter.milesToKilometers(6.21371), 0.000001);
    }
}
