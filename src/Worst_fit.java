package src;
import java.util.Vector;
public class Worst_fit {
    public Worst_fit(){}
    void WortFit(Vector<partition> partitions , Vector<process> processes)
    {
        int pos = partitions.size();
       for (process pr : processes)
       {
          int index = -1;
          int max = Integer.MIN_VALUE;
          for (int j = 0 ; j < partitions.size() ; j++)
          {
              if (pr.getProcessSize() <= partitions.get(j).getPartitionSize() && !partitions.get(j).getflag())
              {
                  if (partitions.get(j).getPartitionSize() >= max)
                  {
                      max = partitions.get(j).getPartitionSize();
                      index = j;
                  }
              }
          }
          if (index != -1)
          {
            int size = partitions.get(index).getPartitionSize() - pr.getProcessSize();
            if (size >= 0)
            {
                partitions.get(index).setPartitionSize(pr.getProcessSize());
                partitions.get(index).setFlag(true);
                pr.setTaken(true);
                partitions.get(index).setReferToProcess(pr.getProcessName());
                if (size != 0)
                {
                    partition part = new partition("Partition" + (pos) ,size);
                    pos++;
                    partitions.add(index+1 , part);
                }
            }
          }
       }
       for(partition part:partitions)
       {
           System.out.println(part);
       }
       for (process proc:processes)
       {
           if(!proc.getTaken())
           {
               System.out.println(proc.getProcessName() + " can not be allocated");
           }
       }
    }
}
