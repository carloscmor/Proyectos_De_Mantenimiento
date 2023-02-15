import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void nullNameCausesException(){
        assertThrows(IllegalArgumentException.class, ()->new Person(null, 0, true));
        assertThrows(IllegalArgumentException.class, ()->new Person(null, 10, false));
    }

    @Test
    public void emptyNameCausesException(){
        assertThrows(IllegalArgumentException.class, ()->new Person("", 0, true));
        assertThrows(IllegalArgumentException.class, ()->new Person("", 11, false));
    }

    @Test
    public void negativeAgeCausesException(){
        assertThrows(IllegalArgumentException.class, ()->new Person("a", -1, true));
        assertThrows(IllegalArgumentException.class, ()->new Person("b", -20, false));
    }

    @Test
    public void invalidGenderCausesException(){
        assertThrows(IllegalArgumentException.class, ()->new Person("a", 1, "hola"));
    }

    @Test
    public void emptyListImpliesArrayWithTwoZeros(){
        double [] averages = Person.averageAgePerGender(new ArrayList<Person>());
        assertEquals(0.0, averages[0]);
        assertEquals(0.0, averages[1]);
    }

    @Test
    public void nullListImpliesArrayWithTwoZeros(){
        double [] averages = Person.averageAgePerGender(null);
        assertEquals(0.0, averages[0]);
        assertEquals(0.0, averages[1]);
    }

    @Test
    public void ListOfOneMaleAndOneFemale_ReturnsArrayOfTheirAges(){
        List<Person> l = new ArrayList<>();
        Person h = new Person("H", 20, true); l.add(h);
        Person m = new Person("M", 22, false); l.add(m);

        double [] averages = Person.averageAgePerGender(l);
        assertEquals(h.age(), averages[0]);
        assertEquals(m.age(), averages[1]);
    }

    public void rightAverageValue(){
        int[] mAges = {10, 5, 20, 15}; double mAverage = 13; //rounded values of averages.
        int[] wAges = {5, 70, 20}; double wAverage = 32;

        List<Person> l = new ArrayList<>();
        for (Integer i : mAges) {
            l.add(new Person("name", i, true));
        }
        for (Integer i : wAges) {
            l.add(new Person("name", i, false));
        }

        double [] averages = Person.averageAgePerGender(l);
        assertEquals(mAverage, averages[0]);
        assertEquals(wAverage, averages[1]);
    }
}
