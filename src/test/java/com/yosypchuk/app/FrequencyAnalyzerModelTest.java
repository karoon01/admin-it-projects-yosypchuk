package com.yosypchuk.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;

public class FrequencyAnalyzerModelTest {

    private FrequencyAnalyzerModel model;

    @BeforeEach
    public void setUp() {
        model = new FrequencyAnalyzerModel();
    }

    @Test
    public void testAnalyzeText_singleWord() {
        model.analyzeText("hello");
        Map<String, Integer> wordFrequency = model.getWordFrequency();

        assertEquals(1, wordFrequency.size());
        assertTrue(wordFrequency.containsKey("hello"));
        assertEquals(1, wordFrequency.get("hello"));
    }

    @Test
    public void testAnalyzeText_multipleWords() {
        model.analyzeText("hello world hello");
        Map<String, Integer> wordFrequency = model.getWordFrequency();

        assertEquals(2, wordFrequency.size());
        assertEquals(2, wordFrequency.get("hello"));
        assertEquals(1, wordFrequency.get("world"));
    }

    @Test
    public void testAnalyzeText_emptyInput() {
        model.analyzeText("");
        Map<String, Integer> wordFrequency = model.getWordFrequency();

        assertEquals(0, wordFrequency.size());
    }

    @Test
    public void testAnalyzeText_specialCharacters() {
        model.analyzeText("hello, world! Hello?");
        Map<String, Integer> wordFrequency = model.getWordFrequency();

        assertEquals(2, wordFrequency.size());
        assertEquals(2, wordFrequency.get("hello"));
        assertEquals(1, wordFrequency.get("world"));
    }

    @Test
    public void testGetSortedWordFrequency() {
        model.analyzeText("apple banana apple orange orange orange");
        Map<String, Integer> sortedWordFrequency = model.getWordFrequency();

        String[] expectedOrder = {"orange", "apple", "banana"};
        int index = 0;

        for (Map.Entry<String, Integer> entry : sortedWordFrequency.entrySet()) {
            assertEquals(expectedOrder[index], entry.getKey());
            index++;
        }
    }
}
