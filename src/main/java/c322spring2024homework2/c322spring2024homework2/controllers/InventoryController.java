package c322spring2024homework2.c322spring2024homework2.controllers;

import c322spring2024homework2.c322spring2024homework2.model.Builder;
import c322spring2024homework2.c322spring2024homework2.model.Guitar;
import c322spring2024homework2.c322spring2024homework2.model.Type;
import c322spring2024homework2.c322spring2024homework2.model.Wood;
import c322spring2024homework2.c322spring2024homework2.repository.InventoryRepository;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

//...
public class InventoryController{

    @GetMapping("/search")
    public List<Guitar> search(@RequestParam String serialNumber,
                               @RequestParam Double price,
                               @RequestParam String builder,
                               @RequestParam String model,
                               @RequestParam String type,
                               @RequestParam String backWood,
                               @RequestParam String topWood){
        try {
            return InventoryRepository.find(serialNumber, price, builder, model, type, backWood, topWood);
        } catch(IOException e){
            return null;
        }
    }


    @PostMapping
    public boolean add(@RequestBody Guitar data){
        try{
            return InventoryRepository.add(data);
        } catch (IOException e){
            return false;
        }
    }

    @GetMapping("/find")
    public Guitar getGuitar(@RequestParam String serialNumber) {
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

}