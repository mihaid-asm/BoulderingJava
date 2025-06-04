package utility;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.javatuples.Pair;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Vector;

public class Logs {

    private static Vector<Pair<String, String>> logs = new Vector<>();

    public static void log(String msg) {
        logs.add(new Pair<>(msg, new Date().toString()));
    }

    public static void save_logs() throws IOException {
        String[] HEADERS = {"operation", "datetime"};

        FileWriter out = new FileWriter("audit.csv");

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(HEADERS)
                .build();

        try (final CSVPrinter printer = new CSVPrinter(out, csvFormat)) {
            logs.forEach((log) -> {
                try {
                    printer.printRecord(log.getValue0(), log.getValue1());
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            });
        }
    }
}