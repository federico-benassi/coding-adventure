package federico.benassi.union_find.exercises;

public class Log {
        private String timestamp;
        private int friendP;
        private int friendQ;

        public Log(String timestamp, int friendP, int friendQ){
            this.timestamp = timestamp;
            this.friendP = friendP;
            this.friendQ = friendQ;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public int getFriendP() {
            return friendP;
        }

        public int getFriendQ() {
            return friendQ;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Log{");
            sb.append("timestamp='").append(timestamp).append('\'');
            sb.append(", friendP=").append(friendP);
            sb.append(", friendQ=").append(friendQ);
            sb.append('}');
            return sb.toString();
        }
}
