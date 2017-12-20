package converter.tests;

import converter.ElbonianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the ElbonianArabicConverter class.
 */
public class ConverterTests {

    @Test
    public void ElbonianToArabicSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertEquals(converter.toElbonian(), "I");
    }

    @Test
    public void ArabicToElbonianSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("TEST");
    }

    @Test
    public void AtoETest1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("945");
        assertEquals(converter.toElbonian(), "DemV");
    }

    @Test
    public void MalformedNumberTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        try{
            ElbonianArabicConverter converter = new ElbonianArabicConverter("XXXX");
            //assertEquals(converter.toElbonian(), "40");
            converter.toElbonian();
        } catch (MalformedNumberException e) {
            System.err.println("MalformedNumberException: " + e.getMessage());
        }
    }
    @Test
    public void AtoETest2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("930");
        assertEquals(converter.toElbonian(), "DeXXX");
    }
    @Test
    public void MalformedNumberTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        try{
            ElbonianArabicConverter converter = new ElbonianArabicConverter("CCCCXXX");
            //assertEquals(converter.toElbonian(), "40");
            converter.toElbonian();
        } catch (MalformedNumberException e) {
            System.err.println("MalformedNumberException: " + e.getMessage());
        }
    }
    @Test
    public void ValueOutofBoundsTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        try{
            ElbonianArabicConverter converter = new ElbonianArabicConverter("4001");
            //assertEquals(converter.toElbonian(), "40");
            converter.toElbonian();
        } catch (ValueOutOfBoundsException e) {
            System.err.println("ValueOutOfBoundsException: " + e.getMessage());
        }
    }
    @Test
    public void ValueOutofBoundsTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        try{
            ElbonianArabicConverter converter = new ElbonianArabicConverter("-1");
            //assertEquals(converter.toElbonian(), "40");
            converter.toElbonian();
        } catch (ValueOutOfBoundsException e) {
            System.err.println("ValueOutOfBoundsException: " + e.getMessage());
        }
    }

    @Test
    public void AtoETest3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("3000");
        assertEquals(converter.toElbonian(), "MMM");
    }
    @Test
    public void AtoETest4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1600");
        assertEquals(converter.toElbonian(), "MDC");
    }
    @Test
    public void MalformedNumberTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        try{
            ElbonianArabicConverter converter = new ElbonianArabicConverter("0");
            assertEquals(converter.toElbonian(), "40");
        } catch (MalformedNumberException e) {
            System.err.println("MalformedNumberException: " + e.getMessage());
        }
    }
    @Test
    public void MalformedNumberTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        try{
            ElbonianArabicConverter converter = new ElbonianArabicConverter("LLm");
            assertEquals(converter.toArabic(), 4000);
        } catch (MalformedNumberException e) {
            System.err.println("MalformedNumberException: " + e.getMessage());
        }
    }

    @Test
    public void TestRepeated() throws MalformedNumberException, ValueOutOfBoundsException {
        String string = "VV";
        ElbonianArabicConverter e = new ElbonianArabicConverter("1000");
        assertEquals(e.checkRepeated(string), false);
    }
    @Test
    public void ValueOutofBoundsTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        try {
            ElbonianArabicConverter e = new ElbonianArabicConverter("4000");
            assertEquals(e.toArabic(), "MMMM");
        } catch(ValueOutOfBoundsException e){
            System.err.println("ValueOutOfBoundsException: " + e.getMessage());
        }
    }
    @Test
    public void MalformedNumberTest5() throws MalformedNumberException, ValueOutOfBoundsException {
        try{
            ElbonianArabicConverter converter = new ElbonianArabicConverter("0");
            assertEquals(converter.toArabic(), 0);
        } catch (MalformedNumberException e) {
            System.err.println("MalformedNumberException: " + e.getMessage());
        }
    }

    @Test
    public void MalformedNumberTest6() throws MalformedNumberException, ValueOutOfBoundsException {
        try{
            ElbonianArabicConverter converter = new ElbonianArabicConverter("MMMM");
            assertEquals(converter.toArabic(), 4000);
        } catch (MalformedNumberException e) {
            System.err.println("MalformedNumberException: " + e.getMessage());
        }
    }
    @Test
    public void MalformedNumberTest7() throws MalformedNumberException, ValueOutOfBoundsException {
        try{
            ElbonianArabicConverter converter = new ElbonianArabicConverter("XXXX");
            assertEquals(converter.toArabic(), 0);
        } catch (MalformedNumberException e) {
            System.err.println("MalformedNumberException: " + e.getMessage());
        }
    }
    @Test
    public void MalformedNumberTest8() throws MalformedNumberException, ValueOutOfBoundsException {
        try{
            ElbonianArabicConverter converter = new ElbonianArabicConverter("CCCC");
            assertEquals(converter.toArabic(), 0);
        } catch (MalformedNumberException e) {
            System.err.println("MalformedNumberException: " + e.getMessage());
        }
    }
    @Test
    public void MalformedNumberTest9() throws MalformedNumberException, ValueOutOfBoundsException {
        try{
            ElbonianArabicConverter converter = new ElbonianArabicConverter("CCCC");
            assertEquals(converter.toArabic(), 0);
        } catch (MalformedNumberException e) {
            System.err.println("MalformedNumberException: " + e.getMessage());
        }
    }
    @Test
    public void MalformedNumberTest10() throws MalformedNumberException, ValueOutOfBoundsException {
        try{
            ElbonianArabicConverter converter = new ElbonianArabicConverter("IIII");
            assertEquals(converter.toArabic(), 0);
        } catch (MalformedNumberException e) {
            System.err.println("MalformedNumberException: " + e.getMessage());
        }
    }
    @Test
    public void MalformedNumberTest11() throws MalformedNumberException, ValueOutOfBoundsException {
        try{
            ElbonianArabicConverter converter = new ElbonianArabicConverter("LL");
            assertEquals(converter.toArabic(), 0);
        } catch (MalformedNumberException e) {
            System.err.println("MalformedNumberException: " + e.getMessage());
        }
    }
    @Test
    public void MalformedNumberTest12() throws MalformedNumberException, ValueOutOfBoundsException {
        try{
            ElbonianArabicConverter converter = new ElbonianArabicConverter("mm");
            assertEquals(converter.toArabic(), 0);
        } catch (MalformedNumberException e) {
            System.err.println("MalformedNumberException: " + e.getMessage());
        }
    }
    @Test
    public void MalformedNumberTest13() throws MalformedNumberException, ValueOutOfBoundsException {
        try{
            ElbonianArabicConverter converter = new ElbonianArabicConverter("LLm");
            assertEquals(converter.toArabic(), 0);
        } catch (MalformedNumberException e) {
            System.err.println("MalformedNumberException: " + e.getMessage());
        }
    }
    @Test
    public void MalformedNumberTest14() throws MalformedNumberException, ValueOutOfBoundsException {
        try{
            ElbonianArabicConverter converter = new ElbonianArabicConverter("VV");
            assertEquals(converter.toArabic(), 10);
        } catch (MalformedNumberException e) {
            System.err.println("MalformedNumberException: " + e.getMessage());
        }
    }
    @Test
    public void MalformedNumberTest15() throws MalformedNumberException, ValueOutOfBoundsException {
        try{
            ElbonianArabicConverter converter = new ElbonianArabicConverter("");
            assertEquals(converter.toArabic(), 1);
        } catch (MalformedNumberException e) {
            System.err.println("MalformedNumberException: " + e.getMessage());
        }
    }
    @Test
    public void ValueOutofBoundsTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        try{
            ElbonianArabicConverter converter = new ElbonianArabicConverter("9000");
            assertEquals(converter.toArabic(), 0);
        } catch (ValueOutOfBoundsException e) {
            System.err.println("ValueOutOfBoundsException: " + e.getMessage());
        }
    }
    @Test
    public void MalformedNumberTest16() throws MalformedNumberException, ValueOutOfBoundsException {
        try{
            ElbonianArabicConverter converter = new ElbonianArabicConverter("DDVwI");
            assertEquals(converter.toArabic(), 1);
        } catch (MalformedNumberException e) {
            System.err.println("MalformedNumberException: " + e.getMessage());
        }
    }
}
