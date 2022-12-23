package src;

import java.util.Vector;

public class bestFit {
    private final Vector<process> processes;
    private final Vector<partition> partitions;

    bestFit(Vector<process> processes, Vector<partition> partitions) {
        this.processes = processes;
        this.partitions = partitions;
    }
    public void start() {
        for (process pr : processes) {
            if(pr.getTaken())
                continue;

            int idx = -1;
            int mn = Integer.MAX_VALUE;

            for (int j = 0; j < partitions.size(); j++) {
                if (partitions.get(j).getPartitionSize() >= pr.getProcessSize()
                        && mn > partitions.get(j).getPartitionSize()
                        && partitions.get(j).getReferToProcess() == null) {

                    idx = j;
                    mn = partitions.get(j).getPartitionSize();
                }
            }

            if (idx != -1) {
                int szOfNewPart = partitions.get(idx).getPartitionSize() - pr.getProcessSize();
                pr.setTaken(true);
                partitions.get(idx).setReferToProcess(pr.getProcessName());
                partitions.get(idx).setPartitionSize(pr.getProcessSize());
                if (szOfNewPart != 0) {
                    partition newPart = new partition("part" + partitions.size(), szOfNewPart);
                    partitions.add(idx + 1, newPart);
                }
            }
        }
    }
}