package shopilingus;

public class Location {

    private int floor;
    private int box;

    public Location(int floor, int box) {
        this.floor = floor;
        this.box = box;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getBox() {
        return box;
    }

    public void setBox(int box) {
        this.box = box;
    }
}
