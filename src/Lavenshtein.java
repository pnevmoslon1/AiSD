public class Lavenshtein {
    public static int countOfOperations(String str1, String str2) {
        int[][] d = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i < str1.length() + 1; i++) {
            d[i][0] = i;
        }
        for (int i = 0; i < str2.length() + 1; i++) {
            d[0][i] = i;
        }

        str1 = " " + str1;
        str2 = " " + str2;
        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) d[i][j] = Math.min(Math.min(d[i - 1][j - 1], d[i][j - 1] + 1), d[i - 1][j] + 1);
                else d[i][j] = Math.min(Math.min(d[i - 1][j - 1] + 1, d[i][j - 1] + 1), d[i - 1][j] + 1);

            }
        }

        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                System.out.print(d[i][j] + "  ");
            }
            System.out.println();
        }

        int res = d[str1.length() - 1][str2.length() - 1];
        return res;
    }


}

