package com.inheritanceelectronicdevices;

public class Smartphone extends Device
{
    protected double deviceScreenSize;
    protected double deviceCameraResolution;

    public Smartphone(String deviceName,
                      double devicePrice,
                      double deviceWeight,
                      double deviceScreenSize,
                      double deviceCameraResolution)
    {
        super(DeviceType.SMARTPHONE, deviceName, devicePrice, deviceWeight);
        this.deviceScreenSize = deviceScreenSize;
        this.deviceCameraResolution = deviceCameraResolution;
    }

    public double getDeviceScreenSize()
    {
        return deviceScreenSize;
    }
    public double getDeviceCameraResolution()
    {
        return deviceCameraResolution;
    }

    public void setDeviceScreenSize(double deviceScreenSize)
    {
        this.deviceScreenSize = deviceScreenSize;
    }
    public void setDeviceCameraResolution(double deviceCameraResolution)
    {
        this.deviceCameraResolution = deviceCameraResolution;
    }
}