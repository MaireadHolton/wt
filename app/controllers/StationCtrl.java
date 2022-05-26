//Main Class for controlling all readings for each weather Station
package controllers;

import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;
import utils.StationAnalytics;

public class StationCtrl extends Controller
{
  //Displays the station and returns values calculated in the utils package
  public static void index(Long id)
  {
    Station station = Station.findById(id);
    Logger.info ("Station id = " + id);
    station.lastCode = StationAnalytics.getCode(station.readings);
    station.lastWeather = StationAnalytics.getWeather(station.readings);
    station.weatherIcon = StationAnalytics.getIcon(station.readings);
    station.lastTemp = StationAnalytics.getTemp(station.readings);
    station.lastTempF = StationAnalytics.getTempF(station.readings);
    station.maxTemp = StationAnalytics.getMaxTemp(station.readings);
    station.minTemp = StationAnalytics.getMinTemp(station.readings);
    station.lastWindSpeed = StationAnalytics.getWindSpeed(station.readings);
    station.maxWind = StationAnalytics.getMaxWind(station.readings);
    station.minWind = StationAnalytics.getMinWind(station.readings);
    station.lastWindDir = StationAnalytics.getWindDir(station.readings);
    station.windComp = StationAnalytics.getWindComp(station.readings);
    station.windChill = StationAnalytics.getWindChill(station.readings);
    station.lastWind = StationAnalytics.getBeaufort(station.readings);
    station.Beau = StationAnalytics.getBeau(station.readings);
    station.lastPressure = StationAnalytics.getPressure(station.readings);
    station.maxPressure = StationAnalytics.getMaxPressure(station.readings);
    station.minPressure = StationAnalytics.getMinPressure(station.readings);
    render("station.html", station);
  }

  //Version 5: method to delete a reading from a station
  public static void deleteReading (Long id, Long readingid)
  {
    Station station = Station.findById(id);
    Reading reading = Reading.findById(readingid);
    Logger.info ("Removing");
    station.readings.remove(reading);
    station.lastCode = StationAnalytics.getCode(station.readings);
    station.lastWeather = StationAnalytics.getWeather(station.readings);
    station.weatherIcon = StationAnalytics.getIcon(station.readings);
    station.lastTemp = StationAnalytics.getTemp(station.readings);
    station.lastTempF = StationAnalytics.getTempF(station.readings);
    station.maxTemp = StationAnalytics.getMaxTemp(station.readings);
    station.minTemp = StationAnalytics.getMinTemp(station.readings);
    station.lastWindSpeed = StationAnalytics.getWindSpeed(station.readings);
    station.maxWind = StationAnalytics.getMaxWind(station.readings);
    station.minWind = StationAnalytics.getMinWind(station.readings);
    station.lastWindDir = StationAnalytics.getWindDir(station.readings);
    station.windComp = StationAnalytics.getWindComp(station.readings);
    station.windChill = StationAnalytics.getWindChill(station.readings);
    station.lastWind = StationAnalytics.getBeaufort(station.readings);
    station.Beau = StationAnalytics.getBeau(station.readings);
    station.lastPressure = StationAnalytics.getPressure(station.readings);
    station.maxPressure = StationAnalytics.getMaxPressure(station.readings);
    station.minPressure = StationAnalytics.getMinPressure(station.readings);
    station.save();
    render("station.html", station);
  }

  //Version 5: method to delete a station and all associated readings
  public static void deleteStation (Long id, Long stationid, Long readingid)
  {
    Station station = Station.findById(stationid);
    Reading reading = Reading.findById(readingid);
    Logger.info ("Removing" + station.name);
    station.readings.remove(reading);
    station.delete();
    station.save();
    render ("station.html", station);
  }

  //Version 3: method to add a reading to a station
  public static void addReading(Long id, int code, float temperature, float windSpeed, int windDirection, int pressure)
  {
    Reading reading = new Reading(code, temperature, windSpeed, windDirection, pressure);
    Station station = Station.findById(id);
    station.readings.add(reading);
    station.save();
    redirect ("/stations/" + id);
  }
}
