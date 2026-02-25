public class TrainingJobUtil {

    public TrainingJob parseTrainingJob(String input) {
        // Fill the code here 
        String words[] = input.split(":");
        return new TrainingJob(words[0],words[1],words[2],words[3],words[4], Double.parseDouble(words[5]), Double.parseDouble(words[6]), words[7]);
    }
}
