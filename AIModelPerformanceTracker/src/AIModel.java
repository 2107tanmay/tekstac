public abstract class AIModel {
    protected String modelId;
    protected String modelName;
    protected String modelType;
    protected String developer;
    protected double baseAccuracy;
    protected int trainingHours;
    
	//Include a six argument constructor
	//Fill the code here
	
	public AIModel(String modelId, String modelName, String modelType, String developer, double baseAccuracy, int trainingHours) {
		this.modelId = modelId;
		this.modelName = modelName;
		this.modelType = modelType;
		this.developer = developer;
		this.baseAccuracy = baseAccuracy;
		this.trainingHours = trainingHours;
	}
    
	public String getModelId() {
		return modelId;
	}
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getModelType() {
		return modelType;
	}
	public void setModelType(String modelType) {
		this.modelType = modelType;
	}
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public double getBaseAccuracy() {
		return baseAccuracy;
	}
	public void setBaseAccuracy(double baseAccuracy) {
		this.baseAccuracy = baseAccuracy;
	}
	public int getTrainingHours() {
		return trainingHours;
	}
	public void setTrainingHours(int trainingHours) {
		this.trainingHours = trainingHours;
	}
    
	 public abstract double calculateModelEfficiency();
	 public abstract double estimateDeploymentCost();
}
