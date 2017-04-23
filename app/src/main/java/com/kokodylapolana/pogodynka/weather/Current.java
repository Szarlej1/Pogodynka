package com.kokodylapolana.pogodynka.weather;

import com.kokodylapolana.pogodynka.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Marcin B on 2017-04-15.
 */

public class Current {
    private String mIcon;
    private long mTime;
    private double mTemperature;
    private double mHumidity;
    private double mPrecipChange;
    private String mSummary;

    public String getTimeZone() {
        return mTimeZone;
    }

    public void setTimeZone(String timeZone) {
        mTimeZone = timeZone;
    }

    private String mTimeZone;

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public int getIconId() {
        return Forecast.getIconId(mIcon);
    }

    public long getTime() {
        return mTime;
    }
    public String getFormattedTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("H:mm");
        formatter.setTimeZone(TimeZone.getTimeZone(getTimeZone())); // wymaga dostarczenia informacji na teamt strefy czasowej
        Date dateTime = new Date(getTime() * 1000); // getTime zwraca czas w formacie UNiXa w sekundach. Date chce formatu w milisekundach
        String timeString = formatter.format(dateTime);

        return timeString;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public int getTemperature() {
        return (int) Math.round(mTemperature);
    }

    public void setTemperature(double temperature) {
        mTemperature = temperature;
    }

    public double getHumidity() {
        return mHumidity;
    }

    public void setHumidity(double humidity) {
        mHumidity = humidity;
    }

    public int getPrecipChange() {
        double precipPercentage = mPrecipChange * 100;
        return (int)Math.round(precipPercentage);
    }

    public void setPrecipChange(double precipChange) {
        mPrecipChange = precipChange;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }
}
