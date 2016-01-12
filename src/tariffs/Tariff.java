package tariffs;

public class Tariff {
    private int id;
    private String name;
    private String description;
    private int minutePrice;
    private int monthPrice;

    static public Tariff newInstance(String name, String description, String strMinutePrice, String strMonthPrice) {
        return newInstance(0, name, description, strMinutePrice, strMonthPrice);
    }

    static public Tariff newInstance(int id, String name, String description, String strMinutePrice, String strMonthPrice) {
        try {
            int minutePrice = Integer.parseInt(strMinutePrice);
            int monthPrice = Integer.parseInt(strMonthPrice);
            if (id < 0 || name == null || description == null || minutePrice < 0 || monthPrice < 0) {
                return null;
            } else {
                return new Tariff(id, name, description, minutePrice, monthPrice);
            }
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Tariff(int id, String name, String description, int minutePrice, int monthPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.minutePrice = minutePrice;
        this.monthPrice = monthPrice;
    }

    public Tariff(String name, String description, int minutePrice, int monthPrice) {
        this.id = 0;
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
