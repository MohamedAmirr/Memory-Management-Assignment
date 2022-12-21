package src;

class process {
    private String processName;
    private int processSize;
    private boolean taken = false;
    process(String _processName, int _processSize) {
        processName = _processName;
        processSize = _processSize;
    }
    public void setTaken(boolean _taken){
        this.taken=_taken;
    }
    public boolean getTaken(){
        return this.taken;
    }

    public process() {

    }

    void setProcessName(String _processName) {
        processName = _processName;
    }

    void setProcessSize(int _processSize) {
        processSize = _processSize;
    }

    String getProcessName() {
        return processName;
    }

    int getProcessSize() {
        return processSize;
    }


}
