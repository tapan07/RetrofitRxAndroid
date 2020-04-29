package com.tapan.retrofitrxandroid.home.presenter;

import android.util.Log;
import com.tapan.retrofitrxandroid.R;
import com.tapan.retrofitrxandroid.core.base.presenter.BasePresenter;
import com.tapan.retrofitrxandroid.core.network.callback.CellPhoneAPIHandler;
import com.tapan.retrofitrxandroid.core.network.response.CellPhoneResponse;
import com.tapan.retrofitrxandroid.core.rx.BaseObserver;
import com.tapan.retrofitrxandroid.core.util.CoreConstants;
import com.tapan.retrofitrxandroid.home.callback.HomeListener;
import com.tapan.retrofitrxandroid.home.view.HomeView;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter<V extends HomeView> extends BasePresenter<V>
    implements HomeListener<V> {

  private static final String TAG = "HomePresenter";

  public HomePresenter() {
  }

  @Override
  public void getCellPhoneContent() {
    if (getView() != null) {
      if (getView().isNetworkConnected()) {
        processCellPhoneContent();
      } else {
        getView().showError(R.string.msg_network_error);
      }
    }
  }

  /**
   * Retrieve the cell phone data
   */
  private void processCellPhoneContent() {
    getView().showLoading();
    CellPhoneAPIHandler cellPhoneAPIHandler = new CellPhoneAPIHandler(CoreConstants.DB_URL);
    cellPhoneContentRequest(cellPhoneAPIHandler);
  }

  /**
   * Subscribing the cellphone content
   *
   * @param cellPhoneAPIHandler API handler
   */
  private void cellPhoneContentRequest(CellPhoneAPIHandler cellPhoneAPIHandler) {
    cellPhoneAPIHandler.getCellPhoneContent()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(cellPhoneContentObserver());
  }

  /**
   * Handle the success/error response of cell phone content
   *
   * @return Single observer of result
   */
  private SingleObserver<? super CellPhoneResponse> cellPhoneContentObserver() {
    return new BaseObserver<CellPhoneResponse>() {
      @Override
      public void onSuccess(CellPhoneResponse response) {
        getView().hideLoading();
        lazySet(DisposableHelper.DISPOSED);
        getView().updateCellPhoneContent(response.getCellPhones());
      }

      @Override
      public void onError(Throwable ex) {
        getView().hideLoading();
        Log.e(TAG, ex.getMessage());
      }
    };
  }
}
