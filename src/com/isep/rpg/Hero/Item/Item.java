package Items;

//------CLASSE ITEM------

public abstract class Item {
    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private String name;
}
