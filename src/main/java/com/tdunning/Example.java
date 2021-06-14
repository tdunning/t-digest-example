package com.tdunning;

import com.tdunning.math.stats.MergingDigest;
import com.tdunning.math.stats.TDigest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Example {
    public static void main(String[] args) {
        TDigest digest = new MergingDigest(200);
        List<Double> data = new ArrayList<>();
        Random gen = new Random();
        for (int i = 0; i < 1_000_000; i++) {
            double x = gen.nextDouble();
            digest.add(x);
            data.add(x);
        }
        System.out.print("type,x,tdigest,empirical,relative_error\n");
        for (double v : new double[]{1e-5, 1e-4, 1e-3, 1e-2, 1e-1}) {
            double x = v;
            double cdf_t = digest.cdf(x);
            double cdf_data = cdf(x, data);
            System.out.printf("cdf,%.7f,%.7f,%.7f,%.7f\n", x, cdf_t, cdf_data, Math.abs(cdf_t - cdf_data) / v);
            x = 1 - v;
            cdf_t = digest.cdf(x);
            cdf_data = cdf(x, data);
            System.out.printf("cdf,%.7f,%.7f,%.7f,%.7f\n", x, cdf_t, cdf_data, Math.abs(cdf_t - cdf_data) / v);
        }
    }

    static double cdf(double x, List<Double> data) {
        double sum = 0;
        for (Double z : data) {
            if (z < x) {
                sum += 1;
            } else if (z == x) {
                sum += 0.5;
            }
        }
        return sum / data.size();
    }
}
