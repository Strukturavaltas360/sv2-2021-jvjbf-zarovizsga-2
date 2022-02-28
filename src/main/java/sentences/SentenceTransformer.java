package sentences;

public class SentenceTransformer {

    public String shortenSentence(String sentence) {
        validateSentence(sentence);
        String[] words = sentence.split(" ");
        if (words.length < 5) {
            return sentence;
        } else {
            return words[0] + " ... " + words[words.length - 1];
        }
    }

    private void validateSentence(String sentence) {
        if (sentence == null || sentence.isBlank()) {
            throw new IllegalArgumentException("Empty sentence!");
        }
        if (!Character.isUpperCase(sentence.charAt(0))) {
            throw new IllegalArgumentException("Must start with capital letter!");
        }
        char lastChar = sentence.charAt(sentence.length() - 1);
        if (".!?".indexOf(lastChar) < 0) {
            throw new IllegalArgumentException("Must end with . ! or ?");
        }
    }
}
