/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpletimeimpl;

import simpletimeapi.Duration;

/**
 *
 * @author jorge
 */
public class APDuration implements Duration {

    private final int minutes;

    public APDuration(int hours, int minutes) {
        this.minutes = (hours * 60) + (minutes);
    }

    public APDuration(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public Duration plus(Duration d) {
//        this.minutes = ((d.getHours() * 60) + d.getMinutes()) + this.minutes;
        APDuration newDuration = new APDuration(((d.getHours() * 60) + d.getMinutes()) + this.minutes);
        return newDuration;
    }

    @Override
    public int getHours() {
        int hours = 0;
        int totalMinutes = minutes;
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
        return this.minutes - hoursInMinutes;
    }

    @Override
    public int asMinutes() {
        return  this.minutes;
    }

    @Override
    public int compareTo(Duration o) {
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
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        
        if (obj == null)return false;
        
        if (getClass() != obj.getClass()) return false;
        
        final APDuration other = (APDuration) obj;
//        if (this.hours != other.hours) return false;
        return this.minutes == other.minutes;
    }

    @Override
    public String toString() {
        return "APDuration{" + ", minutes=" + minutes + '}';
    }

}
