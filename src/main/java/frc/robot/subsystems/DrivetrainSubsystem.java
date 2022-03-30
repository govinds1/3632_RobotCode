// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivetrainSubsystem extends SubsystemBase {
  private final Spark m_leftFront = new Spark(Constants.LEFT_FRONT_MOTOR);
  private final Spark m_leftRear = new Spark(Constants.LEFT_REAR_MOTOR);
  private final Spark m_rightFront = new Spark(Constants.RIGHT_FRONT_MOTOR);
  private final Spark m_rightRear = new Spark(Constants.RIGHT_REAR_MOTOR);
  private final MotorControllerGroup m_left = new MotorControllerGroup(m_leftFront, m_leftRear);
  private final MotorControllerGroup m_right = new MotorControllerGroup(m_rightFront, m_rightRear);
  private final DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);

  /** Creates a new ExampleSubsystem. */
  public DrivetrainSubsystem() {
    m_leftFront.setInverted(false);
    m_leftRear.setInverted(false);
    m_rightFront.setInverted(false);
    m_rightRear.setInverted(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void tankDrive(double leftPower, double rightPower) {
    m_drive.tankDrive(leftPower, rightPower);
  }

  public void arcadeDrive(double forward, double turn) {
    m_drive.arcadeDrive(forward, turn);
  }
}
