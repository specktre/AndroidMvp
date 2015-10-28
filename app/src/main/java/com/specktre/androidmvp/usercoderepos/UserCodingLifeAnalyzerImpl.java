package com.specktre.androidmvp.usercoderepos;

import com.specktre.domain.coderepo.CodeRepo;
import com.specktre.domain.usercoderepos.UserCodingLifeAnalyzer;

import java.util.List;

public class UserCodingLifeAnalyzerImpl implements UserCodingLifeAnalyzer {
    @Override
    public boolean isProgrammerInLanguage(String language, List<CodeRepo> userCodeRepos) {
        return false;
    }

    @Override
    public boolean isStar(List<CodeRepo> userCodeRepos) {
        return false;
    }

    @Override
    public String mostRatedRepo(List<CodeRepo> userCodeRepos) {
        return "Test";
    }
}
