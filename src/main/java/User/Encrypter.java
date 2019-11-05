package User;

public class Encrypter {
        private final static String key = "AYKHANORKHANISMAYIL";

        public static String encrypt(String s) {
                StringBuilder res = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                        res.append((char) (s.charAt(i) ^ key.charAt(i % s.length())));
                }
                return res.toString();
        }
}
