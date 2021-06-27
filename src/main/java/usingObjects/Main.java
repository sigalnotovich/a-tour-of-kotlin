package usingObjects;

import basics.p3_classes_objects_interfaces.Boy;
import basics.p3_classes_objects_interfaces.CaseInsensitiveFileComparator;

public class Main {
    public static void main(String[] args) {
        CaseInsensitiveFileComparator.INSTANCE.compare(null, null);




        Boy.Companion.newBoy();
    }
}
