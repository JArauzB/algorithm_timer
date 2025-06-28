/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package simpletime;

import simpletimeapi.AbstractAPFactory;
import simpletimeapi.Duration;
import simpletimeapi.Time;
import simpletimeimpl.APDuration;
import simpletimeimpl.APTime;
//TODO adapt imports if required

/**
 * Abstract factory to separate student implementations from teachers tests. The
 * instance created by this factory will be black-box tested by the teachers
 * tests.
 *
 * Richard van den Ham {@code r.vandenham@fontys.nl} Pieter van den Hombergh
 * {@code p.vandenhombergh@fontys.nl}
 */
public class APFactory implements AbstractAPFactory {

    /**
     * Required for service loader.
     */
    public APFactory() {
    }

    /**
     * Factory method to create an object of type Time.
     *
     * @param hours the number of hours
     * @param minutes the number of minutes, might be negative.
     * @return Time object
     */
    @Override
    public Time createTime(int hours, int minutes) {
        System.out.println("create TIme-> hours " + hours + " minutes " + minutes);
        //TODO
//        Time t = new APTime().addTime((hours * 60) + minutes);
        Time t = new APTime((hours * 60) + minutes);

        //check if hours and minutes are empty
        return t;
    }

    /**
     * Factory method to create an object of type Duration. The Duration
     * implementation should have a constructor with two arguments: hours and
     * minutes.
     *
     * @param hours hours part of the duration.
     * @param minutes minutes part of the duration.
     * @return Duration object.
     */
    @Override
    public Duration createDuration(int hours, int minutes) {
        //TODO
//        System.out.println("create duration-> hours " + hours + " minutes " + minutes);
        return new APDuration(hours, minutes);
    }

    /**
     * Factory method to create an object of type Duration.
     *
     * @param lengthInMinutes e.g. 105 minutes
     * @return Duration object.
     */
    @Override
    public Duration createDuration(int lengthInMinutes) {
        //TODO
        //System.out.println("create duration->  minutes " + lengthInMinutes);
        return new APDuration(lengthInMinutes);
    }

}
