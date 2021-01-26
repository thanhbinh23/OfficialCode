// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;
import static frc.robot.Constants.PID_CONST.kP;
import static frc.robot.Constants.PID_CONST.kD;
import static frc.robot.Constants.PID_CONST.kI;
import static frc.robot.Constants.PID_CONST.kToleranceAngularVelocity;
import static frc.robot.Constants.PID_CONST.kToleranceDegrees;

import java.sql.Time;

import frc.robot.commands.RotateToAngle;

public class GoStraight extends CommandBase {
  private final Drivebase m_drivebase;
  public static AHRS ahrs = new AHRS();
  PIDController turnController;
  public double time;
  public double error;
 
  public GoStraight(Drivebase drivebase, double x) {
     m_drivebase = drivebase;
     turnController = new PIDController(kP, kI, kD);
     turnController.enableContinuousInput(-180, 180);
     turnController.setIntegratorRange(-10, 1);
     turnController.setTolerance(kToleranceDegrees, kToleranceAngularVelocity);
     addRequirements(m_drivebase);
     double time = x;
  }

  
  @Override
  public void initialize() {
    turnController.reset();  
    ahrs.reset();
    //Timer.delay(time);
    //new RotateToAngle(m_drivebase,0);
  }


  @Override
  public void execute() {
    double error = turnController.calculate(ahrs.getYaw());
    m_drivebase.drive(0.4, 0.4 + error);
    
  }

  
  @Override
  public void end(boolean interrupted) {
    m_drivebase.drive(0,0);
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}
