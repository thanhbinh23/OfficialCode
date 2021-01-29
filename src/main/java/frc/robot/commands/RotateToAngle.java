/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import static frc.robot.Constants.PID_CONST.*;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;

public class RotateToAngle extends CommandBase {
  private final Drivebase m_drivebase;
  public static AHRS ahrs = new AHRS();
  PIDController turnController;

  public RotateToAngle(Drivebase drivebase, double angle) {
    m_drivebase = drivebase;
    turnController = new PIDController(kP, kI, kD);
    turnController.setSetpoint(angle);
    turnController.enableContinuousInput(-180, 180);
    turnController.setIntegratorRange(-10, 1);
    turnController.setTolerance(kToleranceDegrees, kToleranceAngularVelocity);
    addRequirements(m_drivebase);
  }

  @Override
  public void initialize() {
    turnController.reset();
    ahrs.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putBoolean("start", true);
    SmartDashboard.putNumber("angle", ahrs.getYaw());
    double speed = turnController.calculate(ahrs.getYaw());
    speed += Math.signum(speed) * 0.1;
    speed = Math.min(0.6, Math.max(-0.6, speed));
    m_drivebase.drive(-speed, speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivebase.drive(0, 0);
    SmartDashboard.putBoolean("start", false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return turnController.atSetpoint();
  }
}
