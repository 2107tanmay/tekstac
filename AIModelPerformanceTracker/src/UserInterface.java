import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Fill the code here
        System.out.println("Enter AI Model details:");
        String input[] = sc.nextLine().split(":");
        
        NeuralNetworkModel obj = new NeuralNetworkModel(input[0],input[1],input[2],input[3],Double.parseDouble(input[4]), Integer.parseInt(input[5]), Integer.parseInt(input[6]), input[7], Boolean.parseBoolean(input[8]));
        
        System.out.println("Model Details:");
        System.out.println("Model ID - "+obj.getModelId());
        System.out.println("Model Name - "+obj.getModelName());
        System.out.println("Model Type - "+obj.getModelType());
        System.out.println("Developer - "+obj.getDeveloper());
        System.out.println("Base Accuracy - "+obj.getBaseAccuracy());
        System.out.println("Training Hours - "+obj.getTrainingHours());
        System.out.println("Hidden Layers - "+obj.getHiddenLayers());
        System.out.println("Optimizer - "+obj.getOptimizer());
        System.out.println("GPU Enabled - "+obj.getGpuEnabled());
        System.out.println("Calculated Model Efficiency: "+obj.calculateModelEfficiency());
        System.out.println("Estimated Deployment Cost: Rs "+obj.estimateDeploymentCost());
        
        
    }
}
