import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Media {
    static void main(String[] args) throws IOException {
        var basePath = Path.of("src/main/java");

        var easy = countExercises(basePath.resolve("Easy"));
        var medium = countExercises(basePath.resolve("Medium"));
        var hard = countExercises(basePath.resolve("Hard"));

        var total = easy + medium + hard;

        System.out.printf("%n");
        printDif("Easy", easy, total);
        printDif("Medium", medium, total);
        printDif("Hard", hard, total);

        System.out.printf("%nTotal: %d exercícios%n", total);
    }

    private static long countExercises(Path directory) throws IOException {
        try (var files = Files.walk(directory)) {
            return files.filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".java"))
                    .count();
        }
    }

    private static void printDif(String dif, long count, long total) {
        var percentage = total == 0 ? 0.0 : (double) count / total * 100;

        System.out.printf(
                "%-8s | %5d | %6.2f%%%n",
                dif, count, percentage
        );
    }
}
