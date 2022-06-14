package reversoseleniumtest.reversotestselenium;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitReverso{
        public static void checkTranslation(String expected, String traduction){
            assertEquals(expected, traduction);
            System.out.println("traduction is: " +traduction);

        }

}