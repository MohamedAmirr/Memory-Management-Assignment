package src;

class process {
    private String processName;
    private int processSize;
    private boolean taken = false;

    process(String _processName, int _processSize) {
        processName = _processName;
        processSize = _processSize;
    }
    void setTaken(boolean _taken)
    {
        taken = _taken;
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
    Boolean getTaken()
    {
        return taken;
    }

}
