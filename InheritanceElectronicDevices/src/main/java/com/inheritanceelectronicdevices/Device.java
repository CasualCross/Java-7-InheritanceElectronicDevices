package com.inheritanceelectronicdevices;

public class Device
{
    public enum DeviceType
    {
        SMARTPHONE,
        LAPTOP,
        TABLET;
    }

    protected String deviceName;
    protected double devicePrice;
    protected double deviceWeight;
    protected DeviceType deviceType;

    Device(DeviceType deviceType, String deviceName, double devicePrice, double deviceWeight)
    {
        this.deviceName = deviceName;
        this.devicePrice = devicePrice;
        this.deviceWeight = deviceWeight;
        this.deviceType = deviceType;
    }

    //GETTERS
    public String getDeviceName()
    {
        return deviceName;
    }
    public double getDevicePrice()
    {
        return devicePrice;
    }
    public double getDeviceWeight()
    {
        return deviceWeight;
    }
    public DeviceType getDeviceType()
    {
        return deviceType;
    }

    //SETTERS
    public void setDeviceName(String deviceName)
    {
        this.deviceName = deviceName;
    }
    public void setDevicePrice(double devicePrice)
    {
        this.devicePrice = devicePrice;
    }
    public void setDeviceWeight(double deviceWeight)
    {
        this.deviceWeight = deviceWeight;
    }
    public void setDeviceType(DeviceType deviceType)
    {
        this.deviceType = deviceType;
    }
}
