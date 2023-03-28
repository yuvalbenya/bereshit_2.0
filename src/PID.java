public class PID {

    private double P = 1.0;
    private double I = 0.001;
    private double D = 10.0;
//    private final double target;
//    private double p,i,d,max,min;
    private double last_err,sum_errors;


    // p  diffrence between vs - expected_vs
    // d diffrence between vs(now) - vs(last_time)
    // i sum of all p untill now
    public PID(double p, double i,double d) {
//        this.target = p;
        this.P = p;
        this.I = i;
        this.D = d;
    }

    public double compute(double error, double dt) {
        sum_errors += error;
        double d = error - last_err;
        last_err = error;
        d = d / dt;
        double output = error * P + sum_errors * I + d*D;
        return clamp(output);
    }


    private double clamp(double t) {
        if (t > 1) {t = 1;}
        return t;
    }
}