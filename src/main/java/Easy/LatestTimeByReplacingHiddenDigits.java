package Easy;

class LatestTimeByReplacingHiddenDigits {
    public String maximumTime(String time) {
        char[] t = time.toCharArray();

        if (t[0] == '?') {
            t[0] = (t[1] == '?' || t[1] <= '3') ? '2' : '1';
        }

        if (t[1] == '?') {
            t[1] = (t[0] == '2') ? '3' : '9';
        }

        if (t[3] == '?') {
            t[3] = '5';
        }

        if (t[4] == '?') {
            t[4] = '9';
        }

        return new String(t);
    }
}

class TestLatestTimeByReplacingHiddenDigits {
    static void main(String[] args) {
        LatestTimeByReplacingHiddenDigits test = new LatestTimeByReplacingHiddenDigits();

        String[] cases = {
                "2?:?0", "0?:3?", "1?:22"
        };

        for (var c : cases) {
            var result = test.maximumTime(c);
            System.out.println(result);
        }
    }
}
