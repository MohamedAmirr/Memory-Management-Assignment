package src;

import java.util.Vector;

public class worstFit {
    private final Vector<partition> partitions;
    private final Vector<process> processes;

    public worstFit(Vector<partition> partitions, Vector<process> processes) {
        this.processes = processes;
        this.partitions = partitions;
    }
    void start() {
        for (process pr : processes) {
            if (pr.getTaken())
                continue;

            int idx = -1;
            int mx = Integer.MIN_VALUE;
            for (int j = 0; j < partitions.size(); j++) {
                if (pr.getProcessSize() <= partitions.get(j).getPartitionSize()
                        && partitions.get(j).getReferToProcess() == null
                        && partitions.get(j).getPartitionSize() >= mx) {

                    mx = partitions.get(j).getPartitionSize();
                    idx = j;
                }
            }
            if (idx != -1) {
                int szOfNewPart = partitions.get(idx).getPartitionSize() - pr.getProcessSize();
                pr.setTaken(true);
                partitions.get(idx).setReferToProcess(pr.getProcessName());
                partitions.get(idx).setPartitionSize(pr.getProcessSize());
                if (szOfNewPart != 0) {
                    partition newPart = new partition("Part" + partitions.size(), szOfNewPart);
                    partitions.add(idx + 1, newPart);
                }
            }
        }
    }
}
