package com.tapan.retrofitrxandroid.core.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CellPhone {

  @SerializedName("id")
  @Expose
  private int id;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("imageUrl")
  @Expose
  private String imageUrl;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
