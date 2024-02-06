package c322spring2024homework2.c322spring2024homework2.repository;

import c322spring2024homework2.c322spring2024homework2.model.Builder;
import c322spring2024homework2.c322spring2024homework2.model.Guitar;
import c322spring2024homework2.c322spring2024homework2.model.Type;
import c322spring2024homework2.c322spring2024homework2.model.Wood;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public class InventoryRepository {
    public void addGuitar(String serialNum, double price, Builder builder, String model, Type type, Wood backWood, Wood topWood) {
        try {
            Guitar g = new Guitar(serialNum, price, builder, model, type, backWood, topWood);

            FileWriter w = new FileWriter("guitars_database.txt", true);


            String guitarInfo = String.format("%s,%.2f,%s,%s,%s,%s,%s\n",
                    g.getSerialNumber(), g.getPrice(), g.getBuilder(),
                    g.getModel(), g.getType(), g.getBackWood(), g.getTopWood());

            w.write(guitarInfo);

            w.close();


            System.out.println("Guitar added to database");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void appendToFile(Path path, String content) throws IOException {
        Files.write(path,
                content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    public static boolean add(Guitar guitar) throws IOException{

        Path path = Paths.get("guitars_database.txt");
        String data = guitar.getSerialNumber() + "," + guitar.getPrice() + ","
                + guitar.getBuilder() + "," + guitar.getModel() + ","
                + guitar.getType() + "," + guitar.getBackWood() + "," + guitar.getTopWood();
        System.out.println(data);
        appendToFile(path, data);
        return true;

    }



    public Guitar getGuitar(String serialNumber) {
        try (FileReader r = new FileReader("guitars_database.txt");
             BufferedReader bufferedReader = new BufferedReader(r)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] guitarData = line.split(",");
                if (guitarData.length == 7 && guitarData[0].equals(serialNumber)) {
                    try {
                        Guitar guitar = new Guitar(guitarData[0], Double.parseDouble(guitarData[1]),
                                Builder.valueOf(guitarData[2].toUpperCase().replace(" ", "_")),
                                guitarData[3], Type.valueOf(guitarData[4].toUpperCase().replace(" ", "_")),
                                Wood.valueOf(guitarData[5].toUpperCase().replace(" ", "_")),
                                Wood.valueOf(guitarData[6].toUpperCase().replace(" ", "_")));
                        return guitar;
                    } catch (IllegalArgumentException e) {
                        System.err.println("Error parsing data: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return null;
    }






    public Guitar search(Guitar guitarToFind) {
        try {
            FileReader r = new FileReader("guitars_database.txt");
            BufferedReader bufferedReader = new BufferedReader(r);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] guitarData = line.split(",");
                if (guitarData.length != 7) {
                    System.out.println("No guitar found");
                    continue;
                }

                Guitar g = new Guitar(guitarData[0], Double.parseDouble(guitarData[1]), Builder.valueOf(guitarData[2]),
                        guitarData[3], Type.valueOf(guitarData[4]), Wood.valueOf(guitarData[5]), Wood.valueOf(guitarData[6]));

                if (g.getSerialNumber().equals(guitarToFind.getSerialNumber()) &&
                        g.getBuilder().equals(guitarToFind.getBuilder()) &&
                        g.getModel().equals(guitarToFind.getModel()) &&
                        g.getType().equals(guitarToFind.getType()) &&
                        g.getBackWood().equals(guitarToFind.getBackWood()) &&
                        g.getTopWood().equals(guitarToFind.getTopWood())) {
                    return g;
                }
            }

            bufferedReader.close();
            r.close();

            System.out.println("No guitar found");
            return null;
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
    }
//public Guitar search(String serialNumber) {
//    try (FileReader r = new FileReader("guitars_database.txt");
//         BufferedReader bufferedReader = new BufferedReader(r)) {
//
//        String line;
//        while ((line = bufferedReader.readLine()) != null) {
//            String[] guitarData = line.split(",");
//            if (guitarData.length == 7 && guitarData[0].equals(serialNumber)) {
//                try {
//                    Guitar guitar = new Guitar(guitarData[0], Double.parseDouble(guitarData[1]),
//                            Builder.valueOf(guitarData[2].toUpperCase().replace(" ", "_")),
//                            guitarData[3], Type.valueOf(guitarData[4].toUpperCase().replace(" ", "_")),
//                            Wood.valueOf(guitarData[5].toUpperCase().replace(" ", "_")),
//                            Wood.valueOf(guitarData[6].toUpperCase().replace(" ", "_")));
//                    return guitar;
//                } catch (IllegalArgumentException e) {
//                    System.err.println("Error parsing data: " + e.getMessage());
//                }
//            }
//        }
//    } catch (IOException e) {
//        System.err.println("Error reading file: " + e.getMessage());
//    }
//
//    return null; // Guitar with the given serial number not found
//}


    public static List<Guitar> find(String serialNumber, Double price, String builder, String model, String type, String backWood, String topWood) throws IOException {
        Path path = Paths.get("guitars_database.txt");
        List<Guitar> result = new ArrayList<>();
        List<String> data = Files.readAllLines(path);

        for (String line : data) {
            String[] words = line.split(",");
            String sn = words[0];
            Double pr = Double.parseDouble(words[1]);
            String b = words[2];
            String m = words[3];
            String t = words[4];
            String bw = words[5];
            String tw = words[6];

            if (serialNumber.equals(sn) && price.equals(pr)
                    && builder.equals(b) && model.equals(m)
                    && type.equals(t) && backWood.equals(bw)
                    && topWood.equals(tw)) {
                Guitar guitar = new Guitar(sn, pr, Builder.valueOf(b), m, Type.valueOf(t), Wood.valueOf(bw), Wood.valueOf(tw));
                result.add(guitar);
            }
        }
        return result;
    }



}