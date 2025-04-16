package Classes;

import java.util.Objects;

public class Badge {
    private String name;
    private String description;

    public Badge(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Badge badge = (Badge) o;
        return Objects.equals(name, badge.name) && Objects.equals(description, badge.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public String toString() {
        return "badge{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
