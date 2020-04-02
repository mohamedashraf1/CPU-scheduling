/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os3;

/**
 *
 * @author Elliot
 */
import static java.lang.Math.ceil;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class OS3 {

    public static Vector<Process> Processes = new Vector();
    public static Vector<Process> ProcessesFinal = new Vector();
    public static Vector<Process> waitingList = new Vector();
    public static Vector<Process> done = new Vector();
    public static int contextSwitch = 0;
    public static Scanner input = new Scanner(System.in);

    public static void Getinput() {
        System.out.println("Enter num of processes :");
        int numofprocesses = input.nextInt();
        System.out.println("Enter Context Switching Time :");
        contextSwitch=input.nextInt();
        for (int i = 0; i < numofprocesses; i++) {
            Process p = new Process();
            Process p2 = new Process();
            String name;
            int arrTime, burst, priorty, quantem;

            System.out.println("Enter process Name:");
            name = input.next();
            p.name = name;
            p2.name = name;

            System.out.println("Enter process Arrival Time:");
            arrTime = input.nextInt();
            p.arrivalTime = arrTime;
            p2.arrivalTime = arrTime;

            System.out.println("Enter process Burst Time:");
            burst = input.nextInt();
            p.Bursttime = burst;
            p2.Bursttime = burst;

            System.out.println("Enter priorty Time:");
            priorty = input.nextInt();
            p.PriorityNumber = priorty;
            p2.PriorityNumber = priorty;

            System.out.println("Enter Quantem :");
            quantem = input.nextInt();
            p.quantem = quantem;
            p2.quantem = quantem;

            Processes.add(p);
            ProcessesFinal.add(p2);
        }
    }

    static Vector<Process> SortBursttime(Vector<Process> arr) {//sort myChars alphabetically

        int i, j;
        for (i = 0; i < arr.size() - 1; i++) {//bubble sort
            for (j = 0; j < arr.size() - i - 1; j++) {
                if (arr.elementAt(j).Bursttime == arr.elementAt(j + 1).Bursttime && arr.elementAt(j).waitingTime < arr.elementAt(j + 1).waitingTime) {

                } else if (arr.elementAt(j).Bursttime > arr.elementAt(j + 1).Bursttime) {

                    String name;
                    int arrivalTime;
                    int Bursttime;
                    int PriorityNumber;
                    int waitingTime;
                    int turnaroundTime;

                    name = arr.elementAt(j).name;
                    arr.elementAt(j).name = arr.elementAt(j + 1).name;
                    arr.elementAt(j + 1).name = name;

                    arrivalTime = arr.elementAt(j).arrivalTime;
                    arr.elementAt(j).arrivalTime = arr.elementAt(j + 1).arrivalTime;
                    arr.elementAt(j + 1).arrivalTime = arrivalTime;

                    Bursttime = arr.elementAt(j).Bursttime;
                    arr.elementAt(j).Bursttime = arr.elementAt(j + 1).Bursttime;
                    arr.elementAt(j + 1).Bursttime = Bursttime;

                    PriorityNumber = arr.elementAt(j).PriorityNumber;
                    arr.elementAt(j).PriorityNumber = arr.elementAt(j + 1).PriorityNumber;
                    arr.elementAt(j + 1).PriorityNumber = PriorityNumber;

                    waitingTime = arr.elementAt(j).waitingTime;
                    arr.elementAt(j).waitingTime = arr.elementAt(j + 1).waitingTime;
                    arr.elementAt(j + 1).waitingTime = waitingTime;

                    turnaroundTime = arr.elementAt(j).turnaroundTime;
                    arr.elementAt(j).turnaroundTime = arr.elementAt(j + 1).turnaroundTime;
                    arr.elementAt(j + 1).turnaroundTime = turnaroundTime;

                }

            }
        }
        return arr;
    }

    static Vector<Process> SortPrioritytime(Vector<Process> arr) {//sort myChars alphabetically

        int i, j;
        for (i = 0; i < arr.size() - 1; i++) {//bubble sort
            for (j = 0; j < arr.size() - i - 1; j++) {
                /*if(arr.elementAt(j).Bursttime == arr.elementAt(j+1).Bursttime && arr.elementAt(j).PriorityNumber > arr.elementAt(j+1).PriorityNumber){
                    
                }*/
                if (arr.elementAt(j).PriorityNumber > arr.elementAt(j + 1).PriorityNumber) {

                    String name;
                    int arrivalTime;
                    int Bursttime;
                    int PriorityNumber;
                    int waitingTime;
                    int turnaroundTime;

                    name = arr.elementAt(j).name;
                    arr.elementAt(j).name = arr.elementAt(j + 1).name;
                    arr.elementAt(j + 1).name = name;

                    arrivalTime = arr.elementAt(j).arrivalTime;
                    arr.elementAt(j).arrivalTime = arr.elementAt(j + 1).arrivalTime;
                    arr.elementAt(j + 1).arrivalTime = arrivalTime;

                    Bursttime = arr.elementAt(j).Bursttime;
                    arr.elementAt(j).Bursttime = arr.elementAt(j + 1).Bursttime;
                    arr.elementAt(j + 1).Bursttime = Bursttime;

                    PriorityNumber = arr.elementAt(j).PriorityNumber;
                    arr.elementAt(j).PriorityNumber = arr.elementAt(j + 1).PriorityNumber;
                    arr.elementAt(j + 1).PriorityNumber = PriorityNumber;

                    waitingTime = arr.elementAt(j).waitingTime;
                    arr.elementAt(j).waitingTime = arr.elementAt(j + 1).waitingTime;
                    arr.elementAt(j + 1).waitingTime = waitingTime;

                    turnaroundTime = arr.elementAt(j).turnaroundTime;
                    arr.elementAt(j).turnaroundTime = arr.elementAt(j + 1).turnaroundTime;
                    arr.elementAt(j + 1).turnaroundTime = turnaroundTime;

                }

            }
        }
        return arr;
    }

    static Vector<Process> SortAGfactor(Vector<Process> arr) {//sort myChars alphabetically

        int i, j;
        for (i = 0; i < arr.size() - 1; i++) {//bubble sort
            for (j = 0; j < arr.size() - i - 1; j++) {
                /*if(arr.elementAt(j).Bursttime == arr.elementAt(j+1).Bursttime && arr.elementAt(j).PriorityNumber > arr.elementAt(j+1).PriorityNumber){
                    
                }*/
                if (arr.elementAt(j).Agfactor > arr.elementAt(j + 1).Agfactor) {

                    String name;
                    int arrivalTime;
                    int Bursttime;
                    int PriorityNumber;
                    int waitingTime;
                    int turnaroundTime;
                    int agfactor;
                    float qunatem;

                    name = arr.elementAt(j).name;
                    arr.elementAt(j).name = arr.elementAt(j + 1).name;
                    arr.elementAt(j + 1).name = name;

                    arrivalTime = arr.elementAt(j).arrivalTime;
                    arr.elementAt(j).arrivalTime = arr.elementAt(j + 1).arrivalTime;
                    arr.elementAt(j + 1).arrivalTime = arrivalTime;

                    Bursttime = arr.elementAt(j).Bursttime;
                    arr.elementAt(j).Bursttime = arr.elementAt(j + 1).Bursttime;
                    arr.elementAt(j + 1).Bursttime = Bursttime;

                    PriorityNumber = arr.elementAt(j).PriorityNumber;
                    arr.elementAt(j).PriorityNumber = arr.elementAt(j + 1).PriorityNumber;
                    arr.elementAt(j + 1).PriorityNumber = PriorityNumber;

                    waitingTime = arr.elementAt(j).waitingTime;
                    arr.elementAt(j).waitingTime = arr.elementAt(j + 1).waitingTime;
                    arr.elementAt(j + 1).waitingTime = waitingTime;

                    turnaroundTime = arr.elementAt(j).turnaroundTime;
                    arr.elementAt(j).turnaroundTime = arr.elementAt(j + 1).turnaroundTime;
                    arr.elementAt(j + 1).turnaroundTime = turnaroundTime;

                    agfactor = arr.elementAt(j).Agfactor;
                    arr.elementAt(j).Agfactor = arr.elementAt(j + 1).Agfactor;
                    arr.elementAt(j + 1).Agfactor = agfactor;

                    qunatem = arr.elementAt(j).quantem;
                    arr.elementAt(j).quantem = arr.elementAt(j + 1).quantem;
                    arr.elementAt(j + 1).quantem = qunatem;
                }

            }
        }
        return arr;
    }

    static void print(Vector<Process> arr) {
        float avgwait = 0;
        float avgturn = 0;
        for (int i = 0; i < arr.size(); i++) {
            System.out.println("name : " + arr.elementAt(i).name);
            System.out.println("burst time : " + arr.elementAt(i).Bursttime);
            System.out.println("arrival time : " + arr.elementAt(i).arrivalTime);
            System.out.println("waiting time : " + arr.elementAt(i).waitingTime);
            System.out.println("turnarround time : " + arr.elementAt(i).turnaroundTime);
            System.out.println("priority : " + arr.elementAt(i).PriorityNumber);
            System.out.println("Agfactor : " + arr.elementAt(i).Agfactor);
            System.out.println("quamte: " + arr.elementAt(i).quantem);

            System.out.println("");
            avgwait += arr.elementAt(i).waitingTime;
            avgturn += arr.elementAt(i).turnaroundTime;
        }
        System.out.println("average waiting time : " + avgwait / arr.size());
        System.out.println("average turn arround time : " + avgturn / arr.size());

    }

    public static void SJF(Vector<Process> p) {
        
        int i = 0;

        int size = p.size();
        while (done.size() < size) {
            int j = 0;
            boolean removed = false;
            while (j < p.size()) {
                if (i >= p.elementAt(j).arrivalTime) {
                    waitingList.add(p.elementAt(j));
                    p .remove(j);
                    removed = true;
                    //j = 0;
                }
                if (removed) {
                    j = 0;
                    removed = false;
                } else {
                    j++;
                }
            }

            waitingList = SortBursttime(waitingList);

            done.add(waitingList.elementAt(0));
            waitingList.remove(0);

            done.elementAt(done.size() - 1).waitingTime = i - done.elementAt(done.size() - 1).arrivalTime;
            done.elementAt(done.size() - 1).turnaroundTime = done.elementAt(done.size() - 1).waitingTime + done.elementAt(done.size() - 1).Bursttime;

            i += done.elementAt(done.size() - 1).Bursttime;

        }
    }

    public static void addWaiting(Vector<Process> arr, int time) {
        boolean found = false;
        for (int i = 0; i < arr.size(); i++) {//loop in the array if the condition is true and it's not already in the waiting list add it
            if (time >= arr.elementAt(i).arrivalTime) {//chech if apply
                for (int j = 0; j < waitingList.size(); j++) {
                    if (arr.elementAt(i).name.equals(waitingList.elementAt(j).name)) {//if the process is already in the waiting list
                        found = true;
                        break;
                    }
                }
                if (found == false) {//if it's false then it wasn't in the waiting list then add it
                    waitingList.add(arr.elementAt(i));
                }

            }
            found = false;
        }
    }

    public static void addWaiting2(Vector<Process> arr, int time) {
        boolean found = false;
        for (int i = 0; i < arr.size(); i++) {//loop in the array if the condition is true and it's not already in the waiting list add it
            if (time >= arr.get(i).arrivalTime) {//chech if apply
                 waitingList.add(arr.elementAt(i));
                 arr.remove(i);
                }
              
            }
    }

    public static Vector<String> SRTF(Vector<Process> arr, int context) {
        int size = 0;
        Vector<Process> fixed = new Vector();
        Vector<String> names = new Vector<>();
        Vector<Integer> bursts = new Vector<>();

        for (int i = 0; i < arr.size(); i++) {
            fixed.add(arr.elementAt(i));
            bursts.add(arr.elementAt(i).Bursttime);
        }
        String con = "Switch";

        for (int i = 0; i < arr.size(); i++) {
            size += arr.elementAt(i).Bursttime;
        }
        int time = 0;
        while (time < size) {

            addWaiting(arr, time);

            waitingList = SortBursttime(waitingList);
            waitingList.elementAt(0).Bursttime--;//minus the burst time in the waiting list

            if (time != 0) {
                if (!waitingList.elementAt(0).name.equals(names.elementAt(names.size() - 1))) {
                    time += context;
                    names.add(con);
                    size++;
                }
            }

            done.add(waitingList.elementAt(0));
            names.add(done.elementAt(done.size() - 1).name);

            if (waitingList.elementAt(0).Bursttime <= 0) {//if the procces finished delete it from the arr and the waiting list
                for (int i = 0; i < arr.size(); i++) {
                    //System.out.println("1-time before remove : " +arr.elementAt(i).name + "  "+ time);
                    if (arr.elementAt(i).name.equals(waitingList.elementAt(0).name)) {
                        //System.out.println("-------2---------");
                        for (int j = 0; j < fixed.size(); j++) {//find the element in the fixed
                            if (arr.elementAt(i).name.equals(fixed.elementAt(j).name)) {
                                System.out.println("time before remove : " + arr.elementAt(i).name + "  " + time);

                                fixed.elementAt(j).turnaroundTime = (time + 1) - fixed.elementAt(j).arrivalTime;
                                for (int k = 0; k < ProcessesFinal.size(); k++) {
                                    if (fixed.elementAt(j).name.equals(ProcessesFinal.elementAt(k).name)) {
                                        fixed.elementAt(j).waitingTime = fixed.elementAt(j).turnaroundTime - ProcessesFinal.elementAt(k).Bursttime;
                                        break;
                                    }
                                }
                                //fixed.elementAt(j).waitingTime = fixed.elementAt(j).turnaroundTime - ProcessesFinal.elementAt(j).Bursttime;

                                break;
                            }
                        }
                        arr.remove(i);
                        break;
                    }
                }
                waitingList.remove(0);
            }

            time++;
        }
        print(fixed);
        return names;
    }

    public static void PriorityScheduling(Vector<Process> arr) {
        int time = 0;
        Vector<String> names = new Vector<>();
        arr = SortBursttime(arr);
        while (arr.size() > 0) {

            addWaiting(arr, time);

            waitingList = SortPrioritytime(waitingList);

            //names.add(waitingList.get(0).name);
            time += waitingList.get(0).Bursttime;
            waitingList.get(0).turnaroundTime = time - waitingList.get(0).arrivalTime;
            waitingList.get(0).waitingTime = waitingList.get(0).turnaroundTime - waitingList.get(0).Bursttime;
            done.add(waitingList.get(0));

            //System.out.println(time);
            for (int i = 0; i < arr.size(); i++) {
                if (waitingList.get(0).name.equals(arr.get(i).name)) {
                    System.out.println(arr.get(i).name + " " + "size" + arr.size());
                    arr.remove(i);

                    break;
                }

            }

            waitingList.remove(0);

            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).PriorityNumber > 1) {
                    arr.get(i).PriorityNumber--;
                }
            }
            /*for(int i=0;i<arr.size();i++){
                 System.out.println(arr.get(i).name);
               }
             */
        }

        print(done);
    }

    public static void AgScheduling(Vector<Process> arr) {
        int time = 0;
        int count = 0;
        double excute = 0;
        double burst_time = 0;
        boolean flag = true;
        Vector<Process> bb = new Vector();
        
        for (int i = 0; i < arr.size(); i++) {
            arr.get(i).Agfactor = (arr.get(i).Bursttime + arr.get(i).PriorityNumber + arr.get(i).arrivalTime);
            burst_time += arr.get(i).Bursttime;
           bb.add(arr.get(i));

        }
        
        while (burst_time > 0)
        {
            addWaiting2(arr, time);
            if (time == 0) 
            {
                waitingList = SortAGfactor(waitingList);
                done.add(waitingList.get(0));
                if (ceil((done.get(done.size() - 1).quantem) / 2) < ceil((done.get(done.size() - 1).Bursttime))) {
                    excute = ceil((done.get(done.size() - 1).quantem) / 2); //
                    count =  (int)excute;
                    //burst_time -= excute;
                    //done.get(done.size()).Bursttime -= excute;
                } 
                else 
                {
                    excute = done.get(done.size() - 1).Bursttime;
                    done.get(done.size() - 1).Bursttime -= excute;
                    count =(int) excute;
                }
                waitingList.remove(0);
                time = (int) excute;
            }
            else 
            {
                if (done.get(done.size() - 1).Bursttime <= 0 || excute == done.get(done.size() - 1).quantem || (done.get(done.size() - 1).Bursttime - count) <= 0) 
                {
                    burst_time -= excute;
                    if (done.get(done.size() - 1).Bursttime <= 0 || (done.get(done.size() - 1).Bursttime - count) <= 0) {
                        done.get(done.size() - 1).Bursttime = 0;
                        done.get(done.size() - 1).quantem = 0;
                        done.get(done.size() - 1).turnaroundTime = time - done.get(done.size() - 1).arrivalTime;
                        for(int i=0 ; i<ProcessesFinal.size() ; i++)
                        {
                          if(ProcessesFinal.get(i).name.equals(done.get(done.size()-1).name))
                          {
                         done.get(done.size() - 1).waitingTime = done.get(done.size() - 1).turnaroundTime - ProcessesFinal.get(i).Bursttime ;
                          }
                        }
                        for(int i=0 ; i <bb.size() ; i++)
                        {
                            if(bb.get(i).name.equals(done.get(done.size()-1).name))
                            {
                                done.get(done.size() - 1).waitingTime = done.get(done.size() - 1).turnaroundTime - bb.get(i).Bursttime;
                            }
                        }
                        
                    } 
                    else 
                    {
                        done.get(done.size() - 1).quantem += 1;
                        done.get(done.size() - 1).Bursttime -= excute;
                        waitingList.add(done.get(done.size() - 1));
                    }
                    if(waitingList.size() !=0)
                    {
                    done.add(waitingList.get(0));
                    waitingList.remove(0);
                    }
                    if (ceil((done.get(done.size() - 1).quantem) / 2) < ceil((done.get(done.size() - 1).Bursttime))) {
                        excute = ceil((done.get(done.size() - 1).quantem) / 2);
                        time += excute;
                        count=(int)excute;
                        //burst_time -= excute;
                        //done.get(done.size()).Bursttime -= excute;
                    } else {
                        excute = done.get(done.size() - 1).Bursttime;
                        done.get(done.size() - 1).Bursttime = 0;
                        time += excute;
                        count = (int)excute;
                      
                    }
                } 
                else {
                    int max = done.get(done.size() - 1).Agfactor;
                    int j = 0;
                    for (int i = 0; i < waitingList.size(); i++) {
                        if (waitingList.get(i).Agfactor < max) {
                            max = waitingList.get(i).Agfactor;
                            j = i;
                        }
                    }
                    if (max < done.get(done.size() - 1).Agfactor) {
                        done.get(done.size() - 1).quantem += (done.get(done.size() - 1).quantem - (int) excute);
                        System.out.println("quantem : " + done.get(done.size() - 1).quantem + "proc : " + done.get(done.size() - 1).name);
                        burst_time -= excute;
                        done.get(done.size() - 1).Bursttime -= excute;
                        waitingList.add(done.get(done.size()-1));
                        done.add(waitingList.get(j));
                        waitingList.remove(j);
                        if ((ceil((done.get(done.size() - 1).quantem) / 2)) < ceil((done.get(done.size() - 1).Bursttime))) {
                            excute = ceil((done.get(done.size() - 1).quantem) / 2);
                            time += excute;
                            count = (int)excute;
                            flag = true;
                            //burst_time -= excute;
                            //done.get(done.size()).Bursttime -= excute;
                        }
                        else
                        {
                            excute = done.get(done.size() - 1).Bursttime;
                            done.get(done.size() - 1).Bursttime -=excute;
                            time += excute;
                            count = (int)excute;
                            flag = true;
                        }

                    }
                    else {
                        flag = false;
                        excute++;
                        count++;
                        time++;
                    }

                }
            }
        }
        System.out.println(done.size() + " " + time + "\n");
        // print(waitingList);
        print(done);

    }

    public static void main(String[] args) {
        Getinput();
        Vector<String> names = new Vector();
        //SJF(Processes);
        //print(done);
        //print(Processes  );
        //System.out.println("-------------------------");
        /*names = SRTF(Processes,contextSwitch);
        for(int i = 0 ; i <names.size() ; i++){
            System.out.print(names.get(i) + " ");
        }*/
        
        //Processes = SortPrioritytime(Processes);
        //print(Processes);
        //PriorityScheduling(Processes);
        AgScheduling(Processes);

        //print(Processes);
        //System.out.println("---------------");
    }
    
}
