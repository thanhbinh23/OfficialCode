// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;


public class NetworkTable extends SubsystemBase {
  /** Creates a new NetworkTable. */
  
  NetworkTableEntry xEntry;
  NetworkTableEntry yEntry;
  public NetworkTable() {
    NetworkTableInstance inst = NetworkTableInstance.getDefault();
    edu.wpi.first.networktables.NetworkTable table = inst.getTable("visiongart");

    xEntry = table.getEntry("X");
    yEntry = table.getEntry("Y");
    double X = xEntry.getDouble(10);
    double Y = yEntry.getDouble(100000);
    
    xEntry.setDouble(x);
    yEntry.setDouble(y);
    }
           double x = 99999;
           double y = 10000;                                                                                     
           
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
    
    
  }
}
