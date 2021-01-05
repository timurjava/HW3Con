package arrr.arrayblockingqueue;

import java.util.concurrent.atomic.AtomicInteger;

public class ThroughputChecker {

    protected AtomicInteger count = new AtomicInteger(0);

    protected void countIncrement() {
        this.count.incrementAndGet();
    }

    public void setCountToZero(){
        count.set(0);
    }

    public double checkThroughput(long time) {
        return (((double)count.get() / time) * 1000); ////   p/sec
    }
}
