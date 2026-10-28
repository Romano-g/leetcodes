package Medium;

import java.util.Arrays;

public class DestroyingAsteroids {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currentMass = mass;

        for (var asteroid : asteroids) {
            if (asteroid > currentMass) {
                return false;
            }

            currentMass += asteroid;
        }

        return true;
    }
}

class TestDestroyingAsteroids {
    static void main(String[] args) {
        DestroyingAsteroids test = new DestroyingAsteroids();

        int[][][] cases = {
                {new int[]{10}, {3,9,19,5,21}},
                {new int[]{5}, {4,9,23,4}}
        };

        for (var c : cases) {
            var result = test.asteroidsDestroyed(c[0][0], c[1]);
            System.out.println(result);
        }
    }
}