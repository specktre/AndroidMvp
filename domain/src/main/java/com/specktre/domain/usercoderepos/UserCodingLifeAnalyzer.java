package com.specktre.domain.usercoderepos;

import com.specktre.domain.coderepo.CodeRepo;

import java.util.List;

public interface UserCodingLifeAnalyzer {

    public boolean isProgrammerInLanguage(String language, List<CodeRepo> userCodeRepos);

    public boolean isStar(List<CodeRepo> userCodeRepos);

    String mostRatedRepo(List<CodeRepo> userCodeRepos);
}
