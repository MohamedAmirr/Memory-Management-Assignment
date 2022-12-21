package src;
import java.util.Vector;

public class Compaction {
    private final Vector<process>processes;
    private final Vector<partition>partitions;
    public Compaction(Vector<process> processes, Vector<src.partition> partitions) {
        this.processes = processes;
        this.partitions = partitions;
    }

    public void compact(){
        int totalSize = 0 ;
//        int size = partitions.size();
        for (int i = 0; i < partitions.size(); ++i){
            if(partitions.get(i).getReferToProcess() == null) {
                totalSize += partitions.get(i).getPartitionSize();
//                partitions.remove(partitions.get(i));
                partitions.get(i).setPartitionSize(0);
            }
        }
        partitions.insertElementAt(new partition("Part" + partitions.size(), totalSize), partitions.size());
    }
}