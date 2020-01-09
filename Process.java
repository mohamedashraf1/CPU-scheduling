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
public class Process {
    String name;
    int arrivalTime;
    int Bursttime;
    int PriorityNumber;
    int waitingTime;
    int turnaroundTime;
    int Agfactor;
    float quantem;
    

    public Process() {
        name="";
        arrivalTime=0;
        Bursttime=0;
        PriorityNumber=0;
        Agfactor=0;
        quantem=0;
    }

    public Process(String name, int arrivalTime, int Bursttime, int PriorityNumber, int waitingTime, int turnaroundTime, int Agfactor, float quantem) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.Bursttime = Bursttime;
        this.PriorityNumber = PriorityNumber;
        this.waitingTime = waitingTime;
        this.turnaroundTime = turnaroundTime;
        this.Agfactor = Agfactor;
        this.quantem = quantem;
    }

   

    
  
}

