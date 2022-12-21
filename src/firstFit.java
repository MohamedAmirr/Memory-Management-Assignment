package src;

import java.util.Formatter;
import java.util.Vector;

public class firstFit {
    Vector<process>processes;
    Vector<partition>partitions;
    public firstFit(Vector<process>processes, Vector<partition>partitions) {
        this.processes=processes;
        this.partitions=partitions;
    }

    void print(){
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

    void first_fit() {
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
        print();
    }
}
