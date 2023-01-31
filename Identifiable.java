import java.util.UUID;

public class Identifiable {
    private long id;

    public Identifiable() {
        id = UUID.randomUUID().getMostSignificantBits();
        // System.out.println(id);
    }

    public long getID() {
        return id;
    }

}
