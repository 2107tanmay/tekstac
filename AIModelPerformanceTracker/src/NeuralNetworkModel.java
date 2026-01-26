import java.lang.reflect.Method;

public class NeuralNetworkModel extends AIModel {
    private int hiddenLayers;
    private String optimizer;
    private boolean gpuEnabled;

   //Include a nine argument constructor
    
    public NeuralNetworkModel(String modelId, String modelName, String modelType,String developer, double baseAccuracy, int trainingHours,int hiddenLayers, String optimizer, boolean gpuEnabled) {
super(modelId, modelName, modelType, developer, baseAccuracy, trainingHours);
this.hiddenLayers = hiddenLayers;
this.optimizer = optimizer;
this.gpuEnabled = gpuEnabled;
}
    
   //Fill the code here

    public int getHiddenLayers() {
		return hiddenLayers;
	}
	public void setHiddenLayers(int hiddenLayers) {
		this.hiddenLayers = hiddenLayers;
	}
	public String getOptimizer() {
		return optimizer;
	}
	public void setOptimizer(String optimizer) {
		this.optimizer = optimizer;
	}
	public boolean getGpuEnabled() {
		return gpuEnabled;
	}
	public void setGpuEnabled(boolean gpuEnabled) {
		this.gpuEnabled = gpuEnabled;
	}

    public double calculateModelEfficiency() {
        //Fill the code here
        double efficiency=baseAccuracy;
        
        efficiency = efficiency + hiddenLayers*0.5;
        
        if(gpuEnabled) efficiency +=5;
        
        if(optimizer.equals("ADAM")) efficiency +=4;
        else if(optimizer.equals("RMSPROP")) efficiency += 3;
        else efficiency +=2;
        
        if(efficiency>100) efficiency =100;
        
        return efficiency;
    }

    public double estimateDeploymentCost() {
        //Fill the code here
        
        double cost = 2000 + (hiddenLayers * 300);
        
        if(gpuEnabled) cost += 2500;
        
        if(baseAccuracy>90) cost += 1000;
        
        return cost;
    }
	
}
