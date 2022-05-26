//Class to control what is displayed on the dashboard
package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Member;
import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller
{
  //Method to display all stations on the dashboard
  public static void index()
  {
    Logger.info("Rendering Admin");
    List<Station> stations = Station.findAll();
    render ("dashboard.html", stations);
  }

  //Version 5: Method to delete a station
  public static void deleteStation (Long id)
  {
    Station station = Station.findById(id);
    Logger.info ("Removing" + station.name);
    station.delete();
    redirect ("/dashboard");
  }

  //Version 3: Method to add a new station
  public static void addStation(String name)
  {
    Station station = new Station (name, 0,0,0, 0,0,0,0);
    Logger.info ("Adding a new station called " + name);
    station.save();
    redirect ("/dashboard");
  }
}
