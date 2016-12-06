package year2015.day17;

public class Сontainer {

    private static int ID_COUNTER = 0;

    public final int id = ID_COUNTER++;

    public final int size;

    public Сontainer(int size) {
        this.size = size;
    }

    @Override
    public int hashCode() {
        return 31 + id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Сontainer other = (Сontainer) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
