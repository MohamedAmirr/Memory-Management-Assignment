package src;

class process {
    private String processName;
    private int processSize;

    process(String _processName, int _processSize) {
        processName = _processName;
        processSize = _processSize;
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
