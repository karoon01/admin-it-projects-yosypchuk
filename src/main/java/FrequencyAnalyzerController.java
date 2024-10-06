import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class FrequencyAnalyzerController {

    private FrequencyAnalyzerView theView;
    private FrequencyAnalyzerModel theModel;

    public FrequencyAnalyzerController(FrequencyAnalyzerView theView, FrequencyAnalyzerModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        // Прив'язка кнопки аналізу до дії
        this.theView.addAnalyzeListener(new AnalyzeListener());
    }

    class AnalyzeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String inputText = theView.getInputText();
                if (inputText.isEmpty()) {
                    theView.displayErrorMessage("Text cannot be empty!");
                    return;
                }

                theModel.analyzeText(inputText);
                Map<String, Integer> wordFrequency = theModel.getWordFrequency();


                // Формування результатів для відображення
                StringBuilder result = new StringBuilder();
                for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                    result.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
                }

                theView.setOutputText(result.toString());
            } catch (Exception ex) {
                theView.displayErrorMessage("Error: " + ex.getMessage());
            }
        }
    }
}
