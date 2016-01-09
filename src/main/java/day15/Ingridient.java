package day15;

public class Ingridient {
    public final String name;

    public final int capacity;
    public final int durability;
    public final int flavor;
    public final int texture;
    public final int calories;

    public Ingridient(String name, int capacity, int durability, int flavor, int texture, int calories) {
        this.name = name;
        this.capacity = capacity;
        this.durability = durability;
        this.flavor = flavor;
        this.texture = texture;
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Ingridient [name=" + name + ", capacity=" + capacity + ", durability=" + durability + ", flavor="
                + flavor + ", texture=" + texture + ", calories=" + calories + "]";
    }

}