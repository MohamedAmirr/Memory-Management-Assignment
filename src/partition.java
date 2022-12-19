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

    void setProcessSize(String _processSize) {
        processName = _processSize;
    }

    String getProcessName() {
        return processName;
    }

    int getProcessSize() {
        return processSize;
    }
}
