package src;

import java.util.Scanner;
import java.util.Vector;

public class Main {
    static private Scanner in;
    static private Vector<partition> partitions;
    static private Vector<process> processes;


    static void printPolicyChoices() {
        System.out.println("Select the policy you want to apply:");
        System.out.println("1. First fit.");
        System.out.println("2. Worst fit.");
        System.out.println("3. Best fit.");
        System.out.println("O.W. to exit.");
        System.out.print("Select policy: ");
    }

    static void clearData() {
        for (process pr : processes) pr = null;
        processes.clear();
        for (partition part : partitions) part = null;
        partitions.clear();
    }

    static void askForCompact() {
        System.out.println(
                "Do you want to compact?\n" +
                        "1.(yes) " +
                        "O.W.(no)"
        );

    }

    public static void main(String[] args) {
        in = new Scanner(System.in);
        processes = new Vector<>();
        partitions = new Vector<>();
        Vector<process> tmpProcesses = new Vector<>();
        Vector<partition> tmpPartitions = new Vector<>();
        System.out.print("Enter Number of partitions: ");
        int numOfPartitions = in.nextInt();
        for (int i = 1; i <= numOfPartitions; i++) {
            System.out.print("Enter partition #" + i + " name and size: ");
            String partitionName = in.next();
            int partitionSize = in.nextInt();
            partition partition = new partition(partitionName, partitionSize);
            partition tmpPartition = new partition(partitionName, partitionSize);
            partitions.add(partition);
            tmpPartitions.add(tmpPartition);
        }
        System.out.print("Enter number of processes: ");
        int numOfProcesses = in.nextInt();
        for (int i = 1; i <= numOfProcesses; i++) {
            System.out.print("Enter process #" + i + " name and size: ");
            String processName = in.next();
            int processSize = in.nextInt();
            process process = new process(processName, processSize);
            process tmpProcess = new process(processName, processSize);
            processes.add(process);
            tmpProcesses.add(tmpProcess);
        }
        char policy;
        printPolicyChoices();
        while (true) {
            policy = in.next().charAt(0);
            if (policy == '1') {//First fit
                firstFit firstFit = new firstFit(processes, partitions);
                firstFit.start();
                printing print = new printing();
                print.print(partitions, processes);
                askForCompact();
                char compact = in.next().charAt(0);
                if (compact == '1') {
                    Compaction compaction = new Compaction(partitions);
                    if(compaction.compact()) {
                        firstFit.start();
                        print.print(partitions, processes);
                    }
                    else {
                        System.out.println("Nothing to compact\n");
                    }
                }
            } else if (policy == '2') {//Worst fit
                worstFit worstFit = new worstFit(partitions, processes);
                worstFit.start();
                printing print = new printing();
                print.print(partitions, processes);
                askForCompact();
                char compact = in.next().charAt(0);
                if (compact == '1') {
                    Compaction compaction = new Compaction(partitions);
                    if(compaction.compact()) {
                        worstFit.start();
                        print.print(partitions, processes);
                    }
                    else {
                        System.out.println("Nothing to compact\n");
                    }
                }
            } else if (policy == '3') {//Best fit
                bestFit bestFit = new bestFit(processes, partitions);
                bestFit.start();
                printing print = new printing();
                print.print(partitions, processes);
                askForCompact();
                char compact = in.next().charAt(0);
                if (compact == '1') {
                    Compaction compaction = new Compaction(partitions);
                    if(compaction.compact()) {
                        bestFit.start();
                        print.print(partitions, processes);
                    }
                    else {
                        System.out.println("Nothing to compact\n");
                    }
                }
            } else {
                System.out.println();
                break;
            }
            printPolicyChoices();
            clearData();
            for (process pr : tmpProcesses)
                processes.add(new process(pr.getProcessName(), pr.getProcessSize()));
            for (partition part : tmpPartitions)
                partitions.add(new partition(part.getPartitionName(), part.getPartitionSize()));
        }
        System.out.println("Terminated!");


    }

}
