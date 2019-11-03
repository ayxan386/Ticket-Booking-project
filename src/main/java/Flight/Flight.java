package Flight;

public class Flight {
        private final String id;
        private final String from;
        private final String to;
        private final double duration;

        public Flight(String id, String from, String to, double duration) {
                this.id = id;
                this.from = from;
                this.to = to;
                this.duration = duration;
        }

        public String getId() {
                return id;
        }

        public String getFrom() {
                return from;
        }

        public String getTo() {
                return to;
        }

        public double getDuration() {
                return duration;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Flight)) return false;
                Flight flight = (Flight) o;
                return getId().equals(flight.getId());
        }

        @Override
        public int hashCode() {
                return getId().hashCode();
        }
}
