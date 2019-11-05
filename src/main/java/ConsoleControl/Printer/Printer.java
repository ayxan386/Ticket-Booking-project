package ConsoleControl.Printer;

import FancyString.FancyString;

import java.util.List;

public class Printer {
        public static void print(List<FancyString> list) {
                for (FancyString el : list) {
                        System.out.println(el.fancyString());
                }
        }
}
