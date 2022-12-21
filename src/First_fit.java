package src;
import java.util.Formatter;
import java.util.Vector;

public class First_fit {
    public First_fit(){
    }

    void first_fit(Vector<partition> partitions, Vector<process> processes){

        for (int i = 0; i < processes.size(); i++) {
            for (int j = 0; j < partitions.size(); j++) {
                if (partitions.get(j).getPartitionSize() >= processes.get(i).getProcessSize() && !processes.get(i).getTaken()) {
                    processes.get(i).setTaken(true);
                    if(partitions.get(j).getPartitionSize()>processes.get(i).getProcessSize()){
                        partitions.get(j).setPartitionSize(processes.get(i).getProcessSize());
                        partitions.get(j).setReferToProcess(processes.get(i).getProcessName());
                        partitions.add(new partition("Part"+partitions.size(),partitions.get(j).getPartitionSize()-processes.get(i).getProcessSize()));
                    }
                    else if(partitions.get(j).getPartitionSize()==processes.get(i).getProcessSize()){
                        partitions.get(j).setPartitionSize(processes.get(i).getProcessSize());
                        partitions.get(j).setReferToProcess(processes.get(i).getProcessName());
                    }
                }
            }
        }

        Formatter fmt = new Formatter();
        fmt.format("%15s %15s %15s", "partitionName", "Partition_size","processName");
        System.out.println(fmt);
        for (int i = 0; i < partitions.size(); i++) {
            Formatter fmt1 = new Formatter();
            fmt1.format("%15s %15s ", partitions.get(i).getPartitionName(), partitions.get(i).getPartitionSize());
            System.out.println(fmt1);
            if(partitions.get(i).getReferToProcess()!=null){
                Formatter fmt2 = new Formatter();
                fmt2.format(" %15s ", partitions.get(i).getReferToProcess());
                System.out.println(fmt2);
            }
            else {
                Formatter fmt3 = new Formatter();
                fmt3.format(" %15s ", "External fragment");
                System.out.println(fmt3);
            }
        }
        for(int i=0; i<processes.size(); i++){
            if(!processes.get(i).getTaken()){
                System.out.println(processes.get(i).getProcessName()+" can not be allocated\n");
            }
        }
    }
}
