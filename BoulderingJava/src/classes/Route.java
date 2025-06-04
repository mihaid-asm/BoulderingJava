package classes;

import interfaces.Persistence;
import utility.Pair;
import enums.difficultyCategory;
import java.util.Vector;

public class Route implements Persistence {
    private int id;
    private String name;
    private double difficulty;
    private Zone zone;
    private difficultyCategory tier;

    public Route(int id, String name, Double difficulty, Zone zone) {
        this.id = id;
        this.name = name;
        this.difficulty = difficulty;
        this.zone = zone;
        switch((int) Math.floor(difficulty)) {
            case 0 -> tier = difficultyCategory.TRIVIAL;
            case 1 -> tier = difficultyCategory.EASY;
            case 2 -> tier = difficultyCategory.MEDIUM;
            case 3 -> tier = difficultyCategory.HARD;
            case 4 -> tier = difficultyCategory.EXPERT;
            case 5 -> tier = difficultyCategory.INSANE;
            default -> tier = difficultyCategory.INVALID;
        }
    }

    public Route() {

    }

    public Route(int rid, String rname) {
        this.id = rid;
        this.name = rname;
    }

    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public Double getDifficulty() {
        return difficulty;
    }

    public Zone getZone() {
        return zone;
    }

    @Override
    public String toString() {
        return "BoulderingRoute{" +
                "name='" + name + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", tier=" + tier +
                ", zone=" + zone.getName() +
                '}';
    }

    @Override
    public String tableName() {
        return "Routes";
    }

    @Override
    public Vector<Pair<String, String>> tableColumns() {
        Vector<Pair<String, String>> cols = new Vector<>();
        cols.add(new Pair<>("name", "VARCHAR(100)"));
        return cols;
    }

    @Override
    public Vector<String> tableValues() {
        Vector<String> values = new Vector<>();
        values.add(name);
        return values;
    }

    @Override
    public int pk() {
        return id;
    }
}
