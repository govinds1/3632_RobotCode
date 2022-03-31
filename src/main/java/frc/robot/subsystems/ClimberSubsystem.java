// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.motorcontrol.Spark;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberSubsystem extends SubsystemBase {
  private final Spark m_motor = new Spark(Constants.CLIMBER_MOTOR);

  /** Creates a new ExampleSubsystem. */
  public ClimberSubsystem() {
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

  public void up() {
    m_motor.set(Constants.CLIMBUP_POWER);
  }

  public void down() {
    m_motor.set(Constants.CLIMBDOWN_POWER);
  }

  public void stop() {
    m_motor.set(0);
  }
}
