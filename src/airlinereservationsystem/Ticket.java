/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinereservationsystem;

import java.util.Date;

/**
 *
 * @author Kamos
 */
public class Ticket {
    public String ticketId;
    public Date issueDate;
    public String clientName;
    public String itinenary;
    public double ticketCost;
    public boolean student;
    public float totalDiscount;
    public int luggage;
    public float luggageWeight;

    public String getTicketId() {
        return ticketId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public String getClientName() {
        return clientName;
    }

    public String getItinenary() {
        return itinenary;
    }

    public double getTicketCost() {
        return ticketCost;
    }

    public boolean isStudent() {
        return student;
    }

    public float getTotalDiscount() {
        return totalDiscount;
    }

    public int getLuggage() {
        return luggage;
    }

    public float getLuggageWeight() {
        return luggageWeight;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setItinenary(String itinenary) {
        this.itinenary = itinenary;
    }

    public void setTicketCost(double ticketCost) {
        this.ticketCost = ticketCost;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public void setTotalDiscount(float totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public void setLuggage(int luggage) {
        this.luggage = luggage;
    }

    public void setLuggageWeight(float luggageWeight) {
        this.luggageWeight = luggageWeight;
    }
    
}
