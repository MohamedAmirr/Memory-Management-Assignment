package src;
class partition{
    private boolean flag;
    private String partitionName;
    private int partitionSize;
    private String referToProcess;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public boolean getflag()
    {
        return flag;
    }
    partition(String _partitionName, int _partitionSize ) {
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

    public String toString() {
        if(referToProcess == null)
        {
            referToProcess = "External fragment";
        }
        return partitionName +" (" +partitionSize+ " KB) => " + referToProcess;
    }
}
