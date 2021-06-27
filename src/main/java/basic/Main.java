package basic;

import basics.p1_basics.v_2_classesAndProperties.Rectangle;

public class Main {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(1,1);
        // accessing kotlin class props
        System.out.println(r.isSquare());
        System.out.println(r.getHeight());
        //todo: 4 add a setter to rect and use it from java
    }
}
