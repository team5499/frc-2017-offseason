package org.team5499.robots.frc2017.subsystems;

import edu.wpi.first.wpilibj.Timer;

@SuppressWarnings("unused")
public class PID {

    private double kP, kI, kD;
    private double ov_cap, ov, pv, prev_pv, sp;
    private double integral, derivative;
    private double last_input_time, prev_error, prev_time;


    public PID(double pVal, double iVal, double dVal, double output_cap) {
        kP = pVal;
        kI = iVal;
        kD = dVal;
    }

    public void setSetpoint(double s) {
        sp += s;
    }

    public double getSetpoint() {
        return sp;
    }

    public void setInput(double input) {
        prev_pv = pv;
        last_input_time = Timer.getFPGATimestamp();
        pv = input;
    }

    public void calculate()
    {
        double error = sp - pv;
        double timeError = Timer.getFPGATimestamp()-prev_time;
        integral += (error*timeError);
        prev_time = Timer.getFPGATimestamp();
        derivative = (error-prev_error)/timeError;
        prev_error = error;
        ov = (kP*error) + (kI*integral) + (kD*derivative);

        if(ov > ov_cap)
            ov = ov_cap;
        if(ov < -ov_cap)
            ov = -ov_cap;
    }

    public double getOutput() {
        return ov;
    }

    public double getError() {
        return sp - pv;
    }

    public double getRate()
    {
        return (pv - prev_pv)/(Timer.getFPGATimestamp() - last_input_time);
    }

    public void reset() {
        ov = 0;
        pv = 0;
        sp = 0;
        prev_pv = 0;
        last_input_time = 0;
        prev_error = 0;
        prev_time = 0;
        integral = 0;
        derivative = 0;
    }



}