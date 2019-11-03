package User;

import DAO.DAO;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class UserService implements DAO<User> {
        private Set<User> storage;
        private final static File users = new File("data", "users.txt");

        public UserService() {
                storage = new HashSet<User>();
                loadAllUser();
        }

        public void loadAllUser() {
                try {
                        BufferedReader br = new BufferedReader(
                                new FileReader(users));
                        br.lines().forEach(row -> {
                                String[] columns = row.split("/");
                                User temp = new User(columns[0], columns[1], columns[2], columns[3]);
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
                                        String.format("%s/%s/%s/%s\n",
                                                user.getName(),
                                                user.getSurname(),
                                                user.getNickname(),
                                                user.getId())
                                );
                        }
                        bw.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        public Set<User> getAllUsers() {
                return storage;
        }

        public boolean smartAdd(User data) {
                if (storage.contains(data)) return false;
                add(data);
                return true;
        }

        public boolean smartRemove(User data) {
                if (storage.contains(data)) {
                        remove(data.getId());
                        return true;
                }
                return false;
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
                updateDatabase();
        }
}
