package com.github._2jan222;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Janik Mayr on 10.10.2018
 */
public class ParkingSpot {
    private static AtomicLong atomicID = new AtomicLong(0);
    private final long id = atomicID.getAndIncrement();
    private boolean occupied;

    public ParkingSpot(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public long getId() {
        return id;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
