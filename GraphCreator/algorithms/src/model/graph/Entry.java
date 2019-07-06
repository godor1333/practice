package model.graph;

import java.util.Objects;

public class Entry implements Comparable<Entry> {
    private double  key;
    private int value;

    public Entry(Double key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Entry(Integer value) {
        this.value = value;
    }

    public Double getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public int compareTo(Entry other) {
        return this.getKey().compareTo(other.getKey());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(value, entry.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
