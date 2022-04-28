package utilities;

import model.Stream;
import model.Subject;
import model.Type;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class InputValidator {

    private static final String localDateFormat = "dd/MM/yyyy";
    private static final Scanner input = Input.getInstance();

    public static String provideOnlyString(Scanner input) {
        String expression = " ";
        boolean flag = false;
        while (!flag) {
            expression = input.nextLine();
            if (Pattern.matches("^[ A-Za-z]+$", expression)) {
                flag = true;
            } else {
                System.out.println("Please provide Characters");
            }
        }
        return expression;
    }

    public static String provideStringsAndMinOneDigit(Scanner input) {
        String expression = " ";
        boolean flag = false;
        while (!flag) {
            expression = input.nextLine();
            if (Pattern.matches("(?=(?:.*[a-zA-Z]){1,})(?=(?:.*[@-]){0,})(?=(?:.*[0-9]){1,})^[a-zA-Z0-9@-]*$", expression)) {
                flag = true;
            } else {
                System.out.println("PLEASE PROVIDE CHARACTERS AND MINIMUM ONE DIGIT");
            }
        }
        return expression;
    }

    public static String provideAfmWithNineDigits(Scanner input) {
        String expression = " ";
        boolean flag = false;
        while (!flag) {
            expression = input.nextLine();
            if (Pattern.matches("(?<!\\d)\\d{9}(?!\\d)", expression)) {
                flag = true;
            } else {
                System.out.println("PLEASE PROVIDE 9 DIGITS");
            }
        }
        return expression;
    }

    public static int provideNumToInteger(Scanner scanner) {
        int resultNum;
        while (true) {
            try {
                String input = scanner.next();
                int number = Integer.parseInt(input);
                resultNum = number;
                break;
            } catch (NumberFormatException e) {
                System.out.println("PLEASE GIVE ONLY NUMBERS");
            }
        }
        return resultNum;
    }

    public static double provideNumToDouble(Scanner scanner) {
        double resultNum;
        while (true) {
            try {
                String input = scanner.next();
                resultNum = Double.parseDouble(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("PLEASE PROVIDE ONLY NUMBERS");
            }
        }
        return resultNum;
    }

    public static LocalDate provideADate(Scanner input) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(localDateFormat);
        LocalDate result;
        while (true) {
            try {
                System.out.println("PLEASE PROVIDE A DATE IN THE FORMAT OF ( 01/01/2010)");
                String in = input.next();
                result = LocalDate.parse(in, format);
                break;
            } catch (DateTimeException e) {
                System.out.println("CAUGHT");
            }
        }
        return result;
    }

    //Check if a student is at least 10 years old
    public static LocalDate validateBirthDate() {
        LocalDate currentDate = LocalDate.now();
        LocalDate d1 = currentDate.minusYears(10);
        String dateFormat = d1.format(DateTimeFormatter.ofPattern(localDateFormat));
        LocalDate givenDate;
        while (true) {
            givenDate = provideADate(input);
            if (givenDate.isBefore(d1)) {
                return givenDate;
            } else {
                System.out.printf("PLEASE PROVIDE A DATE THAT IS BEFORE THE DATE %s. THE STUDENT MUST BE AT LEAST 10 YEARS OLD. ", dateFormat);
            }

        }
    }

    //Provide the Start Date of the course
    public static LocalDate provideStartDate() {
        LocalDate currentDate = LocalDate.now();
        String dateFormat = currentDate.format(DateTimeFormatter.ofPattern(localDateFormat));
        LocalDate givenDate;
        while (true) {
            givenDate = provideADate(input);
            if (givenDate.isAfter(currentDate)) {
                return givenDate;
            } else {
                System.out.println("PLEASE PROVIDE A DATE THAT IS GREATER THAN " + dateFormat);
            }

        }
    }


    //Provide the End Date of the course
    public static LocalDate provideEndDate(LocalDate startDate) {
        LocalDate givenDate;
        String dateFormat = startDate.format(DateTimeFormatter.ofPattern(localDateFormat));
        while (true) {
            givenDate = provideADate(input);
            if (givenDate.isAfter(startDate)) {
                return givenDate;
            } else {
                System.out.println("PLEASE PROVIDE A DATE THAT IS GREATER THAN " + dateFormat);
            }

        }
    }

    //Check if the Assignment is within the duration of the course
    public static LocalDate provideSubDate(LocalDate courseStartDate, LocalDate courseEndDate) {
        String formatedStartDate = courseStartDate.format(DateTimeFormatter.ofPattern(localDateFormat));
        String formatedEndDate = courseEndDate.format(DateTimeFormatter.ofPattern(localDateFormat));
        LocalDate givenDate;
        while (true) {
            givenDate = provideADate(input);
            if (givenDate.isAfter(courseStartDate) && givenDate.isBefore(courseEndDate)) {
                return givenDate;
            } else {
                System.out.println("PLEASE PROVIDE A DATE THAT IS GREATER THAN " + formatedStartDate + " AND A DATE LOWER THAN " + formatedEndDate);
            }
        }
    }

    public static boolean yesOrNoMenu() {

        boolean flag = true;
        String inputChoice = input.next();
        while ((!inputChoice.equals("1")) && (!inputChoice.equals("2"))) {
            System.out.println("WRONG INPUT, PLEASE TRY AGAIN");
            inputChoice = input.next();
        }
        if (inputChoice.equals("2")) {
            flag = false;
        }
        return flag;
    }


    public static List<Subject> provideSubjects(Scanner input) {
        List<Subject> subjects = Subject.getSubjects().stream().toList();
        List<Subject> inputSubjects = new ArrayList<>();
        Style.blank();
        System.out.println("PLEASE PROVIDE ONE OF THE ABOVE");
        while (true) {
            String inputSubject = input.next();
            if (subjects.stream().anyMatch(subject -> subject.getName().equalsIgnoreCase(inputSubject))) {
                Subject stringtoEnum = Subject.valueOfLabel(inputSubject);

                if (!inputSubjects.contains(stringtoEnum)) {
                    inputSubjects.add(stringtoEnum);
                } else {
                    System.out.println("YOU ALREADY INSERTED THIS SUBJECT");
                }

                System.out.println("DO YOU WANT TO ADD MORE SUBJECTS?");
                System.out.println(("1 - YES"));
                System.out.println(("2 - NO"));
                boolean more = yesOrNoMenu();
                if (!more) {
                    break;
                } else {
                    System.out.println("INSERT: " + Subject.getSubjectNames());
                }

            } else {
                System.out.println("PLEASE SELECT THE RIGHT INPUT");
            }
        }
        return inputSubjects;
    }


    public static List<Stream> provideStreams(Scanner input) {
        List<Stream> streams = Stream.getStreams().stream().toList();
        List<Stream> inputStreams = new ArrayList<>();
        Style.blank();
        System.out.println("PLEASE PROVIDE ONE OF THE ABOVE");
        while (true) {
            String inputStream = input.next();
            if (streams.stream().anyMatch(stream -> stream.getName().equalsIgnoreCase(inputStream))) {
                Stream stringToEnum = Stream.valueOfLabel(inputStream);
                List<Type> types = provideTypes(input);
                stringToEnum.setTypes(types);
                inputStreams.add(stringToEnum);
                System.out.println("DO YOU WANT TO ADD MORE STREAMS?");
                System.out.println(("1 - YES"));
                System.out.println(("2 - NO"));
                boolean more = yesOrNoMenu();
                if (!more) {
                    break;
                } else {
                    System.out.println("INSERT: " + Stream.getStreamNames());
                }
            } else {
                System.out.println("PLEASE SELECT THE RIGHT INPUT");
            }
        }
        return inputStreams;
    }

    public static List<Type> provideTypes(Scanner input) {
        //A List to take Part Time or Full time from the Enum Type.
        List<Type> inputTypes = new ArrayList<>();
        List<String> types = Type.getTypeNames()
                .stream()
                .map(e -> e.split(" ")[0]).collect(Collectors.toList());
        System.out.println("PLEASE PROVIDE ONE OR MORE OF THE FOLLOWING " + types);
        while (true) {
            String inputType = input.next();
            if (types.stream().anyMatch(type -> type.equalsIgnoreCase(inputType))) {
                //Searching inside the hashmap's enum to find the corresponding Enum type.
                Type strToEnum = Type.valueOfLabel(inputType);
                if (!inputTypes.contains(strToEnum)) {
                    inputTypes.add(strToEnum);
                } else {
                    System.out.println("YOU ALREADY INSERTED THIS TYPE");
                }
                System.out.println("DO YOU WANT TO ADD MORE TYPES? " + types);
                System.out.println(("1 - YES"));
                System.out.println(("2 - NO"));
                boolean more = yesOrNoMenu();
                if (!more) {
                    break;
                } else {
                    System.out.println("INSERT: " + types);
                }
            } else {
                System.out.println("PLEASE SELECT THE RIGHT INPUT");
            }
        }

        return inputTypes;

    }

}
