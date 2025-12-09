package org.DanielSavulescu;

import java.util.List;

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
        for (Integer s : scores) {
            sum += s;
            count++;
        }

        return sum / count;
    }
}
