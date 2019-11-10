package ConsoleControl.Printer;

import ConsoleControl.Printer.FancyString.FancyString;

import java.util.List;

public interface Printer {
  static void print(List<FancyString> list) {
    for (FancyString el : list) {
      System.out.println(el.fancyString());
    }
  }
}
