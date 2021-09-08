package DTO;

public class CartDTO {
    private int value;
    private int occur;

    public CartDTO(int value, int occur) {
        this.value = value;
        this.occur = occur;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getOccur() {
        return occur;
    }

    public void setOccur(int occur) {
        this.occur = occur;
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "value=" + value +
                ", occur=" + occur +
                '}';
    }
}
