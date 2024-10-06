package com.yosypchuk.app;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyAnalyzerModel {

    private Map<String, Integer> wordFrequency = new HashMap<>();

    // Метод для виконання частотного аналізу тексту
    public void analyzeText(String text) {
        wordFrequency.clear();
        String[] words = text.toLowerCase().split("\\W+");
        for (String word : words) {
            if (word.isEmpty()) continue;
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
    }

    public Map<String, Integer> getWordFrequency() {
        return wordFrequency.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }
}
