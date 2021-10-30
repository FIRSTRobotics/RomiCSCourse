// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TurnWithGyroAndTimeout extends CommandBase {
  Drivetrain drivetrain;
  Timer timer;
  double speed;
  double degrees;
  int timeout;
  /** Creates a new TurnWithGyroAndTimeout. */
  public TurnWithGyroAndTimeout(double speed, double degrees, int timeout, Drivetrain drivetrain) {
    this.speed = speed;
    this.degrees = degrees;
    this.timeout = timeout;
    this.drivetrain = drivetrain;
    this.timer = new Timer();
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.resetGyro();
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.arcadeDrive(0, speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    timer.stop();
    drivetrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(drivetrain.getGyroAngleZ()) >= degrees || timer.hasElapsed(timeout);
  }
}
