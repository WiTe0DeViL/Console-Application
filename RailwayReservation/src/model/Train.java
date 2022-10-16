package model;

import java.util.Date;

public class Train {
    private String trainCode;
    private Date date;
    private String departFrom;

    private String departTo;

    private int seat;
    private int compartment;

    public String getDepartFrom() {
        return departFrom;
    }

    public Train(String trainCode, Date date, String departFrom, String departTo, int seat, int compartment) {
        this.trainCode = trainCode;
        this.date = date;
        this.departFrom = departFrom;
        this.departTo = departTo;
        this.seat = seat;
        this.compartment = compartment;
    }

    public void setDepartFrom(String departFrom) {
        this.departFrom = departFrom;
    }

    public String getDepartTo() {
        return departTo;
    }

    public void setDepartTo(String departTo) {
        this.departTo = departTo;
    }

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getCompartment() {
        return compartment;
    }

    public void setCompartment(int compartment) {
        this.compartment = compartment;
    }
}
