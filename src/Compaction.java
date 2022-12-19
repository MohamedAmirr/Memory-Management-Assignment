package src;
import java.util.Vector;
public class Compaction {
    public void compact(Vector<partition> part, Vector<process> pro){
        int totalSize = 0 ;
        for (int i = 0; i < part.size(); ++i){
            if(part.get(i).getPartitionSize() != 0) {
                totalSize += part.get(i).getPartitionSize();
                part.remove(part.get(i));
//                part.removeElementAt(i);
            }
        }
        String partitionName = "partition" + part.size();
        partition newPartition = new partition(partitionName,totalSize);
        part.add(newPartition);
        for (int i = 0; i < pro.size(); ++i){
            if(pro.get(i).getProcessSize() <= part.get(part.size()-1).getPartitionSize()){
                part.get(part.size()-1).setPartitionSize(part.get(part.size()-1).getPartitionSize() - pro.get(i).getProcessSize());
            }
        }
    }
}