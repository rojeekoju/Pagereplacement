#Summary

In this project, you will be working individually to implement three page-replacement algorithms: FIFO, LRU and OPT (optimal). First, your program will use a specific set of 3 reference strings (listed below). Then, your program will generate random page-reference strings where page numbers range from 0 to 9. Apply the random page-reference string to each algorithm and record the number of page faults incurred by each algorithm. Pass the number of page frames to the program at startup. You may implement this program in Java or Python.

Here is an abstract class you may choose to include in your program:

public abstract class ReplacementAlgorithm {
    // the number of page faults
    protected int pageFaultCount;
    
    // the number of physical page frame
    protected int pageFrameCount;
    
    /**
     * @param pageFrameCount - the number of physical page frames
     */
    public ReplacementAlgorithm(int pageFrameCount) {
        if (pageFrameCount < 0)
            throw new IllegalArgumentException();
        
        this.pageFrameCount = pageFrameCount;
        pageFaultCount = 0;
    }
    
    /**
     * @return - the number of page faults that occurred.
     */
    public int getPageFaultCount() {
        return pageFaultCount;
    }
    
    /**
     * @param int pageNumber - the page number to be inserted
     */
    public abstract void insert(int pageNumber); 
}
 

The reference strings you will use initially to test are below. Output the total number of faults. The reference string size is 20 and the number of page frames in physical memory is 3.

7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1
8,1,0,7,3,0,3,4,5,3,5,2,0,6,8,4,8,1,5,3
4,6,4,8,6,3,6,0,5,9,2,1,0,4,6,3,0,6,8,4
Now you will generate a random reference string, similar to the ones above, for each configuration below and have the output report the results:

Reference string size (rss): 15

Number of page frames (npf): 3, 5, 7

 

So this will have configurations: {[rss: 15, npf: 3], [rss: 15, npf: 5], [rss: 15, npf: 7]} for a total of 3 configuration possibilities. Remember you also have 3 additional strings given to you, which makes a total of 4 reference strings tested.

Include in your README.md file which configuration and algorithm combination performed the best. Speculate on why this might be. Discuss the Big O runtime for each of these configurations and take that into consideration.

 

Part 1: Java or Python Implementation
Implement the algorithms previously mentioned in Java and perform the experiments with the chosen input lists. Results should be evaluated in terms of the metrics.

The implementation of this is largely up to you. Here are a few things I look for in well-designed implementations:

Follows principles of OOP: Inheritance, Polymorphism, Abstraction, Encapsulation
I'm not checking for each one of these. Obviously, there are situations where none or very few will be used and there are situations where all may be used. Use your discretion.
Well-organized project structure.
This could include multiple packages or possibly not. (Java version)
 

Part 2: Output and Testing
You will now be required to have a total of 3 Junit tests for your methods. If you are using Python, I suggest you use PyUnit to write your own tests.  Additional tests will be helpful to determine the robustness of the algorithms, but aren't required.
Your console output should show the page fault counts for FIFO, LRU and OPT for the configurations. At the end of the output, print the results that performed best.
 

Part 3: Report
Your README.md markdown file will simply contain discussion around which configuration performed best and why you think that is true.

 

Format Requirements
Please ensure you follow the structure as listed above. Use IntelliJ to do your work. Use Javadoc comments where appropriate.
Your submissions will be by providing a link to your Github.
 

Assessment
Please see the Rubric attached for assessment.
 

Deliverables
Github repo link.
