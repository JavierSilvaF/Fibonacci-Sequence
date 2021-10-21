// Required Libraries:
import javax.swing.*;
import org.math.plot.*;
import org.math.plot.plotObjects.*;
import java.awt.*;

public class FibonacciProblem {
    // Function to calculate the Fibonacci Number through Recursion:
    public static long FibonacciRecursive(long n) {
        if (n == 0){ return n;}
        if (n == 1){ return n;}
        else
            return FibonacciRecursive(n - 1) + FibonacciRecursive(n - 2);
    }

    // Function to calculate the Fibonacci Number through Iteration:
    public static long FibonacciIterative(long n) {
        int PrevPrev, PrevNumber = 0, CurrNumber = 1;
        
        for (int i = 1; i < n ; i++) {
            PrevPrev = PrevNumber;
            PrevNumber = CurrNumber;
            CurrNumber = PrevPrev + PrevNumber;
        }
        return CurrNumber;
    }

    public static void main(String[] args) {
    
    // Declaring the Arrays for the Recursive Method:
    double[] TimeA = new double[50];
    double[] InputA = new double[50];

    for(int i = 0; i < 50; i++){
        System.out.println("Currently calculating number:");
        System.out.println(i);

        long start = System.nanoTime();
        FibonacciRecursive(i);
        long end = System.nanoTime();
        var timeTaken = end-start;

        InputA[i] = i;
        TimeA[i] = timeTaken;

    }

    //Declaring the Arrays for the Iterative Method:
    double[] TimeB = new double[50];
    double[] InputB = new double[50];

    for(int i = 0; i < 50; i++){
        System.out.println("Current Number:");
        System.out.println(i);

        long start = System.nanoTime();
        FibonacciIterative(i);
        long end = System.nanoTime();
        var timeTaken = end-start;

        InputB[i] = i;
        TimeB[i] = timeTaken;

    }

    System.out.println("Done with the numbers!");

    // Creating the PlotPanel:
    Plot2DPanel plot = new Plot2DPanel();

    // Defining the Legend Position and Title:
    plot.addLegend("SOUTH");
    BaseLabel title = new BaseLabel("Recursive vs Iterative Fibonacci:", Color.black, 0.5, 1.1);
    title.setFont(new Font("Courier", Font.BOLD, 20));
    plot.addPlotable(title);

    // Adding the line plots to the plot:
    plot.addLinePlot("Recursive Plot", InputA, TimeA);
    plot.addLinePlot("Iterative Plot", InputB, TimeB);

    // Putting the Plot into a JFrame:
    JFrame frame = new JFrame("Valencia College - Javier Silva");
    frame.setSize(600, 600);
    frame.setContentPane(plot);
    frame.setVisible(true);

    }// Main
}// Class
