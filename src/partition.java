package src;
class partition{
    private String partitionName;
    private int partitionSize;

    partition(String _partitionName, int _partitionSize) {
        partitionName = _partitionName;
        partitionSize = _partitionSize;
    }

    void setPartitionName(String _partitionName) {
        partitionName = _partitionName;
    }

    void setPartitionSize(int _partitionSize) {
        partitionSize = _partitionSize;
    }

    String getPartitionName() {
        return partitionName;
    }

    int getPartitionSize() {
        return partitionSize;
    }
}
