// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  private final TalonFX m_motor1 = new TalonFX(Constants.SHOOTER1_MOTOR);
  private final TalonFX m_motor2 = new TalonFX(Constants.SHOOTER2_MOTOR);

  // converts ticks per 100ms to rpm
  private final double velocityConversion = (1 / 2048) * 10 * 60; // (rotations per ticks) * (100ms per second) * (seconds per minute)

  /** Creates a new ExampleSubsystem. */
  public ShooterSubsystem() {
    m_motor1.setInverted(false);
    m_motor2.setInverted(false);
    // m_motor2.follow(m_motor1); // using velocity PID for both might be better?
    configPID(0.1, 0, 0, 0.4);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Shooter 1/RPM", m_motor1.getSelectedSensorVelocity() * velocityConversion);
    SmartDashboard.putNumber("Shooter 2/RPM", m_motor2.getSelectedSensorVelocity() * velocityConversion);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void spinUp() {
    setMotors(Constants.SHOOT_RPM);
  }

  public void stop() {
    setMotors(0);
  }

  public void setMotors(double rpm) {
    double velocity = rpm / velocityConversion;
    m_motor1.set(TalonFXControlMode.Velocity, velocity);
    m_motor2.set(TalonFXControlMode.Velocity, velocity);
  }

  public void configPID(double kP, double kI, double kD, double kF) {
    m_motor1.config_kP(0, kP);
    m_motor1.config_kI(0, kI);
    m_motor1.config_kD(0, kD);
    m_motor1.config_kF(0, kF);

    m_motor2.config_kP(0, kP);
    m_motor2.config_kI(0, kI);
    m_motor2.config_kD(0, kD);
    m_motor2.config_kF(0, kF);
  }

}
