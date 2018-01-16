package months;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MonthParser {
    public Month parseMonth(int numberOfMonth) {
        if (numberOfMonth < 1 || numberOfMonth > 12) throw new IllegalArgumentException();
        switch (numberOfMonth) {
            case 1:
                return new Month("January", 31);
            case 2:
                return new Month("February", 28);
            case 3:
                return new Month("March", 31);
            case 4:
                return new Month("April", 30);
            case 5:
                return new Month("May", 31);
            case 6:
                return new Month("June", 30);
        }
        return null;
    }
}
