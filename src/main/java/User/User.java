package User;

public class User {
        private final String name;
        private final String surname;
        private final String nickname;
        private final String id;


        public User(String name, String surname, String nickname, String id) {
                this.name = name;
                this.surname = surname;
                this.nickname = nickname;
                this.id = id;
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
}
