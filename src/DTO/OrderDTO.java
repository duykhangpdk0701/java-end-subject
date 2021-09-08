package DTO;

public class OrderDTO {
    private int id;
    private int userId;
    private String date;
    private float total;
    private String note;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "OrderDAL{" +
                "id=" + id +
                ", userId=" + userId +
                ", date='" + date + '\'' +
                ", total=" + total +
                ", note='" + note + '\'' +
                '}';
    }
}
