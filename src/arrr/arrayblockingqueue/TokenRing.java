package arrr.arrayblockingqueue;

import java.util.List;

public interface TokenRing {
    void fillTokenRing(int count);

    void fillThreadNodes(int count);

    void fillContent(int contentCount);

    void startThreads();

    List<Double> checkThroughput(long time);

    List<List<Long>> getLatency(int count);
}
