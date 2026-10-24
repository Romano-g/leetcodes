public class OddStringDifference {
    public String oddString(String[] words) {
        String[] differences = new String[3];

        for (int i = 0; i < 3; i++) {
            String diff = "";

            for (int j = 0; j < words[i].length() - 1; j++) {
                diff += (words[i].charAt(j + 1) - words[i].charAt(j)) + ",";
            }

            differences[i] = diff;
        }

        if (differences[0].equals(differences[1])
                && !differences[0].equals(differences[2])) {
            return words[2];
        }

        if (differences[0].equals(differences[2])
                && !differences[0].equals(differences[1])) {
            return words[1];
        }

        if (differences[1].equals(differences[2])
                && !differences[1].equals(differences[0])) {
            return words[0];
        }

        for (int i = 3; i < words.length; i++) {
            String diff = "";

            for (int j = 0; j < words[i].length() - 1; j++) {
                diff += (words[i].charAt(j + 1) - words[i].charAt(j)) + ",";
            }

            if (!diff.equals(differences[0])) {
                return words[i];
            }
        }

        return "";
    }
}


class TestOddStringDifference {
    static void main(String[] args) {
        OddStringDifference test = new OddStringDifference();

        String[][] cases = {
                {"adc","wzy","abc"},
                {"aaa","bob","ccc","ddd"}
        };

        for (var c : cases) {
            var result = test.oddString(c);
            System.out.println(result);
        }
    }
}