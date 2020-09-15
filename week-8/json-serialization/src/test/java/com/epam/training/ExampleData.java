package com.epam.training;

import java.util.List;

public class ExampleData {

  private final String string;
  private final int primitiveInt;
  private final Integer boxedInt;
  private final Long boxedLong;
  private final Double boxedDouble;
  private final List<String> stringList;
  private final InnerData innerData;
  private final boolean aBoolean;

  public ExampleData(String string, int primitiveInt, Integer boxedInt, Long boxedLong, Double boxedDouble, List<String> stringList, InnerData innerData, boolean aBoolean) {
    this.string = string;
    this.primitiveInt = primitiveInt;
    this.boxedInt = boxedInt;
    this.boxedLong = boxedLong;
    this.boxedDouble = boxedDouble;
    this.stringList = stringList;
    this.innerData = innerData;
    this.aBoolean = aBoolean;
  }

  public String getString() {
    return string;
  }

  public int getPrimitiveInt() {
    return primitiveInt;
  }

  public Integer getBoxedInt() {
    return boxedInt;
  }

  public Long getBoxedLong() {
    return boxedLong;
  }

  public Double getBoxedDouble() {
    return boxedDouble;
  }

  public List<String> getStringList() {
    return stringList;
  }

  public InnerData getInnerData() {
    return innerData;
  }

  public boolean isaBoolean() {
    return aBoolean;
  }

  public static class InnerData {
    private final String innerString;
    private final int innerPrimitiveInt;
    private final Object nullObject = null;

    public InnerData(String innerString, int innerPrimitiveInt) {
      this.innerString = innerString;
      this.innerPrimitiveInt = innerPrimitiveInt;
    }

    public String getInnerString() {
      return innerString;
    }

    public int getInnerPrimitiveInt() {
      return innerPrimitiveInt;
    }

    public Object getNullObject() {
      return nullObject;
    }
  }

}

