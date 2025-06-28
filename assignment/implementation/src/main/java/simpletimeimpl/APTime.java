/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpletimeimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import simpletimeapi.Duration;
import simpletimeapi.Time;

/**
 *
 * @author jorge
 */
public class APTime implements Time {
    
    private final int minutes;
    
    public APTime(int minutes) {
        int totalMinutes = getMinutesFromList() + minutes;
        //Negative time is not allowed        
        if(totalMinutes < 0){
            throw new IllegalArgumentException("Minutes can not be less than 0");
        }
        //check incorrect minutes
//        else if(totalMinutes > 1439 && this.minutes == 0){
        else if(totalMinutes > 1439 && getMinutesFromList() == 0){
            throw new IllegalArgumentException("Minutes can not be more than 23:59");
        }
        this.minutes = minutes;
    }
//    private final List<Integer> minutes = new ArrayList<>();

    private int getMinutesFromList(){
        
//        int totalMinutes = 0;
        return this.minutes;
//        for(int minute : this.minutes){
//            totalMinutes += minute;
//        }
//        return totalMinutes;
    }
    @Override
    public Time addTime(Time t) {
        return addTime((t.getHours() * 60) + t.getMinutes());
    }

    @Override
    public Time addTime(int minutes) {
//        if(this.minutes.isEmpty()) this.minutes.add(0);
//        int totalMinutes = this.minutes + minutes;
        int totalMinutes = getMinutesFromList() + minutes;

        //check new day 
        if(totalMinutes > 1440){
//            this.minutes = totalMinutes - 1440;
//            this.minutes.clear();
            return new APTime(totalMinutes - 1440);
        }
//      this.minutes = totalMinutes;
//        this.minutes.clear();
//        this.minutes.add(totalMinutes);
        
        return new APTime(totalMinutes);
    }

    @Override
    public int getHours() {
        int hours = 0;
//        int totalMinutes = this.minutes;
        int totalMinutes = getMinutesFromList();
        while (totalMinutes > 60 || totalMinutes % 60 == 0) {
            if (totalMinutes <= 0) {
                break;
            }
            hours = hours + 1;
            totalMinutes = totalMinutes - 60;
        }
        return hours;
    }

    @Override
    public int getMinutes() {
        int hoursInMinutes = (getHours() * 60);
//        return this.minutes - hoursInMinutes;
        return getMinutesFromList() - hoursInMinutes;
    }

    @Override
    public boolean isBefore(Time other) {
//        int currentTotalTime = this.minutes;
        int currentTotalTime = getMinutesFromList();
        int insertedTime = (other.getHours() * 60) + other.getMinutes();
        
        return (currentTotalTime < insertedTime);
    }

    @Override
    public boolean isBeforeOrEqual(Time other) {
//        int currentTotalTime = this.minutes;
        int currentTotalTime = getMinutesFromList();
        int insertedTime = (other.getHours() * 60) + other.getMinutes();
        
        return (currentTotalTime <= insertedTime);
    }

    @Override
    public int asMinutes() {
//        return this.minutes;
        return getMinutesFromList();
    }

    @Override
    public Duration until(Time other) {
       //check remained minutes until that time
       if(asMinutes() > other.asMinutes()){
           int difference = (1440 - asMinutes()) + other.asMinutes();
           Duration duration = new APDuration(difference);
           duration.plus(duration);
           return duration;
       }
       int difference = Math.abs(asMinutes() - other.asMinutes());
       Duration duration = new APDuration(difference);
       duration.plus(duration);
       return duration;
    } 

    @Override
    public int compareTo(Time o) {
        if (this.asMinutes() > o.asMinutes()) {
            System.out.println("[" + asMinutes() + " minutes is greater than " + o.asMinutes() + "] ");
            return 1;
        } else if (o.asMinutes() == this.asMinutes()) {
            System.out.println("[" + asMinutes() + " minutes is equal than " + o.asMinutes() + "] ");
            return 0;
        } else {
            System.out.println("[" + asMinutes() + " minutes is less than " + o.asMinutes() + "] ");
            return -1;
        }
        
    }

    @Override
    public String toString() {
        int totalMinutes = getMinutesFromList();
        int hours = totalMinutes / 60; //since both are ints, you get an int
        int minutes = totalMinutes % 60;
        
        return String.format("%02d:%02d", hours, minutes);

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.minutes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        
        if (obj == null) return false;
        
        if (getClass() != obj.getClass()) return false;
        
        final APTime other = (APTime) obj;
        return Objects.equals(this.minutes, other.minutes);
    }
}
