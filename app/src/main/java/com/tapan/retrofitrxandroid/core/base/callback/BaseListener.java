package com.tapan.retrofitrxandroid.core.base.callback;

import com.tapan.retrofitrxandroid.core.base.view.BaseView;

public interface BaseListener<V extends BaseView> {

  void onAttach(V view);

  void onDetach();

  void handleError(Throwable error);
}
