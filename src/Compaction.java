package src;

import java.util.Vector;

public class Compaction {
    private final Vector<partition> partitions;

    public Compaction(Vector<partition> partitions) {
        this.partitions = partitions;
    }

    public boolean compact() {
        int szOfNewPart = 0;
        for (partition part : partitions) {
            if (part.getReferToProcess() == null) {
                szOfNewPart += part.getPartitionSize();
                part.setPartitionSize(0);
            }
        }
        if (szOfNewPart > 0) {
            partition newPart = new partition("part" + partitions.size(), szOfNewPart);
            partitions.add(newPart);
            return true;
        } else return false;
    }
}