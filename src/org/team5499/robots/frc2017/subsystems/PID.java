package org.team5499.robots.frc2017.subsystems;

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



}