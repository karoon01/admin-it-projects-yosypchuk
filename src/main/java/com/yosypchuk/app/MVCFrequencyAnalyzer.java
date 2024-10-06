package com.yosypchuk.app;

public class MVCFrequencyAnalyzer {
    public static void main(String[] args) {
        FrequencyAnalyzerView theView = new FrequencyAnalyzerView();
        FrequencyAnalyzerModel theModel = new FrequencyAnalyzerModel();
        new FrequencyAnalyzerController(theView, theModel);

        theView.setVisible(true);
    }
}
