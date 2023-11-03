import java.util.List;

List < String > lines = """
        Line 1
        Line 2
        Line 3
        """.lines().toList();

enum DAY_OF_WEEK {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

DAY_OF_WEEK today = DAY_OF_WEEK.THURSDAY;

String workTime = switch (today) {
    case MONDAY, TUESDAY, WEDNESDAY, THURSDAY -> "09:00-18:00";
    case FRIDAY -> "09:15-17:00";
    default -> "NOPE";
};

Object mystery = Integer.valueOf("100");

String message = "'mystery' is not an integer.";
if (mystery instanceof Integer i) {
    message = i < 100 ? "'mystery' is an integer lower than 100" : "'mystery' is an integer greater or equal to 100";
}

System.out.println(message);