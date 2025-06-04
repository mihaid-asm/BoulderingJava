package utility;

import classes.*;

import java.util.ArrayList;
import java.util.List;

public class ServInstructor {
    private static List<Instructor> instructors = new ArrayList<>();

    public static Instructor hireInstructor(int id, String name, Zone zone) {
        Instructor instructor = new Instructor(id, name, zone);
        instructors.add(instructor);
        System.out.println("Instructor '" + name + "' hired.");
        Logs.log("Instructor '" + name + "' hired.");
        return instructor;
    }

    public static Instructor getInstructorByName(String name) {
        for (Instructor instructor : instructors) {
            if (instructor.getName().equals(name)) return instructor;
        }
        return null;
    }

    public static List<Instructor> getInstructors() {
        return instructors;
    }
}