package com.inheritanceelectronicdevices;

public class Laptop extends Device
{
    protected int deviceRamSize;
    protected String deviceProcessorType;

    public Laptop(String deviceName,
                  double devicePrice,
                  double deviceWeight,
                  int deviceRamSize,
                  String deviceProcessorType)
    {
        super(DeviceType.LAPTOP, deviceName, devicePrice, deviceWeight);
        this.deviceRamSize = deviceRamSize;
        this.deviceProcessorType = deviceProcessorType;
    }

    public int getDeviceRamSize()
    {
        return deviceRamSize;
    }
    public String getDeviceProcessorType()
    {
        return deviceProcessorType;
    }

    public void setDeviceRamSize(int deviceRamSize)
    {
        this.deviceRamSize = deviceRamSize;
    }
    public void setDeviceProcessorType(String deviceProcessorType)
    {
        this.deviceProcessorType = deviceProcessorType;
    }
}
