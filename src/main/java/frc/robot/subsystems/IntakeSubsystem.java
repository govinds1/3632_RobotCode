// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  private final WPI_VictorSPX m_motor = new WPI_VictorSPX(Constants.INTAKE_MOTOR);

  /** Creates a new ExampleSubsystem. */
  public IntakeSubsystem() {
    m_motor.setInverted(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void intake() {
    m_motor.set(Constants.INTAKE_POWER);
  }

  public void outtake() {
    m_motor.set(Constants.OUTTAKE_POWER);
  }

  public void stop() {
    m_motor.set(0);
  }
}
