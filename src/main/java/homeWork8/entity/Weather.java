package homeWork8.entity;

public class Weather {
    private String city;
    private String localDate;
    private double temperature;
    private double feelsLike;
    private String condition;
    private double windSpeed;
    private Integer pressureMm;

    public Weather(String city, String localDate, double temperature, double feelsLike,
                   String condition, double windSpeed, Integer pressureMm) {
        this.city = city;
        this.localDate = localDate;
        this.temperature = temperature;
        this.feelsLike = feelsLike;
        this.condition = condition;
        this.windSpeed = windSpeed;
        this.pressureMm = pressureMm;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getPressureMm() {
        return pressureMm;
    }

    public void setPressureMm(Integer pressureMm) {
        this.pressureMm = pressureMm;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", localDate='" + localDate + '\'' +
                ", temperature=" + temperature +
                ", feelsLike=" + feelsLike +
                ", condition='" + condition + '\'' +
                ", windSpeed=" + windSpeed +
                ", pressureMm=" + pressureMm +
                '}';
    }
}
