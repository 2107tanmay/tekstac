public class TrainingJob {

	private String jobId;
	private String modelId;
	private String modelType;
	private String datasetType;
	private String region;
	private double computeHours;
	private double trainingCost;
	private String status;   


	public TrainingJob()
	{

	}

	public TrainingJob(String jobId, String modelId, String modelType,
			String datasetType, String region,
			double computeHours, double trainingCost,
			String status) {
		this.jobId = jobId;
		this.modelId = modelId;
		this.modelType = modelType;
		this.datasetType = datasetType;
		this.region = region;
		this.computeHours = computeHours;
		this.trainingCost = trainingCost;
		this.status = status;
	}

	public String getJobId() {
		return jobId;
	}

	public String getModelId() {
		return modelId;
	}

	public String getModelType() {
		return modelType;
	}

	public String getDatasetType() {
		return datasetType;
	}

	public String getRegion() {
		return region;
	}

	public double getComputeHours() {
		return computeHours;
	}

	public double getTrainingCost() {
		return trainingCost;
	}

	public String getStatus() {
		return status;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

	public void setDatasetType(String datasetType) {
		this.datasetType = datasetType;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setComputeHours(double computeHours) {
		this.computeHours = computeHours;
	}

	public void setTrainingCost(double trainingCost) {
		this.trainingCost = trainingCost;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return jobId + " | " + modelId + " | " + modelType +
				" | " + region + " | " + computeHours +
				" hrs | $" + trainingCost + " | " + status;
	}
}
