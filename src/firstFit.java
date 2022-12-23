package src;

import java.util.Vector;

public class firstFit {
    private final Vector<process> processes;
    private final Vector<partition> partitions;

    public firstFit(Vector<process> processes, Vector<partition> partitions) {
        this.processes = processes;
        this.partitions = partitions;
    }

    public void start() {
        for (process pr : processes) {
            if (pr.getTaken()) continue;

            for (int j = 0; j < partitions.size(); j++) {
                if (partitions.get(j).getPartitionSize() >= pr.getProcessSize()
                        && partitions.get(j).getReferToProcess() == null) {

                    int szOfNewPart = partitions.get(j).getPartitionSize() - pr.getProcessSize();
                    pr.setTaken(true);
                    partitions.get(j).setReferToProcess(pr.getProcessName());
                    partitions.get(j).setPartitionSize(pr.getProcessSize());
                    if (szOfNewPart > 0) {
                        partition newPart = new partition("part" + partitions.size(), szOfNewPart);
                        partitions.add(j + 1, newPart);
                        break;
                    }
                }
            }
        }
    }
}
