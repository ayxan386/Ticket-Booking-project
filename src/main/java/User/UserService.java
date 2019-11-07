package User;

import java.util.NoSuchElementException;

public class UserService {

        private UserDAO userDAO;

        public UserService() {
                this.userDAO = new UserDAO();
        }


        public boolean smartAdd(User data) {
                if (userDAO.contains(data)) return false;
                userDAO.add(data);
                return true;
        }

        public boolean smartRemove(User data) {
                if (userDAO.contains(data)) {
                        userDAO.remove(data.getId());
                        return true;
                }
                return false;
        }



        public User get(String id) {
                return userDAO.get(id);
        }

        public void eraseData() {
                userDAO.eraseData();
        }

        public boolean match(String id, String pass) throws NoSuchElementException {
                return userDAO.get(id).getPassword().equals(pass);
        }
}
