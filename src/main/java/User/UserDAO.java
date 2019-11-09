package User;

import DAO.DAO;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class UserDAO implements DAO<User> {

        private Set<User> storage;
        private final static File users = new File("data", "users.txt");

        public UserDAO() {
                storage = new HashSet<User>();
                loadAllUser();
        }

        public void loadAllUser() {
                try {
                        BufferedReader br = new BufferedReader(
                                new FileReader(users));
                        br.lines().forEach(row -> {
                                String[] columns = row.split("/");
                                User temp = new User(columns[0], columns[1], columns[2], columns[4]);
                                storage.add(temp);
                        });
                        br.close();
                } catch (Exception e) {
                        //...
                }
        }

        public void updateDatabase() {
                try {
                        BufferedWriter bw = new BufferedWriter(
                                new FileWriter(users));
                        for (User user : storage) {
                                bw.write(
                                        String.format("%s/%s/%s/%s/%s\n",
                                                user.getName(),
                                                user.getSurname(),
                                                user.getNickname(),
                                                user.getId(),
                                                user.getPassword()
                                        ));
                        }
                        bw.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        @Override
        public void add(User data) {
                storage.add(data);
                updateDatabase();
        }

        @Override
        public void remove(String id) {
                storage.removeIf(el -> el.getId().equals(id));
                updateDatabase();
        }

        @Override
        public User get(String id) {
                return storage.stream()
                        .filter(el -> el.getId().equals(id))
                        .findFirst().get();
        }

        @Override
        public void update(User data) {
                storage.add(data);
        }


        public boolean contains(User data) {
                return storage.contains(data);
        }

        public void eraseData() {
                try {
                        BufferedWriter bw = new BufferedWriter(
                                new FileWriter(users));
                        bw.write("");
                        bw.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }


}
