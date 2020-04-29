package com.tapan.retrofitrxandroid.core.network.callback;

import com.tapan.retrofitrxandroid.core.network.response.CellPhoneResponse;
import com.tapan.retrofitrxandroid.core.network.service.CellPhoneService;
import io.reactivex.Single;

/**
 * API handler to fetch the cell phone content
 *
 * @author Tapan Rana (ttapan.rana@gmail.com)
 */
public class CellPhoneAPIHandler {

  private String baseUrl;

  public CellPhoneAPIHandler(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  /**
   * Retrieve the content of a web page
   *
   * @return {@link Single} result of the content
   */
  public Single<CellPhoneResponse> getCellPhoneContent() {
    CellPhoneService cellPhoneService = RetrofitHandler.getRetrofitInstance(baseUrl)
        .create(CellPhoneService.class);

    return cellPhoneService.getCellPhoneContent();
  }
}
