package com.itau.desafio_backend.dto;

import java.util.DoubleSummaryStatistics;

public class StatisticResponse {

    private final long count;
    private final double sum;
    private final double avg;
    private final double min;
    private final double max;

    public StatisticResponse(DoubleSummaryStatistics statistics) {
        boolean transactionsIsEmpty = statistics.getMin() == Double.POSITIVE_INFINITY || statistics.getMax() == Double.NEGATIVE_INFINITY;
        this.min = transactionsIsEmpty ? 0.0 : statistics.getMin();
        this.max = transactionsIsEmpty ? 0.0 : statistics.getMax();
        this.count = statistics.getCount();
        this.sum = statistics.getSum();
        this.avg = statistics.getAverage();
    }

    public long getCount() {
        return count;
    }

    public double getSum() {
        return sum;
    }

    public double getAvg() {
        return avg;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
}
