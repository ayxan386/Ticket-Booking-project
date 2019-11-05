package User;

public class User {
        private final String name;
        private final String surname;
        private final String nickname;
        private final String id;
        private final String password;

        public User(String name, String surname, String nickname, String password) {
                this.name = name;
                this.surname = surname;
                this.nickname = nickname;
                this.password = password;
                this.id = String.valueOf(nickname.hashCode());
        }

        public User(User u, String password) {
                this.name = u.getName();
                this.surname = u.getSurname();
                this.nickname = u.getNickname();
                this.password = password;
                this.id = String.valueOf(nickname.hashCode());
        }
        public User(String name, String surname, String nickname) {
                this.name = name;
                this.surname = surname;
                this.nickname = nickname;
                this.password = "";
                this.id = String.valueOf(nickname.hashCode());
        }

        public String getPassword() {
                return password;
                this.id = String.valueOf(nickname.hashCode());
        }

        public String getName() {
                return name;
        }

        public String getSurname() {
                return surname;
        }

        public String getNickname() {
                return nickname;
        }

        public String getId() {
                return id;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof User)) return false;
                User user = (User) o;
                return getId().equals(user.getId());
        }

        @Override
        public int hashCode() {
                return getId().hashCode();
        }

        @Override
        public String toString() {
                return String.format("User{name='%s', surname='%s', nickname='%s', id='%s'}", name, surname, nickname, id);
        }
}
