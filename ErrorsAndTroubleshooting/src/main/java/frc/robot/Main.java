// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.RobotBase;

/**
 * Do NOT add any static variables to this class, or any initialization at all. Unless you know what
 * you are doing, do not modify this file except to change the parameter class to the startRobot
 * call.
 */
public final class Main {
  private Main() {}

  /**
   * Main initialization function. Do not perform any initialization here.
   *
   * <p>If you change your main robot class, change the parameter type.
   */
  public static void main(String... args) {
    DigitalOutput output8 = new DigitalOutput(8); 
    DigitalInput input9 = new DigitalInput(9);
    DigitalInput input10 = new DigitalInput(10);

    System.out.println("You started your robot program!");

    int wheelsOnRobot = 2;
    double robotSpeed = .5;

    System.out.print("Wheels on Robot: ");
    System.out.println(wheelsOnRobot);

    System.out.print("Robot Speed: ");
    System.out.println(robotSpeed);

    if(wheelsOnRobot > 2) {
      System.out.println("There are more than two wheels on the robot.");
    } else {
      System.out.println("There are two or less wheels on the robot.");
    }

    if(robotSpeed == 0) {
      System.out.println("The robot has stopped");
    } else if (robotSpeed == 1) {
      System.out.println("The robot is at max speed");
    } else {
      System.out.println("The robot speed is at: " + robotSpeed);
    }

    RobotBase.startRobot(Robot::new);
  }
}
