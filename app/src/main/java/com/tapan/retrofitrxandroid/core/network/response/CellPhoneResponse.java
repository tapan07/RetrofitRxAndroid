package com.tapan.retrofitrxandroid.core.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CellPhoneResponse {

  @SerializedName("cellphone")
  @Expose
  private List<CellPhone> cellPhones;

  public List<CellPhone> getCellPhones() {
    return cellPhones;
  }

  public void setCellPhones(List<CellPhone> cellPhones) {
    this.cellPhones = cellPhones;
  }
}
