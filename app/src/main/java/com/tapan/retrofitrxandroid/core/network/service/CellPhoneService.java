package com.tapan.retrofitrxandroid.core.network.service;

import com.tapan.retrofitrxandroid.core.network.response.CellPhoneResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Handle the API services
 *
 * @author Tapan Rana (ttapan.rana@gmail.com)
 */
public interface CellPhoneService {

  @Headers({ "Content-Type:application/json" })
  @GET("cellphone/db")
  Single<CellPhoneResponse> getCellPhoneContent();
}
