package com.specktre.domain.usercoderepos;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

public interface UserCodeReposView extends MvpLceView<UserCodingLifeViewModel> {

    String getUsername();
}
