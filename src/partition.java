package src;
class partition{
    private String partitionName;
    private int partitionSize;
    private String referToProcess=null;

    partition(String _partitionName, int _partitionSize) {
        this.partitionName = _partitionName;
        this.partitionSize = _partitionSize;
    }

    public partition() {

    }

    public void setReferToProcess(String _referToProcess){
        referToProcess=_referToProcess;
    }
    public String getReferToProcess(){
        return referToProcess;
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
    public String getPartitionInfo() {
        if(referToProcess == null)
        {
            return partitionName +" (" +partitionSize+ " KB) => " + "External fragment";
        }
        else
            return partitionName +" (" +partitionSize+ " KB) => " + referToProcess;
    }
}
