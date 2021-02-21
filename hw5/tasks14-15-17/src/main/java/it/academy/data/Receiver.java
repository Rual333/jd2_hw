package it.academy.data;

import java.io.Serializable;
import java.util.Objects;

public class Receiver implements Serializable {
    private int num;
    private String name;

    Receiver() {
        super();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receiver receiver = (Receiver) o;
        return num == receiver.num && Objects.equals(name, receiver.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, name);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Receiver{");
        sb.append("num=").append(num);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
