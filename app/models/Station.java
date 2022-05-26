//Class to model the parameters required for each station
package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model
{
  public String name;
  public float latitude; //version 4
  public float longitude; //version 4
  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();
  public int code;
  public float temperature;
  public float windSpeed;
  public int windDirection;
  public int pressure;
  public String Beau;

  //Version 3 lines 29 - 38
  public int lastCode;
  public float lastTemp;
  public float lastTempF;
  public float lastWindSpeed;
  public int lastWindDir;
  public int lastPressure;
  public int lastWind;
  public String lastWeather;
  public String windComp;
  public float windChill;
  //Version 4 lines 40 - 46
  public float maxTemp;
  public float minTemp;
  public float minWind;
  public float maxWind;
  public String weatherIcon;
  public int maxPressure;
  public int minPressure;

  public Station(String name, float latitude, float longitude, int code, float temperature, float windSpeed, int windDirection, int pressure)
  {
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
    this.code = code;
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.windDirection = windDirection;
    this.pressure = pressure;
  }
}