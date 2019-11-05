package User;

public class User {
        private final String name;
        private final String surname;
        private final String nickname;
        private final String id;

        public User(String name, String surname, String nickname) {
                this.name = name;
                this.surname = surname;
                this.nickname = nickname;
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
}
