package videos;

public class Channel {
    public static Channel of(String line) {
        String[] parts = line.split(";");
        return new Channel(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
    }

    private final String channelName;
    private final int subscriptions;
    private final int numberOfVideos;


    public Channel(String channelName, int subscriptions, int numberOfVideos) {
        this.channelName = channelName;
        this.subscriptions = subscriptions;
        this.numberOfVideos = numberOfVideos;
    }

    public String getChannelName() {
        return channelName;
    }

    public int getSubscriptions() {
        return subscriptions;
    }

    public int getNumberOfVideos() {
        return numberOfVideos;
    }
}
