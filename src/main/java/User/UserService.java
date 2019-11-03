package User;

import DAO.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class UserService implements DAO<User> {
        Set<User> storage;
        private final static File users = new File("data", "users.txt");

        public UserService() {
                storage = new HashSet<User>();
                loadAllUser();
        }

        public void loadAllUser() {
                try {
                        new BufferedReader(
                                new FileReader(users)).lines().forEach(row -> {
                                String[] columns = row.split("|");
                                User temp = new User(columns[1], columns[2], columns[3], columns[0]);
                                storage.add(temp);
                        });
                } catch (FileNotFoundException e) {
                        //...
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
        }

        @Override
        public void remove(String id) {
                storage.removeIf(el -> el.getId().equals(id));
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
}
