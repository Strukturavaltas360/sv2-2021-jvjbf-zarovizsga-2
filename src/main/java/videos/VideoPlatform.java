package videos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VideoPlatform {
    private List<Channel> channels = new ArrayList<>();

    public void readDataFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            boolean headerLine = true;
            while ((line = br.readLine()) != null) {
                if (headerLine) {
                    headerLine = false;
                } else {
                    channels.add(Channel.of(line));
                }
            }
        } catch (IOException exception) {
            throw new IllegalArgumentException("Cannot open file for read!", exception);
        }
    }

    public int calculateSumOfVideos() {
        return channels.stream()
                .mapToInt(Channel::getNumberOfVideos)
                .sum();
    }

    public List<Channel> getChannels() {
        return channels;
    }
}
