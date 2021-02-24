package com.lsh.jack.sort;

public class MathUtils {

    public static double sqr(double val) {
        if (val < 0) throw new IllegalArgumentException("不能小于0");
        double start = 1, end = val;
        double mid = val;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            double v = mid * mid - val;
            if (Math.abs(v) <= 1) {   //处理浮点数。把值缩小到1范围内
                return sqr_val(val, mid);
            } else if (v > 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return mid;
    }

    // 处理浮点数
    public static double sqr_val(double val, double r) {
        if (val < 0) throw new IllegalArgumentException("不能小于0");
        double start = r-1, end = r + 1;
        double mid = r;
        int counter = 1000;
        while (start <= end && counter-- > 0) {
            mid = start + ((end - start) / 2);
            double v = mid * mid - val;
            if (Math.abs(v) <= 0.0000001) {   //处理浮点数。把值缩小到1范围内
                return mid;
            } else if (v > 0) {
                end = mid - 0.0000001;
            } else {
                start = mid + 0.0000001;
            }
        }
        return mid;
    }

    static float sqroot(float m) {
        float i = 0;
        float x1 = 0, x2 = 0;
        while ((i * i) <= m)
            i += 0.1;
        x1 = i;
        for (int j = 0; j < 10; j++) {
            x2 = m;
            x2 /= x1;
            x2 += x1;
            x2 /= 2;
            x1 = x2;
        }
        return x2;
    }

    public static double sqrtd(double a) {
        double i = 0;
        double j = a;
        while (i <= j) {
            double m = (i + j) / 2;
            double s = m * m;
            if (s == a) return m;
            else if (s > a) j = m;
            else i = m;
        }
        return j;
    }

    public static void main(String[] args) {
//        System.out.println(sqr(100));

        int test = test();
        System.out.println(test);

        return;

    }

    private static int test() {
        int i = 4;

        try {
            i = 5;
            return i;
        } finally {
            i++;
            return i;
        }
    }

}
