// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lift extends SubsystemBase {
  private final Spark liftMotor;
  private final DigitalInput topLimitSwitch;

  /** Creates a new Lift. */
  public Lift() {
    liftMotor = new Spark(0);
    topLimitSwitch = new DigitalInput(0);
  }

  public void liftUp() {
    liftMotor.set(.3);
  }

  public void stop() {
    liftMotor.set(0);
  }

  public boolean reachedTop() {
    return topLimitSwitch.get();
  }
}
