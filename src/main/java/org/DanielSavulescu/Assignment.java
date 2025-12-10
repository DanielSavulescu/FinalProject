package org.DanielSavulescu;

import java.util.List;
import java.util.Random;

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private List<Integer> scores;

    private static int nextId = 1;

    /**
     * calculates the average of all the assignments
     * @return the average of all the assignments
     */
    public double calcAssignmentAvg() {
        if (scores == null || scores.isEmpty()) {
            return 0.0;
        }

        double sum = 0;
        int count = 0;
        for (Integer score : scores) {
            sum += score;
            count++;
        }

        return sum / count;
    }

    /**
     * generates random scores for all the students in an assignment
     */
    public void generateRandomScore() {
        Random random = new Random();

        for (int i = 0; i < scores.size(); i++) {
            int randomNum = random.nextInt(11);
            int score = 0;

            if (randomNum == 0) {
                score += random.nextInt(60);
            } else if (randomNum == 1 || randomNum == 2) {
                score += random.nextInt(60, 70);
            } else if (randomNum == 3 || randomNum == 4) {
                score += random.nextInt(70, 80);
            } else if (randomNum == 5 || randomNum == 6 || randomNum == 7 || randomNum == 8) {
                score += random.nextInt(80, 90);
            } else {
                score += random.nextInt(90, 101);
            }

            scores.set(i, score);
        }
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                '}';
    }
}
