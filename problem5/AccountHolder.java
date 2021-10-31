public abstract class AccountHolder{
    protected final int ID;
    protected final String address;

    public AccountHolder(int ID, String address){
        this.ID = ID;
        this.address = address;
    }

    private static int idCounter = 0;
    public static int nextID(){ return this.idCounter++; }
}
