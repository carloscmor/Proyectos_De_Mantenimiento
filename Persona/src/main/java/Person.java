import java.util.List;

/**
 * @author Carlos CM
 * Clase que representa a una persona.
 */
public class Person {
    public static final String male = "Male", female = "Female"; //Gender strings.
    private final String name, gender;
    private final int age;

    /**
     * Constructor de la clase.
     * @param name -> nombre de la persona.
     * @param age -> edad de la persona (trivialmente positiva).
     * @param gender -> género de la persona (Male o Female).
     */
    public Person(String name, int age, String gender) {
        if(name == null || name == "") throw new IllegalArgumentException("Null name");
        if(age < 0) throw new IllegalArgumentException("Negative age");
        if(!gender.equals(male) && !gender.equals(female)) throw new IllegalArgumentException("Invalid gender");
            this.name = name;
            this.age = age;
            this.gender = gender;
    }

    /**
     * Improved constructor, for a better valid gender control.
     * @param name
     * @param age
     * @param isMale
     */
    public Person(String name, int age, boolean isMale) {
        this(name, age, (isMale)? male : female);
    }

    public String name() { return name; }
    public int age() { return age; }
    public String gender() { return gender; }

    /**
     *
     * @param persons
     * @return array of averages (index 0 refers to men, while 1 refers to women)
     */
    public static double[] averageAgePerGender(List<Person> persons){
        double[] res = new double[2]; //consider index 0 Male average and index 1 Female average.
            if(persons != null && !persons.isEmpty()){
                int maleCount = 0, femaleCount = 0;
                for (Person p : persons) {
                    if (p.gender.equals(male)) {
                        res[0] += p.age; maleCount++;
                    } else {
                        res[1] += p.age; femaleCount++;
                    }
                }
                res[0] = res[0] / (double) maleCount;
                res[1] = res[1] / (double) femaleCount;
            }
        return res;
    }
}
