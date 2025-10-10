public class Package {
    private int id;
    private double weightKg;
    private String desc;

    public Package(int id, double weightKg, String desc) {
        this.id = id;
        this.weightKg = weightKg;
        this.desc = desc;
    }
    public boolean isHeavy(){
        return (weightKg >= 10.0);
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", weightKg=" + weightKg +
                ", desc='" + desc + '\'' +
                '}';
    }
}
