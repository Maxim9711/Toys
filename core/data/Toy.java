package core.data;

import java.util.Objects;

public class Toy implements Comparable<Toy> {
    private int id;
    private short chanceFalling;
    private Integer quantity;
    private String name;


    public Toy(int id, short chanceFalling, Integer quantity, String name) {
        this.id = id;
        this.chanceFalling = chanceFalling;
        this.quantity = quantity;
        this.name = name;
    }

    public Toy() {
    }

    public int getId() {
        return id;
    }

    public short getChanceFalling() {
        return chanceFalling;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public void setToy(Toy toy) {
        this.id = toy.getId();
        this.chanceFalling = toy.getChanceFalling();
        this.quantity = toy.getQuantity();
        this.name = toy.getName();
    }

    public void decreaseQuantity() {
        this.quantity -= 1;
    }

    @Override
    public String toString() {
        return "Toy \"" + name + "\", number [" + quantity + "], probability [" + chanceFalling + "%]\n";
    }

    @Override
    public int compareTo(Toy o) {
        return Short.compare(o.chanceFalling, this.chanceFalling);
    }
}
