import java.util.*;
import java.util.stream.Collectors;

public class TrainingJobService {
    private List<TrainingJob> jobList = new ArrayList<>();
    
    public List<TrainingJob> getJobList() {
        return jobList;
    }

    public void setJobList(List<TrainingJob> jobList) {
        this.jobList = jobList;
    }

    public void addTrainingJob(TrainingJob job) {
        // Fill the code here 
    	jobList.add(job);
    }

    public TrainingJob getTrainingJobById(String jobId) {
        // Fill the code here 
        
//        return jobList.stream().filter(obj -> obj.getJobId().equals(jobId)).findFirst().orElse(null);
    	for(TrainingJob t: jobList) {
    		if(t.getJobId().equals(jobId)) {
    			return t;
    		}
    	}
    	return null;
    }

   
    public Set<TrainingJob> getJobsWithHighestTrainingCost() {
    	//first we calculate the max cost from all the jobs
    	double max = jobList.stream().mapToDouble(TrainingJob::getTrainingCost).max().orElse(0);
        return jobList.stream().filter(job-> job.getTrainingCost()==max).collect(Collectors.toSet());
        //then we return the job by comparing others to it
    }

   public Map<String, Double> getComputeHoursByRegion() {

        
        return jobList.stream().collect(Collectors.groupingBy(
        		TrainingJob::getRegion,
        		Collectors.summingDouble(TrainingJob::getComputeHours)
        		));
   }

    public Map<String, List<TrainingJob>> groupJobsByModelType() {
        Map<String, List<TrainingJob>> map = new LinkedHashMap<>();
        // Fill the code here        
        return jobList.stream().collect(Collectors.groupingBy(TrainingJob::getModelType));
    }

    
    public boolean updateComputeHours(String jobId, double additionalHours) {
        // Fill the code here 
    	for(TrainingJob obj: jobList) {
    		if(jobId.equals(obj.getJobId())) {
    			double updatedhours = obj.getComputeHours()+additionalHours;
    			obj.setComputeHours(updatedhours);
    			return true;
    		}
    	}
        return false;
    }
    //47

    
    public List<TrainingJob> filterJobs(String region, String status) {
        List<TrainingJob> result = new ArrayList<>();
        // Fill the code here 
        return jobList.stream().filter(obj-> obj.getRegion().equals(region) && obj.getStatus().equals(status)).toList();
        
    }
//59
    
    public Map<String, List<TrainingJob>> getTopCostlyJobsByRegion(int n) {
        Map<String, List<TrainingJob>> grouped = new HashMap<>();
       // Fill the code here 
       for(TrainingJob obj: jobList) {
    	   String region = obj.getRegion();
    	   grouped.putIfAbsent(region, new ArrayList<>());
    	   grouped.get(region).add(obj);
       }
       //the above method will make the map for us with regions and put all the jobs in the list
       
       for(String region: grouped.keySet()) {
    	   
    	   List<TrainingJob> list = grouped.get(region);
    	   list.sort(Comparator.comparingDouble(TrainingJob::getTrainingCost).reversed());
    	   //REMEMBER CODE FOR SORTING IN DESC ORDER
           
           if(list.size()>n) {
        	   grouped.put(region, list.subList(0, n));
        	   //only put the amount of elements we are asked 
           }
       }

       
        return grouped;
    }
    //65
    
    public Map<String, Integer> getStatusStats() {
        Map<String, Integer> result = new HashMap<>();
        // Fill the code here 
        for(TrainingJob obj: jobList) {
        	String status = obj.getStatus();
        	
        	if(!result.containsKey(status)) {
        		result.put(status, 0); //to initiate the or add this status to our map
        	}
        	
        	result.put(status, result.get(status)+1); 
        	//the above mentioned code will put current status object name as well as it will search for the object value and add one to it
        	//then put it in the map
        }
        return result;
    }
//71
    
    public double calculateTotalTrainingCost() {
        double total = 0;
        // Fill the code here 
        
        for(TrainingJob obj: jobList) {
        	
        	if(obj.getStatus().equals("COMPLETED")) {
        		double base = obj.getComputeHours()*obj.getTrainingCost();
        		double cost = 0;
        		if(obj.getModelType().equals("LLM")) {
        			cost = base+1000;
        		}
        		else if(obj.getModelType().equals("Vision")) {
        			cost = base+800;
        		}
        		else if(obj.getModelType().equals("Speech")) {
        			cost = base+600;
        		}
        		else {
        			cost = base+400;
        		}
        		total += cost;
        	}
        	
        }
        
        return total;
    }
    //83
}
