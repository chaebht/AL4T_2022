package be.ecam.basics.exercises;

public class SensorWindow {
    public static int average(int[] values) {
        if (values == null || values.length == 0) throw new IllegalArgumentException("values");
        long sum = 0; // utiliser long pour éviter l'overflow
        for (int v : values) {
            sum += v;
        }
        return (int)(sum / values.length); // division entière, puis cast en int
    }
}
