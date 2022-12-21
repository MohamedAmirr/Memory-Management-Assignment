package src;

import java.util.Formatter;
import java.util.Vector;

public class firstFit {
    private final Vector<process>processes;
    private final Vector<partition>partitions;
    public firstFit(Vector<process>processes, Vector<partition>partitions) {
        this.processes=processes;
        this.partitions=partitions;
    }

//    public firstFit(Vector<process>processes, Vector<partition>partitions, int choice) {
//        this.processes=processes;
//        this.partitions=partitions;
//        if(choice == 1) {
//            Compaction c1 = new Compaction(processes,partitions);
//            c1.compact();
//        }
//    }

//    public void compact(){
//        int totalSize = 0 ;
//        int size = partitions.size();
//        for (int i = 0; i < partitions.size(); ++i){
//            if(partitions.get(i).getReferToProcess() == null) {
//                totalSize += partitions.get(i).getPartitionSize();
//                partitions.remove(partitions.get(i));
//                i--;
//            }
//        }
//        partitions.insertElementAt(new partition("Part" + size, totalSize), partitions.size());
//
//        for (int i = 0; i < processes.size(); ++i) {
//            if (partitions.get(partitions.size()-1).getPartitionSize() >= processes.get(i).getProcessSize() && !processes.get(i).getTaken()) {
//                processes.get(i).setTaken(true);
//                if (partitions.get(partitions.size()-1).getPartitionSize() > processes.get(i).getProcessSize()) {
//                    int sz = partitions.get(partitions.size()-1).getPartitionSize() - processes.get(i).getProcessSize();
//                    partitions.get(partitions.size()-1).setPartitionSize(processes.get(i).getProcessSize());
//                    partitions.get(partitions.size()-1).setReferToProcess(processes.get(i).getProcessName());
//                    partitions.insertElementAt(new partition("Part" + (size+1), sz), i + 1);
//                    break;
//                } else if (partitions.get(partitions.size()-1).getPartitionSize() == processes.get(i).getProcessSize()) {
//                    partitions.get(partitions.size()-1).setPartitionSize(processes.get(i).getProcessSize());
//                    partitions.get(partitions.size()-1).setReferToProcess(processes.get(i).getProcessName());
//                    break;
//                }
//            }
//        }
//        print();
//    }
    public void printWithoutCompaction(){
        Formatter fmt = new Formatter();
        fmt.format("%13s %15s %15s", "partitionName", "Partition_size", "processName");
        System.out.println(fmt);
        for (int i = 0; i < partitions.size(); i++) {
            Formatter fmt1 = new Formatter();
            if (partitions.get(i).getReferToProcess() != null) {
                fmt1.format("%12s %10s %13s", partitions.get(i).getPartitionName(), partitions.get(i).getPartitionSize(), partitions.get(i).getReferToProcess());
            } else {
                fmt1.format("%12s %10s %27s", partitions.get(i).getPartitionName(), partitions.get(i).getPartitionSize(), "External fragment");
            }
            System.out.println(fmt1);
        }
        for (int i = 0; i < processes.size(); i++) {
            if (!processes.get(i).getTaken()) {
                System.out.println(processes.get(i).getProcessName() + " can not be allocated\n");
            }
        }
    }

    public void printWithCompaction(){

    }
    public void first_fit() {
        for (int i = 0; i < processes.size(); i++) {
            for (int j = 0; j < partitions.size(); j++) {
                if (partitions.get(j).getPartitionSize() >= processes.get(i).getProcessSize() && !processes.get(i).getTaken()) {
                    processes.get(i).setTaken(true);
                    if (partitions.get(j).getPartitionSize() > processes.get(i).getProcessSize()) {
                        int sz = partitions.get(j).getPartitionSize() - processes.get(i).getProcessSize();
                        partitions.get(j).setPartitionSize(processes.get(i).getProcessSize());
                        partitions.get(j).setReferToProcess(processes.get(i).getProcessName());
                        partitions.insertElementAt(new partition("Part" + partitions.size(), sz), j + 1);
                        break;
                    } else if (partitions.get(j).getPartitionSize() == processes.get(i).getProcessSize()) {
                        partitions.get(j).setPartitionSize(processes.get(i).getProcessSize());
                        partitions.get(j).setReferToProcess(processes.get(i).getProcessName());
                        break;
                    }
                }
            }
        }
        printWithoutCompaction();
    }
}
