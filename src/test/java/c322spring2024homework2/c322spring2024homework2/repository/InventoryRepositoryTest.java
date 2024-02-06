package c322spring2024homework2.c322spring2024homework2.repository;


import c322spring2024homework2.c322spring2024homework2.model.Builder;
import c322spring2024homework2.c322spring2024homework2.model.Guitar;
import c322spring2024homework2.c322spring2024homework2.model.Type;
import c322spring2024homework2.c322spring2024homework2.model.Wood;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest{
//    @Test
//    void addGuitar() {
//        InventoryRepository i = new InventoryRepository();
////        Guitar g2 = new Guitar("100", 800.0, Builder.FENDER, "King", Type.ELECTRIC, Wood.INDIAN_ROSEWOOD, Wood.SITKA);
//
//        Guitar g1 = new Guitar("007", 500.0, Builder.FENDER, "Dreadnought", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK);
////        i.addGuitar(g1.getSerialNumber(), g1.getPrice(), g1.getBuilder(), g1.getModel(), g1.getType(), g1.getBackWood(), g1.getTopWood());
////
////        assertTrue(i.getGuitar(g1.getSerialNumber()) != null);
////
////        //Guitar g2 = new Guitar("100", 800.0, Builder.FENDER, "King", Type.ELECTRIC, Wood.INDIAN_ROSEWOOD, Wood.SITKA);
////        i.addGuitar(g2.getSerialNumber(), g2.getPrice(), g2.getBuilder(), g2.getModel(), g2.getType(), g2.getBackWood(), g2.getTopWood());
////        assertTrue(i.getGuitar(g2.getSerialNumber()) != null);
//        i.addGuitar(g1.getSerialNumber(), g1.getPrice(), g1.getBuilder(), g1.getModel(), g1.getType(), g1.getBackWood(), g1.getTopWood());
//    }
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





//    @Test
//    void getGuitar() {
//        InventoryRepository i = new InventoryRepository();
//        Guitar expectedGuitar = new Guitar("024", 100.0, Builder.FENDER, "Aero", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK);
//        Guitar retrievedGuitar = i.getGuitar(expectedGuitar.getSerialNumber());
//        //assertNotNull(retrievedGuitar);
//
//        assertEquals(expectedGuitar.getSerialNumber(), retrievedGuitar.getSerialNumber());
//        assertEquals(expectedGuitar.getPrice(), retrievedGuitar.getPrice(), 0.0);
//        assertEquals(expectedGuitar.getBuilder(), retrievedGuitar.getBuilder());
//        assertEquals(expectedGuitar.getModel(), retrievedGuitar.getModel());
//        assertEquals(expectedGuitar.getType(), retrievedGuitar.getType());
//        assertEquals(expectedGuitar.getBackWood(), retrievedGuitar.getBackWood());
//        assertEquals(expectedGuitar.getTopWood(), retrievedGuitar.getTopWood());
//
//        assertNull(i.getGuitar("123"));
//
//    }

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


//    @Test
//    void search() {
//
//        InventoryRepository i = new InventoryRepository();
//
//        Guitar g = new Guitar("007", 500.0,  Builder.FENDER, "Dreadnought", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK);
//            Guitar retrievedGuitar = i.search(g);
//        assertNotNull(retrievedGuitar);
//
//        assertEquals(g.getSerialNumber(), retrievedGuitar.getSerialNumber());
//        assertEquals(g.getPrice(), retrievedGuitar.getPrice(), 0.0);
//        assertEquals(g.getBuilder(), retrievedGuitar.getBuilder());
//        assertEquals(g.getModel(), retrievedGuitar.getModel());
//        assertEquals(g.getType(), retrievedGuitar.getType());
//        assertEquals(g.getBackWood(), retrievedGuitar.getBackWood());
//        assertEquals(g.getTopWood(), retrievedGuitar.getTopWood());
//    }

//    @Test
//    void searchBySerialNumber() {
//        // Create an InventoryRepository
//        InventoryRepository i = new InventoryRepository();
//
//        // Create a Guitar object
//        Guitar g1 = new Guitar("007", 500.0, Builder.FENDER, "Dreadnought", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK);
//
//        // Add the guitar to the inventory
//        i.addGuitar(g1.getSerialNumber(), g1.getPrice(), g1.getBuilder(), g1.getModel(), g1.getType(), g1.getBackWood(), g1.getTopWood());
//
//        // Search for the guitar by serial number
//        Guitar foundGuitar = i.search(g1.getSerialNumber());
//
//        // Assert that the found guitar is not null
//        assertNotNull(foundGuitar);
//
//        // Check that the properties of the found guitar match the original guitar
//        assertEquals(g1.getSerialNumber(), foundGuitar.getSerialNumber());
//        assertEquals(g1.getPrice(), foundGuitar.getPrice(), 0.001); // You might need to adjust the delta value for double comparisons
//        assertEquals(g1.getBuilder(), foundGuitar.getBuilder());
//        assertEquals(g1.getModel(), foundGuitar.getModel());
//        assertEquals(g1.getType(), foundGuitar.getType());
//        assertEquals(g1.getBackWood(), foundGuitar.getBackWood());
//        assertEquals(g1.getTopWood(), foundGuitar.getTopWood());
//    }


}