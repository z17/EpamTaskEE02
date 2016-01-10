package tariffs;

public class Tariff {
    private int id;
    private String name;
    private String description;
    private int minutePrice;
    private int monthPrice;

    public Tariff(int id, String name, String description, int minutePrice, int monthPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.minutePrice = minutePrice;
        this.monthPrice = monthPrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getMinutePrice() {
        return minutePrice;
    }

    public int getMonthPrice() {
        return monthPrice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMinutePrice(int minutePrice) {
        this.minutePrice = minutePrice;
    }

    public void setMonthPrice(int monthPrice) {
        this.monthPrice = monthPrice;
    }
}
