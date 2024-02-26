package entity;

/**
 * @Author：真IKUN
 * @Package：Service
 * @Project：TicketManagementSystem
 * @name：Shift
 * @Date：2023/6/16 14:09
 * @Filename：Shift
 */
public class Shift {
    private String date;
    private String shift;
    private String time;
    private String startPosition;
    private String endPosition;
    private String duration;
    private String titleNum;

    public Shift() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(String startPosition) {
        this.startPosition = startPosition;
    }

    public String getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(String endPosition) {
        this.endPosition = endPosition;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTitleNum() {
        return titleNum;
    }

    public void setTitleNum(String titleNum) {
        this.titleNum = titleNum;
    }

    @Override
    public String toString() {
        return "Shift{" +
                "date='" + date + '\'' +
                ", shift='" + shift + '\'' +
                ", time='" + time + '\'' +
                ", startPosition='" + startPosition + '\'' +
                ", endPosition='" + endPosition + '\'' +
                ", duration='" + duration + '\'' +
                ", titleNum='" + titleNum + '\'' +
                '}';
    }
}
