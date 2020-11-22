package company.lesson3;

import java.util.Map;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {

        String[] words = {"кошка", "собака", "лев", "носорог", "енот", "лось", "кошка", "собака", "лев",
                "носорог", "енот", "лось", "кошка", "собака", "лев", "носорог", "енот", "лось", "кошка", "собака", "лев"};

        Map<String, Integer> wordsMap = new TreeMap<>();
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        System.out.println(wordsMap);
        System.out.println();

        TelephoneDirectory td = new TelephoneDirectory();
        td.add("Ivanov", "11111");
        td.add("Zuzin", "22222");
        td.add("Petrov", "333333");
        td.add("Ponchik", "444444");
        td.add("Ponchik", "4545454");
        td.add("Ponchik", "4465658");
        td.add("Kudasov", "55555");
        td.add("Sidorov", "66666");
        td.add("Ivanov", "77777");

        td.get("Ivanov");
        td.get("Fukov");
        td.add("Lukich", "151515");
        td.add("Lukich", "181818");
        td.get("Lukich");

        td.printDirectory();

    }
}
