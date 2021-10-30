// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Timer;

/** Add your docs here. */
public class LightsController {
    Timer timer;
    DigitalOutput[] lights;

    public LightsController() {
        timer = new Timer();
        timer.start();
        lights = new DigitalOutput[3];
        lights[0] = new DigitalOutput(1);
        lights[1] = new DigitalOutput(2);
        lights[2] = new DigitalOutput(3);
    }

    public void turnLedsOn() {
        for (int i = 0; i < 3; i++) {
            lights[i].set(true);
        }
    }

    public void turnLedsOff() {
        for (int i = 0; i < 3; i++) {
            lights[i].set(false);
        }
    }

    public void setOneLightOnOnly(int i) {
        turnLedsOff();
        lights[i].set(true);
    }

    public void cycleLights () {
        int light = (int) timer.get() % 3;
        setOneLightOnOnly(light);
    }
}
