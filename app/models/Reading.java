//Class to model what parameters are required for each reading
package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Reading extends Model
{
  public int code;
  public float temperature;
  public float windSpeed;
  public int windDirection; // Version 3
  public int pressure; //Version 2
  
  public Reading(int code, float temperature, float windSpeed, int windDirection, int pressure)
  {
    this.code = code;
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.windDirection = windDirection;
    this.pressure = pressure;
  }
}
