package com.tapan.retrofitrxandroid.home.callback;

import com.tapan.retrofitrxandroid.core.base.callback.BaseListener;
import com.tapan.retrofitrxandroid.home.view.HomeView;

public interface HomeListener<V extends HomeView> extends BaseListener<V> {

  void getCellPhoneContent();
}
