package utils;
/*Separate class to perform calculations on weather readings*/
import models.Reading;

import java.util.HashMap;
import java.util.List;

public class StationAnalytics {
    //Version 2: Method to return the last weather code
    public static int getCode(List<Reading> readings) {
        int lastCode = 0;
        if (readings.size() > 0) {
            lastCode = readings.size();
            for (Reading reading : readings) {
                lastCode = reading.code;
            }
        }
        return lastCode;
    }
    //Version 2: Method to return the weather description based on the weather code
    public static String getWeather(List<Reading> readings) {
        String lastWeather = null;
        if (readings.size() > 0) {
            for (Reading reading : readings) {
                if (reading.code == 100) {
                    lastWeather = "Clear";
                } else if (reading.code == 200) {
                    lastWeather = "partial clouds";
                } else if (reading.code == 300) {
                    lastWeather = "Cloudy";
                } else if (reading.code == 400) {
                    lastWeather = "Light Showers";
                } else if (reading.code == 500) {
                    lastWeather = "Heavy Showers";
                } else if (reading.code == 600) {
                    lastWeather = "Rain";
                } else if (reading.code == 700) {
                    lastWeather = "Snow";
                } else if (reading.code == 800) {
                    lastWeather = "Thunder";
                }
            }
        }
        return lastWeather;
    }
    //Version 4: Method to display a weather icon appropriate to the weather conditions
    public static String getIcon(List<Reading> readings) {
        int code = 0;
        HashMap<Integer, String> weatherIcons = null;
        if (readings.size() > 0) {
            code = readings.size();
            for (Reading reading : readings) {
                code = reading.code;
                {
                    weatherIcons = new HashMap<Integer, String>();
                    weatherIcons.put(0, "big red exclamation circle icon");
                    weatherIcons.put(100, "big orange sun icon");
                    weatherIcons.put(200, "big yellow cloud sun icon");
                    weatherIcons.put(300, "big white cloud icon");
                    weatherIcons.put(400, "big blue cloud sun rain icon");
                    weatherIcons.put(500, "big grey cloud showers heavy icon");
                    weatherIcons.put(600, "big grey cloud rain icon");
                    weatherIcons.put(700, "big blue snowflake icon");
                    weatherIcons.put(800, "big yellow bolt icon");
                }
            }
            return weatherIcons.get(code);
        }
        else {
            code = 0;
        }
        return null;
    }
//Version 2: method to return the most recent temperature in celcius
    public static float getTemp(List<Reading> readings) {
        float lastTemp = 0;
        if (readings.size() > 0) {
            lastTemp = readings.size();
            for (Reading reading : readings) {
                lastTemp = reading.temperature;
            }
        }
        return lastTemp;
    }

    //Version 2: Method for calculating the temperature in fahrenheit
    public static float getTempF(List<Reading> readings) {
        float lastTempF = 0;
        if (readings.size() > 0) {
            lastTempF = readings.size();
            for (Reading reading : readings) {
                lastTempF = (float) (((reading.temperature) * 1.8) + 32);
            }
        }
        return lastTempF;
    }

    //Version 4: Method to calculate the lowest temperature
    public static float getMinTemp(List<Reading> readings) {
        float minTemp = 0;
        if (readings.size() > 0) {
            minTemp = readings.size();
            for (Reading reading : readings) {
                if (reading.temperature < minTemp) {
                    minTemp = reading.temperature;
                }
            }
        }
        return minTemp;
    }

    //Version 4: Method to calculate the highest temperature
    public static float getMaxTemp(List<Reading> readings) {
        float maxTemp = 0;
        if (readings.size() > 0) {
            maxTemp = readings.size();
            for (Reading reading : readings) {
                if (reading.temperature > maxTemp) {
                    maxTemp = reading.temperature;
                }
            }
        }
        return maxTemp;
    }

    //Version 2: method to return the latest reading for wind speed in km/hr
    public static float getWindSpeed(List<Reading> readings) {
        float lastWindSpeed = 0;
        if (readings.size() > 0) {
            lastWindSpeed = readings.size();
            for (Reading reading : readings) {
                lastWindSpeed = reading.windSpeed;
            }
        }
        return lastWindSpeed;
    }

    //Version 4: method for determining the lowest wind speed
    public static float getMinWind(List<Reading> readings) {
        float minWind = 0;
        if (readings.size() > 0) {
            minWind = readings.size();
            for (Reading reading : readings) {
                if (reading.windSpeed < minWind) {
                    minWind = reading.windSpeed;
                }
            }
        }
        return minWind;
    }

    //Version 4: method for determining the highest wind speed
    public static float getMaxWind(List<Reading> readings) {
        float maxWind = 0;
        if (readings.size() > 0) {
            maxWind = readings.size();
            for (Reading reading : readings) {
                if (reading.windSpeed > maxWind) {
                    maxWind = reading.windSpeed;
                }
            }
        }
        return maxWind;
    }

    //Version 2: method to determine the Beaufort reading based on the wind speed
    public static int getBeaufort(List<Reading> readings) {
        int lastWind = 0;
        String Beau = null;
        if (readings.size() > 0) {
            lastWind = readings.size();
            for (Reading reading : readings) {
                if (reading.windSpeed == 1) {
                    lastWind = 0;
                    Beau = "Calm";
                } else if ((reading.windSpeed >= 1) && (reading.windSpeed <= 5)) {
                    lastWind = 1;
                    Beau = "Light air";
                } else if ((reading.windSpeed >= 6) && (reading.windSpeed <= 11)) {
                    lastWind = 2;
                    Beau = "Light breeze";
                } else if ((reading.windSpeed >= 12) && (reading.windSpeed <= 19)) {
                    lastWind = 3;
                    Beau = "Gentle breeze";
                } else if ((reading.windSpeed >= 20) && (reading.windSpeed <= 28)) {
                    lastWind = 4;
                    Beau = "Moderate breeze";
                } else if ((reading.windSpeed >= 29) && (reading.windSpeed <= 38)) {
                    lastWind = 5;
                    Beau = "Fresh breeze";
                } else if ((reading.windSpeed >= 39) && (reading.windSpeed <= 49)) {
                    lastWind = 6;
                    Beau = "Strong breeze";
                } else if ((reading.windSpeed >= 50) && (reading.windSpeed <= 61)) {
                    lastWind = 7;
                    Beau = "Near Gale";
                } else if ((reading.windSpeed >= 62) && (reading.windSpeed <= 74)) {
                    lastWind = 8;
                    Beau = "Gale";
                } else if ((reading.windSpeed >= 75) && (reading.windSpeed <= 88)) {
                    lastWind = 9;
                    Beau = "Severe Gale";
                } else if ((reading.windSpeed >= 89) && (reading.windSpeed <= 102)) {
                    lastWind = 10;
                    Beau = "Strong storm";
                } else if ((reading.windSpeed >= 103) && (reading.windSpeed <= 117)) {
                    lastWind = 11;
                    Beau = "Violent Storm";
                }
            }
        }
        return lastWind;
    }

    //Version 2: method for determining the Beaufort label based on the wind speed
    public static String getBeau(List<Reading> readings) {
        String Beau = null;
        if (readings.size() > 0) {
            for (Reading reading : readings) {
                if (reading.windSpeed == 1) {
                    Beau = "Calm";
                } else if ((reading.windSpeed >= 1) && (reading.windSpeed <= 5)) {
                    Beau = "Light air";
                } else if ((reading.windSpeed >= 6) && (reading.windSpeed <= 11)) {
                    Beau = "Light breeze";
                } else if ((reading.windSpeed >= 12) && (reading.windSpeed <= 19)) {
                    Beau = "Gentle breeze";
                } else if ((reading.windSpeed >= 20) && (reading.windSpeed <= 28)) {
                    Beau = "Moderate breeze";
                } else if ((reading.windSpeed >= 29) && (reading.windSpeed <= 38)) {
                    Beau = "Fresh breeze";
                } else if ((reading.windSpeed >= 39) && (reading.windSpeed <= 49)) {
                    Beau = "Strong breeze";
                } else if ((reading.windSpeed >= 50) && (reading.windSpeed <= 61)) {
                    Beau = "Near Gale";
                } else if ((reading.windSpeed >= 62) && (reading.windSpeed <= 74)) {
                    Beau = "Gale";
                } else if ((reading.windSpeed >= 75) && (reading.windSpeed <= 88)) {
                    Beau = "Severe Gale";
                } else if ((reading.windSpeed >= 89) && (reading.windSpeed <= 102)) {
                    Beau = "Strong storm";
                } else if ((reading.windSpeed >= 103) && (reading.windSpeed <= 117)) {
                    Beau = "Violent Storm";
                }
            }
        }
        return Beau;
    }

    //Version 2: Method to return the last wind direction
    public static int getWindDir(List<Reading> readings) {
        int lastWindDir = 0;
        if (readings.size() > 0) {
            lastWindDir = readings.size();
            for (Reading reading : readings) {
                lastWindDir = reading.windDirection;
            }
        }
        return lastWindDir;
    }

    //Version 3: Method to calculate the wind Compass from wind direction
    public static String getWindComp(List<Reading> readings) {
        String windComp = null;
        if (readings.size() > 0) {
            for (Reading reading : readings) {
                if ((reading.windDirection >= 348.75) && (reading.windDirection <= 11.25)) {
                    windComp = "North";
                } else if ((reading.windDirection >= 11.25) && (reading.windDirection <= 33.75)) {
                    windComp = "North North East";
                } else if ((reading.windDirection >= 33.76) && (reading.windDirection <= 56.25)) {
                    windComp = "North East";
                } else if ((reading.windDirection >= 56.26) && (reading.windDirection <= 78.75)) {
                    windComp = "East North East";
                } else if ((reading.windDirection >= 78.76) && (reading.windDirection <= 101.25)) {
                    windComp = "East";
                } else if ((reading.windDirection >= 101.26) && (reading.windDirection <= 123.75)) {
                    windComp = "East South East";
                } else if ((reading.windDirection >= 123.76) && (reading.windDirection <= 146.25)) {
                    windComp = "South East";
                } else if ((reading.windDirection >= 146.26) && (reading.windDirection <= 168.75)) {
                    windComp = "South South East";
                } else if ((reading.windDirection >= 168.76) && (reading.windDirection <= 191.25)) {
                    windComp = "South";
                } else if ((reading.windDirection >= 191.26) && (reading.windDirection <= 213.75)) {
                    windComp = "South South West";
                } else if ((reading.windDirection >= 213.76) && (reading.windDirection <= 236.25)) {
                    windComp = "South West";
                } else if ((reading.windDirection >= 236.26) && (reading.windDirection <= 258.75)) {
                    windComp = "West South West";
                } else if ((reading.windDirection >= 258.76) && (reading.windDirection <= 281.25)) {
                    windComp = "West";
                } else if ((reading.windDirection >= 281.26) && (reading.windDirection <= 303.75)) {
                    windComp = "West North West";
                } else if ((reading.windDirection >= 303.76) && (reading.windDirection <= 326.25)) {
                    windComp = "North West";
                } else if ((reading.windDirection >= 326.26) && (reading.windDirection <= 348.75)) {
                    windComp = "North North West";
                }
            }
        }
        return windComp;
    }

    //Version 3: Method to calculate the windchill
    public static float getWindChill(List<Reading> readings) {
        float windChill = 0;
        if (readings.size() > 0) {
            windChill = readings.size();
            for (Reading reading : readings) {
                windChill = (float) ((13.12 + (reading.temperature * 0.6215)) - (Math.pow(reading.windSpeed, 0.16) * 11.37)
                        + (0.3965 * reading.temperature * (Math.pow(reading.windSpeed, 0.16))));
            }
        }
        return windChill;
    }

    //Version 2: Method to return the last Pressure reading
    public static int getPressure(List<Reading> readings) {
        int lastPressure = 0;
        if (readings.size() > 0) {
            lastPressure = readings.size();
            for (Reading reading : readings) {
                lastPressure = reading.pressure;
            }
        }
        return lastPressure;
    }

    //Version 4: Method to determine the lowest pressure reading
    public static int getMinPressure(List<Reading> readings) {
        int minPressure = 0;
        if (readings.size() > 0) {
            minPressure = readings.size();
            for (Reading reading : readings) {
                if (reading.pressure < minPressure) {
                    minPressure = reading.pressure;
                }
            }
        }
        return minPressure;
    }

    //Version 4: Method to determine the highest pressure reading
    public static int getMaxPressure(List<Reading> readings) {
        int maxPressure = 0;
        if (readings.size() > 0) {
            maxPressure = readings.size();
            for (Reading reading : readings) {
                if (reading.pressure > maxPressure) {
                    maxPressure = reading.pressure;
                }
            }
        }
        return maxPressure;
    }
}
