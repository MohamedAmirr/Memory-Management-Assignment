package src;

import java.util.Vector;

public class printing {
    public void print(Vector<partition> partitions, Vector<process> processes) {
        for (partition part : partitions) {
            if (part.getPartitionSize() != 0)
                System.out.println(part.getPartitionInfo());
        }
        System.out.println();
        for (process proc : processes) {
            if (!proc.getTaken()) {
                System.out.println(proc.getProcessName() + " can not be allocated");
            }
        }
        System.out.println();
    }
}
