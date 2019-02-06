import java.util.*;
class input implements Comparable
{
    private String subject;
    private int start;
    public input(String subject,int start)
    {
        this.subject=subject;
        this.start=start;
    }
    public void setSubject(String subject)
    {
    this.subject=subject;
    }
    public String getSubject()
    {
        return this.subject;
    }
    public void setStart(int start)
    {
        this.start=start;
    }
    public int getStart()
    {
        return this.start;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((subject == null) ? 0 : subject.hashCode());
        //result = prime * result + ((start == 0) ? 0 : start.hashCode());
        return result;
    }
    
    @Override
    public int compareTo(Object comparestu) {
        // input i = (input)comparestu;
        int comparestart=((input)comparestu).getStart();
        return this.start-comparestart;
    }
    @Override
    public String toString()
    {
        return this.subject +" "+this.start;
    }
}
public class HelloWorld
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Map<input,Integer> tm=new HashMap<input,Integer>();
        //List<input> li=new ArrayList<input>();
        for(int i=0;i<n;i++)
        {
            int q=sc.nextInt();
            for(int j=0;j<q;j++)
            {
            String subject=sc.next();
            String start=sc.next();
            String end=sc.next();
            int startr=Integer.parseInt(start.replace(":",""));
            int endr=Integer.parseInt(end.replace(":",""));
            tm.put(new input(subject,startr),endr);
            }
            Set<input> keys=tm.keySet();
            List<input> li=new ArrayList<input>(keys);
            Collections.sort(li);
            System.out.println(li);
            int count=0,latest=0;
            System.out.println("Output "+i);
            for(input key:li)
            {
                if(key.getStart()>latest)
                {
                    count++;
                    latest=tm.get(key);
                }
                System.out.println(key+" "+tm.get(key));
            }
            System.out.println(count);
            tm.clear();
            li.clear();
        }
    }
}