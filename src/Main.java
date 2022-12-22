package src;

import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Vector<process> processes = new Vector<>();
        Vector<partition> partitions = new Vector<>();
        System.out.print("Enter Number of partitions: ");
        int numOfPartitions = in.nextInt();
        for (int i = 1; i <= numOfPartitions; i++) {
            System.out.print("Enter partition #" + i + " name and size: ");
            String partitionName = in.next();
            int partitionSize = in.nextInt();
            partition partition = new partition(partitionName, partitionSize);
            partitions.add(partition);
        }
        System.out.print("Enter number of processes: ");
        int numOfProcesses = in.nextInt();
        for (int i = 1; i <= numOfProcesses; i++) {
            System.out.print("Enter process #" + i + " name and size: ");
            String processName = in.next();
            int processSize = in.nextInt();
            process process = new process(processName, processSize);
            processes.add(process);
        }
        int policy = 0;
        do {
            System.out.println("Select the policy you want to apply:");
            System.out.println("1. First fit.");
            System.out.println("2. Worst fit.");
            System.out.println("3. Best fit.");
            System.out.println("Any other letter to exit.");
            System.out.print("Select policy: ");
            policy = in.nextInt();
            if (policy == 1) {//First fit

            } else if (policy == 2) {
                Worst_fit worst_fit = new Worst_fit();
                worst_fit.WortFit(partitions,processes);

            } else if (policy == 3) {//Best fit

            }
            System.out.println(
                    "Do you want to compact?\n" +
                            "1.(yes) " +
                            "O.W.(no)"
            );
            int compact = in.nextInt();
            if (compact == 1) {

            }
        } while (policy >= 1 && policy <= 3);
        System.out.println("Terminated!");


    }

}
