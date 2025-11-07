public class JobCustom {
    private String id;

    public JobCustom(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                '}';
    }
}
