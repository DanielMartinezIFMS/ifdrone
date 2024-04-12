package br.edu.ifms.phexarduino.algoritmos;

import java.util.GregorianCalendar;

public class PID {




    private final int MANUAL = 0;
    private final int AUTOMATIC = 1;
    private final int DIRECT = 0;
    private final int REVERSE = 1;

    private int controllerDirection = DIRECT;

    private long lastTime;
    private double input, output, setPoint;
    private double iTerm, lastInput;
    private double kp, ki, kd;
    private int sampleTime = 100;
    private double outMin, outMax;
    private boolean inAuto = false;

    private void Compute() {
        if(!inAuto) return;
        long now = new GregorianCalendar().getTimeInMillis();
        long timeChange = (now - lastTime);
        if(timeChange>=sampleTime){

            /*Compute all the working error variables*/
            double error = setPoint - input;
            iTerm+= (ki * error);
            if(iTerm > outMax) iTerm= outMax;
            else if(iTerm < outMin) iTerm= outMin;
            double dInput = (input - lastInput);

            /*Compute PID Output*/
            output = kp * error + iTerm- kd * dInput;
            if(output > outMax) output = outMax;
            else if(output < outMin) output = outMin;

            /*Remember some variables for next time*/
            lastInput = input;
            lastTime = now;
        }
    }


    /*
    kp - grandeza a ser alterada
    ki - integral
    kd - grandeza que altera kp
     */
    void SetTunings(double _kp, double _ki, double _kd)
    {
        if (_kp<0 || _ki<0|| _kd<0) return;

        double SampleTimeInSec = ((double) sampleTime)/1000;
        kp = _kp;
        ki = _ki * SampleTimeInSec;
        kd = _kd / SampleTimeInSec;

        if(controllerDirection == REVERSE){
            kp = (0 - kp);
            ki = (0 - ki);
            kd = (0 - kd);
        }
    }


    void SetSampleTime(int newSampleTime)
    {
        if (newSampleTime > 0)
        {
            double ratio  = (double) newSampleTime / (double) sampleTime;
            ki *= ratio;
            kd /= ratio;
            sampleTime = newSampleTime;
        }
    }


    void SetOutputLimits(double Min, double Max)
    {
        if(Min > Max) return;
        outMin = Min;
        outMax = Max;

        if(output > outMax) output = outMax;
        else if(output < outMin) output = outMin;

        if(iTerm > outMax) iTerm= outMax;
        else if(iTerm < outMin) iTerm= outMin;
    }

    void SetMode(int Mode)
    {
        boolean newAuto = (Mode == AUTOMATIC);
        if(newAuto == !inAuto)
        {  /*we just went from manual to auto*/
            Initialize();
        }
        inAuto = newAuto;
    }

    void Initialize()
    {
        lastInput = input;
        iTerm = output;
        if(iTerm > outMax) iTerm= outMax;
        else if(iTerm < outMin) iTerm= outMin;
    }

    void SetControllerDirection(int Direction)
    {
        controllerDirection = Direction;
    }






}



/*working variables*/




