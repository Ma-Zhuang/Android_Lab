package uk.ac.bham.student.starmegabucks;

public class CafeProduct {
    private String name;
    private int apiID;

    public CafeProduct(String name, int id) {
        this.name = name;
        this.apiID = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getApiID() {
        return apiID;
    }

    public void setApiID(int apiID) {
        this.apiID = apiID;
    }

    public String toString() {
        return this.name;
    }
}
