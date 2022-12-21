package src;

import java.util.Vector;

public class Compaction {
    private final Vector<partition> partitions;

    public Compaction(Vector<partition> partitions) {
        this.partitions = partitions;
    }

    public void compact() {
        int totalSize = 0;
        for (int i = 0; i < partitions.size(); ++i) {
            if (partitions.get(i).getReferToProcess() == null) {
                totalSize += partitions.get(i).getPartitionSize();
                partitions.get(i).setPartitionSize(0);
            }
        }
        partitions.add(new partition("Part" + partitions.size(), totalSize));
    }
}