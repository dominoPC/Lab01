import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product testProduct;
    @BeforeEach
    void setUp() {
        testProduct = new Product("000001","Skub","Take it or leave it",20);
    }

    @Test
    void setID() {
        testProduct.setID("000002");
        assertEquals("000002",testProduct.getID());
    }

    @Test
    void setName() {
        testProduct.setName("Breakfast Cap");
        assertEquals("Breakfast Cap",testProduct.getName());
    }

    @Test
    void setDescription() {
        testProduct.setDescription("Every family in America should own at least a half a dozen of these fine products");
        assertEquals("Every family in America should own at least a half a dozen of these fine products",
                testProduct.getDescription());
    }

    @Test
    void setCost() {
        testProduct.setCost(50.55);
        assertEquals(50.55,testProduct.getCost());
    }

    @Test
    void toCSVDataRecord() {
        assertEquals("000001,Skub,Take it or leave it,20.0",testProduct.toCSVDataRecord());
    }

    @Test
    void testToString() {
        assertEquals("Product{ID='000001', name='Skub', description='Take it or leave it', cost=20.0}",testProduct.toString());
    }
}