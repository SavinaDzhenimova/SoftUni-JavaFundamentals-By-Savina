package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p10_SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> scheduleLessonsList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("course start")) {
            String[] commands = input.split(":");
            String lessonTitle = commands[1];

            switch (commands[0]) {
                case "Add":
                    if (!scheduleLessonsList.contains(lessonTitle)) {
                        scheduleLessonsList.add(lessonTitle);
                    }
                    break;
                case "Insert":
                    int indexToInsert = Integer.parseInt(commands[2]);

                    if (!scheduleLessonsList.contains(lessonTitle)) {
                        if (indexToInsert >= 0 && indexToInsert < scheduleLessonsList.size()) {
                            scheduleLessonsList.add(indexToInsert, lessonTitle);
                        }
                    }
                    break;
                case "Remove":
                    String exerciseTitle = commands[1] + "-Exercise";
                    int exerciseIndex = scheduleLessonsList.indexOf(exerciseTitle);

                    if (scheduleLessonsList.contains(lessonTitle)) {
                        scheduleLessonsList.remove(lessonTitle);

                        if (scheduleLessonsList.contains(exerciseTitle)) {
                            scheduleLessonsList.remove(exerciseIndex);
                        }
                    }
                    break;
                case "Swap":
                    String secondLessonTitle = commands[2];

                    if (scheduleLessonsList.contains(lessonTitle) && scheduleLessonsList.contains(secondLessonTitle)) {
                        int firstLessonIndex = scheduleLessonsList.indexOf(lessonTitle);
                        int secondLessonIndex = scheduleLessonsList.indexOf(secondLessonTitle);

                        if (scheduleLessonsList.contains(lessonTitle + "-Exercise")
                                && scheduleLessonsList.contains(secondLessonTitle + "-Exercise")) {
                            String firstLessonExerciseTitle = lessonTitle + "-Exercise";
                            int firstLessonExerciseIndex = scheduleLessonsList.indexOf(firstLessonExerciseTitle);
                            String secondLessonExerciseTitle = secondLessonTitle + "-Exercise";
                            int secondLessonExerciseIndex = scheduleLessonsList.indexOf(secondLessonExerciseTitle);

                            scheduleLessonsList.set(firstLessonIndex, secondLessonTitle);
                            scheduleLessonsList.set(firstLessonExerciseIndex, secondLessonExerciseTitle);
                            scheduleLessonsList.set(secondLessonIndex, lessonTitle);
                            scheduleLessonsList.set(secondLessonExerciseIndex, firstLessonExerciseTitle);
                        } else if (scheduleLessonsList.contains(lessonTitle + "-Exercise")) {
                            String firstLessonExerciseTitle = lessonTitle + "-Exercise";
                            int firstLessonExerciseIndex = scheduleLessonsList.indexOf(firstLessonExerciseTitle);

                            scheduleLessonsList.set(firstLessonIndex, secondLessonTitle);
                            scheduleLessonsList.set(secondLessonIndex, lessonTitle);
                            scheduleLessonsList.remove(firstLessonExerciseIndex);

                            firstLessonIndex = scheduleLessonsList.indexOf(lessonTitle);
                            scheduleLessonsList.add(firstLessonIndex + 1, firstLessonExerciseTitle);
                        } else if (scheduleLessonsList.contains(secondLessonTitle + "-Exercise")) {
                            String secondLessonExerciseTitle = secondLessonTitle + "-Exercise";
                            int secondLessonExerciseIndex = scheduleLessonsList.indexOf(secondLessonExerciseTitle);

                            scheduleLessonsList.set(firstLessonIndex, secondLessonTitle);
                            scheduleLessonsList.set(secondLessonIndex, lessonTitle);
                            scheduleLessonsList.remove(secondLessonExerciseIndex);

                            secondLessonIndex = scheduleLessonsList.indexOf(secondLessonTitle);
                            scheduleLessonsList.add(secondLessonIndex + 1, secondLessonExerciseTitle);
                        } else if (!scheduleLessonsList.contains(lessonTitle + "-Exercise")
                                && !scheduleLessonsList.contains(secondLessonTitle + "-Exercise")) {
                            scheduleLessonsList.set(firstLessonIndex, secondLessonTitle);
                            scheduleLessonsList.set(secondLessonIndex, lessonTitle);
                        }
                    }
                    break;
                case "Exercise":
                    String lessonExerciseTitle = commands[1] + "-Exercise";

                    if (scheduleLessonsList.contains(lessonTitle) && !scheduleLessonsList.contains(lessonExerciseTitle)) {
                        int indexOfLesson = scheduleLessonsList.indexOf(lessonTitle);
                        scheduleLessonsList.add(indexOfLesson + 1, lessonExerciseTitle);
                    } else if (!scheduleLessonsList.contains(lessonTitle)) {
                        scheduleLessonsList.add(lessonTitle);
                        scheduleLessonsList.add(lessonExerciseTitle);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < scheduleLessonsList.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, scheduleLessonsList.get(i));
        }
    }
}