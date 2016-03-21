/**
 * Implementation of a First Fit Alogrithm. A number of jobs are processed
 * if they are smaller or equal to the memory blocks. If the job is biger 
 * then it is sent to a waiting queue!
 * 
 * Author: Haider M. al-Khateeb 
 * Last Changed: 26/02/2011
 */
 
public class FirstFitAlgorithm
{
 
    double [] jobSize;
    double [] memorySize;
 
    // the number of memory blocks
    int blocks;
 
    // the number of jobs
    int jobs;
 
    int theCounter;
    int jobIndex;
    int jobInQueue;
 
public void setJobs(double job1, double job2, double job3, double job4, double job5)
{
    jobSize = new double[5];
     // jobs
    jobSize[0] = job1;  // job 1
    jobSize[1] = job2;  // job 2
    jobSize[2] = job3;  // job 3
    jobSize[3] = job4;  // job 4
    jobSize[4] = job5;  // job 5
    jobs = jobSize.length;
}
 
public void setMemory(double memory1, double memory2, double memory3, double memory4, double memory5)
{
     memorySize = new double[5];
    //available memory blocks
    memorySize[0] = memory1;  // memory block 1
    memorySize[1] = memory2;  // memory block 2
    memorySize[2] = memory3;  // memory block 3
    memorySize[3] = memory4;  // memory block 4
    memorySize[4] = memory5;  // memory block 5
    blocks = memorySize.length;
}
 
public void firstFit(int countr, int jobIndex)
{
 
   theCounter = countr;
   jobIndex = jobIndex;
 
do {
            if (jobSize[jobIndex] > memorySize[theCounter-1])
        {  
            theCounter += 1;
        }
        else
        { 
        System.out.println("----------------------------------");
        System.out.println("Job " + (jobIndex+1) + " of size "  + jobSize[jobIndex] + " has been loaded into memory block:" + theCounter);
        memorySize[theCounter-1] = (memorySize[theCounter-1]-jobSize[jobIndex]);
        System.out.println("The size of memory block " + theCounter + " is now " + memorySize[theCounter-1]);
        theCounter = 1;
        jobIndex += 1;
        }
 
  }   while (theCounter <= blocks && jobIndex < jobs);
 
  System.out.println("----------------------------------");
  jobInQueue = jobIndex;
  if (jobInQueue < jobs) {
  System.out.println("Job " + (jobInQueue+1) + " of size " + jobSize[jobInQueue] + " is sent to waiting queue!");
 
}
 
}
 
public void showData() {
System.out.println("==========================================================================");
System.out.println("Available memory blocks are: (" + memorySize[0] + "), (" + memorySize[1] + "),(" + memorySize[2] + "), (" + memorySize[3] + "), (" + memorySize[4] + ")");
System.out.println("And jobs to allocate are: (" + jobSize[0] + "), (" + jobSize[1] + "),(" + jobSize[2] + "), (" + jobSize[3] + "), (" + jobSize[4] + ")");
System.out.println("==========================================================================");
System.out.println("START");
System.out.println("===========================");
}
 
public static void main(String [] args)
 
{
 
  FirstFitAlgorithm ob = new FirstFitAlgorithm();
  ob.setJobs(64,80,10,5,18); // set new jobs, change these values if you want
  ob.setMemory(10,70,20,20,35); // ser memory blocks, change these values if you want
  ob.showData(); // display detail of available memory blocks and jobs to allocate 
  ob.firstFit(1,0);
 
  if (ob.jobInQueue < ob.jobs) {
      ob.firstFit(1,(ob.jobInQueue+1));
    }
 
  }
 
 
}