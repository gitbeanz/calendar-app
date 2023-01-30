import java.util.UUID;
public class Identifiable {
    private static long nextID;
    private long id;
    public Identifiable(){
        nextID = UUID.randomUUID().getMostSignificantBits();
        System.out.println(nextID);
        id = UUID.randomUUID().getMostSignificantBits();
        System.out.println(id);
    }
    public static void main(String[] args){
        Identifiable id = new Identifiable();
    }
    
    
}
