package c322spring2024homework2.c322spring2024homework2.repository;


import c322spring2024homework2.c322spring2024homework2.model.Builder;
import c322spring2024homework2.c322spring2024homework2.model.Guitar;
import c322spring2024homework2.c322spring2024homework2.model.Type;
import c322spring2024homework2.c322spring2024homework2.model.Wood;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest{

        @Test
void addGuitar() {
    // Create an InventoryRepository
    InventoryRepository i = new InventoryRepository();

    // Create a Guitar object
    Guitar g1 = new Guitar("007", 500.0, Builder.FENDER, "Dreadnought", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK);

    // Add the guitar to the inventory
    i.addGuitar(g1.getSerialNumber(), g1.getPrice(), g1.getBuilder(), g1.getModel(), g1.getType(), g1.getBackWood(), g1.getTopWood());

    // Now, you can assert that the guitar has been added to the inventory
    Guitar addedGuitar = i.getGuitar(g1.getSerialNumber());
    assertNotNull(addedGuitar); // Check if the added guitar is not null

    // You can also check other properties to ensure they match the original guitar
    assertEquals(g1.getSerialNumber(), addedGuitar.getSerialNumber());
    assertEquals(g1.getPrice(), addedGuitar.getPrice(), 0.001); // You might need to adjust the delta value for double comparisons
    assertEquals(g1.getBuilder(), addedGuitar.getBuilder());
    assertEquals(g1.getModel(), addedGuitar.getModel());
    assertEquals(g1.getType(), addedGuitar.getType());
    assertEquals(g1.getBackWood(), addedGuitar.getBackWood());
    assertEquals(g1.getTopWood(), addedGuitar.getTopWood());
}







    @Test
    void getGuitar() {
        // Create an InventoryRepository
        InventoryRepository i = new InventoryRepository();

        // Create a Guitar object
        Guitar g1 = new Guitar("007", 500.0, Builder.FENDER, "Dreadnought", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK);

        // Add the guitar to the inventory

        i.addGuitar(g1.getSerialNumber(), g1.getPrice(), g1.getBuilder(), g1.getModel(), g1.getType(), g1.getBackWood(), g1.getTopWood());

        // Retrieve the added guitar from the inventory using getGuitar
        Guitar retrievedGuitar = i.getGuitar(g1.getSerialNumber());
        System.out.println(g1);

        // Assert that the retrieved guitar is not null
        assertNotNull(retrievedGuitar);

        // Check that the properties of the retrieved guitar match the original guitar
        assertEquals(g1.getSerialNumber(), retrievedGuitar.getSerialNumber());
        assertEquals(g1.getPrice(), retrievedGuitar.getPrice(), 0.001); // You might need to adjust the delta value for double comparisons
        assertEquals(g1.getBuilder(), retrievedGuitar.getBuilder());
        assertEquals(g1.getModel(), retrievedGuitar.getModel());
        assertEquals(g1.getType(), retrievedGuitar.getType());
        assertEquals(g1.getBackWood(), retrievedGuitar.getBackWood());
        assertEquals(g1.getTopWood(), retrievedGuitar.getTopWood());
    }

    @Test
    public void testSearch() {
        // Create a sample guitar to find
        Guitar guitarToFind = new Guitar("007", 500.0, Builder.FENDER, "Dreadnought", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK);

        // Create an instance of the class containing the search method
        InventoryRepository guitarSearch = new InventoryRepository();

        // Call the search method and get the result
        Guitar foundGuitar = guitarSearch.search(guitarToFind);

        // Assert that the found guitar is not null

        assertNotNull(foundGuitar);

        // Assert that the found guitar matches the guitar we were looking for
        assertEquals(guitarToFind, foundGuitar);

    }












}