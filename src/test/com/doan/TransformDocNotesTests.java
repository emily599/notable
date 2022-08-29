package test.com.doan;

import main.com.doan.TransformDocNotes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TransformDocNotesTests {

    @Test
    public void testValidTranscribedText(){
        assertEquals(TransformDocNotes.transformDocNotes("Patient presents today with several issues. Number one BMI has increased by 10% since their last visit. Number next patient reports experiencing dizziness several times in the last two weeks. Number next patient has a persistent cough that hasn’t improved for last 4 weeks."), "Patient presents today with several issues. \n" +
                "1. BMI has increased by 10% since their last visit.\n" +
                "2. Patient reports experiencing dizziness several times in the last two weeks.\n" +
                "3. Patient has a persistent cough that hasn’t improved for last 4 weeks.");

    }

    @Test
    public void testStartNotOnOne(){
        assertEquals(TransformDocNotes.transformDocNotes("Patient presents today with several issues. Number four BMI has increased by 10% since their last visit. Number next patient reports experiencing dizziness several times in the last two weeks. Number next patient has a persistent cough that hasn’t improved for last 4 weeks."), "Patient presents today with several issues. \n" +
                "4. BMI has increased by 10% since their last visit.\n" +
                "5. Patient reports experiencing dizziness several times in the last two weeks.\n" +
                "6. Patient has a persistent cough that hasn’t improved for last 4 weeks.");

    }

    @Test
    public void testEmptyString() {
        assertEquals(TransformDocNotes.transformDocNotes(""), "");
    }

    @Test
    public void testNoNumberNext() {
        assertEquals(TransformDocNotes.transformDocNotes("Patient presents today with several issues. Number one BMI has increased by 10% since their last visit."), "Patient presents today with several issues. \n" +
                "1. BMI has increased by 10% since their last visit.");
    }

}
