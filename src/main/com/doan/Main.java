package main.com.doan;



public class Main {
    public static void main(String[] args) {
        String transcribedText = "Patient presents today with several issues. Number one BMI has increased by 10% since their last visit. Number next patient reports experiencing dizziness several times in the last two weeks. Number next patient has a persistent cough that hasn’t improved for last 4 weeks.";

        System.out.println(TransformDocNotes.transformDocNotes(transcribedText));
    }
}
