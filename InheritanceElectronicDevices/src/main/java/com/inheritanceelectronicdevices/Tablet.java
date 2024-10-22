package com.inheritanceelectronicdevices;

public class Tablet extends Device
{
    protected double deviceBatteryLife;
    protected boolean deviceHasStylus;

    public Tablet(String deviceName,
                  double devicePrice,
                  double deviceWeight,
                  double deviceBatteryLife,
                  boolean deviceHasStylus)
    {
        super(DeviceType.TABLET, deviceName, devicePrice, deviceWeight);
        this.deviceBatteryLife = deviceBatteryLife;
        this.deviceHasStylus = deviceHasStylus;
    }

    public double getDeviceBatteryLife()
    {
        return deviceBatteryLife;
    }
    public boolean getDeviceHasStylus()
    {
        return deviceHasStylus;
    }

    public void setDeviceBatteryLife(double deviceBatteryLife)
    {
        this.deviceBatteryLife = deviceBatteryLife;
    }
    public void setDeviceHasStylus(boolean deviceHasStylus)
    {
        this.deviceHasStylus = deviceHasStylus;
    }
}
